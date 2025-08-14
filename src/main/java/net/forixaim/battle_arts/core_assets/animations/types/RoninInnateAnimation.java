package net.forixaim.battle_arts.core_assets.animations.types;

import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.minecraft.core.particles.ParticleGroup;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;

import java.util.List;
import java.util.Objects;

public class RoninInnateAnimation extends AttackAnimation
{

    public RoninInnateAnimation(float transitionTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature)
    {
        super(transitionTime, antic, preDelay, contact, recovery, collider, colliderJoint, accessor, armature);
    }

    public RoninInnateAnimation(float transitionTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature)
    {
        super(transitionTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, accessor, armature);
    }

    public RoninInnateAnimation(float transitionTime, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature, Phase... phases)
    {
        super(transitionTime, accessor, armature, phases);
    }

    public RoninInnateAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, String path, AssetAccessor<? extends Armature> armature)
    {
        super(convertTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, path, armature);
    }

    public RoninInnateAnimation(float convertTime, String path, AssetAccessor<? extends Armature> armature, Phase... phases)
    {
        super(convertTime, path, armature, phases);
    }

    @Override
    protected void hurtCollidingEntities(LivingEntityPatch<?> entitypatch, float prevElapsedTime, float elapsedTime, EntityState prevState, EntityState state, Phase phase)
    {
        LivingEntity entity = entitypatch.getOriginal();
        float prevPoseTime = prevState.attacking() ? prevElapsedTime : phase.preDelay;
        float poseTime = state.attacking() ? elapsedTime : phase.contact;
        List<Entity> list = this.getPhaseByTime(elapsedTime).getCollidingEntities(entitypatch, this, prevPoseTime, poseTime, this.getPlaySpeed(entitypatch, this));
        if (!list.isEmpty()) {
            HitEntityList hitEntities = new HitEntityList(entitypatch, list, phase.getProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY).orElse(HitEntityList.Priority.DISTANCE));
            int maxStrikes = this.getMaxStrikes(entitypatch, phase);

            while(entitypatch.getCurrentlyActuallyHitEntities().size() < maxStrikes && hitEntities.next()) {
                Entity target = hitEntities.getEntity();
                if (target instanceof Projectile projectile && projectile.getOwner() != entitypatch.getOriginal())
                {
                    if (!projectile.getTags().contains(BattleArtsEntityTags.PUNCTURE_LEVEL_1.toString()))
                    {
                        target.level().addParticle(ParticleTypes.EXPLOSION, target.getX(), target.getY(), target.getZ(), 0.0D, 0.0D, 0.0D);
                        target.level().playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.GENERIC_EXPLODE, target.getSoundSource(), 1.0F, 1.0F);
                        projectile.discard();
                    }
                }
                else if (!teammateCheck(target, entity))
                {
                    LivingEntity trueEntity = this.getTrueEntity(target);
                    if (trueEntity != null && trueEntity.isAlive() && !entitypatch.getCurrentlyAttackTriedEntities().contains(trueEntity) && !entitypatch.isTargetInvulnerable(target) && (target instanceof LivingEntity || target instanceof PartEntity) && entity.hasLineOfSight(target)) {
                        EpicFightDamageSource damagesource = this.getEpicFightDamageSource(entitypatch, target, phase);
                        int prevInvulTime = target.invulnerableTime;
                        target.invulnerableTime = 0;
                        AttackResult attackResult = entitypatch.attack(damagesource, target, phase.hand);
                        target.invulnerableTime = prevInvulTime;
                        if (attackResult.resultType.dealtDamage()) {
                            target.level().playSound(null, target.getX(), target.getY(), target.getZ(), this.getHitSound(entitypatch, phase), target.getSoundSource(), 1.0F, 1.0F);
                            this.spawnHitParticle((ServerLevel)target.level(), entitypatch, target, phase);
                        }

                        entitypatch.getCurrentlyAttackTriedEntities().add(trueEntity);
                        if (attackResult.resultType.shouldCount()) {
                            entitypatch.getCurrentlyActuallyHitEntities().add(trueEntity);
                        }
                    }
                }

            }
        }
    }
    private boolean teammateCheck(Entity target, LivingEntity attacker)
    {
        if (!target.level().isClientSide())
        {
            if (target instanceof LivingEntity livingEntity)
            {
                if (target instanceof TamableAnimal pet)
                {
                    if (pet.getOwner() == attacker)
                    {
                        return true;
                    } else if (!pet.isAggressive())
                    {
                        return true;
                    } else if (pet.getOwner() != null)
                    {
                        if (pet.getOwner().getTeam() != null)
                        {
                            if (pet.getOwner().getTeam() == attacker.getTeam())
                            {
                                return true;
                            }
                            if (pet.getOwner().getTeam().isAlliedTo(attacker.getTeam()))
                            {
                                return true;
                            }
                        }
                        if (pet.getOwner() instanceof Player)
                        {
                            if (!Objects.requireNonNull(pet.level().getServer()).isPvpAllowed())
                                return true;
                        }
                    }
                }
                if (target.getTeam() != null)
                {
                    if (target.getTeam() == attacker.getTeam())
                    {
                        return true;
                    }
                    return target.getTeam().isAlliedTo(attacker.getTeam());
                }
            }
            return false;
        }
        return true;
    }
}
