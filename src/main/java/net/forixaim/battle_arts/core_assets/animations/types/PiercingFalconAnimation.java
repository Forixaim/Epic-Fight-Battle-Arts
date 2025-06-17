package net.forixaim.battle_arts.core_assets.animations.types;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.Keyframe;
import yesman.epicfight.api.animation.TransformSheet;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.HurtableEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.world.effect.EpicFightMobEffects;

import java.util.List;
import java.util.Locale;

public class PiercingFalconAnimation extends AttackAnimation
{

    public PiercingFalconAnimation(float transitionTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
        super(transitionTime, antic, preDelay, contact, recovery, collider, colliderJoint, accessor, armature);
        this.newTimePair(0.0F, Float.MAX_VALUE);
        this.addStateRemoveOld(EntityState.TURNING_LOCKED, true);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, (self, entitypatch, transformSheet) -> {
            LivingEntity attackTarget = entitypatch.getTarget();
            if (!(Boolean)self.getProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE).orElse(false) && attackTarget != null) {
                TransformSheet transform = self.getTransfroms().get("Root").copyAll();
                Keyframe[] keyframes = transform.getKeyframes();
                int startFrame = 0;
                int endFrame = transform.getKeyframes().length - 1;
                Vec3f keyLast = keyframes[endFrame].transform().translation();
                Vec3 pos = entitypatch.getOriginal().getEyePosition();
                Vec3 targetpos = attackTarget.position().add(attackTarget.getDeltaMovement().scale(8.0));
                float horizontalDistance = Math.max((float)targetpos.subtract(pos).horizontalDistance() * 1.3F - (attackTarget.getBbWidth() + entitypatch.getOriginal().getBbWidth()), 0.0F);
                Vec3f worldPosition = new Vec3f(keyLast.x, 0.0F, -horizontalDistance);
                float scale = Math.min(worldPosition.length() / keyLast.length(), 2.0F);

                for(int i = startFrame; i <= endFrame; ++i) {
                    Vec3f translation = keyframes[i].transform().translation();
                    translation.z *= scale;
                }

                transformSheet.readFrom(transform);
            } else {
                transformSheet.readFrom(self.getTransfroms().get("Root"));
            }

        });
    }

    public PiercingFalconAnimation(float transitionTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
        super(transitionTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, accessor, armature);
        this.newTimePair(0.0F, Float.MAX_VALUE);
        this.addStateRemoveOld(EntityState.TURNING_LOCKED, true);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, (self, entitypatch, transformSheet) -> {
            LivingEntity attackTarget = entitypatch.getTarget();
            if (!(Boolean)self.getProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE).orElse(false) && attackTarget != null) {
                TransformSheet transform = self.getTransfroms().get("Root").copyAll();
                Keyframe[] keyframes = transform.getKeyframes();
                int startFrame = 0;
                int endFrame = transform.getKeyframes().length - 1;
                Vec3f keyLast = keyframes[endFrame].transform().translation();
                Vec3 pos = entitypatch.getOriginal().getEyePosition();
                Vec3 targetpos = attackTarget.position().add(attackTarget.getDeltaMovement().scale(8.0));
                float horizontalDistance = Math.max((float)targetpos.subtract(pos).horizontalDistance() * 1.3F - (attackTarget.getBbWidth() + entitypatch.getOriginal().getBbWidth()), 0.0F);
                Vec3f worldPosition = new Vec3f(keyLast.x, 0.0F, -horizontalDistance);
                float scale = Math.min(worldPosition.length() / keyLast.length(), 2.0F);

                for(int i = startFrame; i <= endFrame; ++i) {
                    Vec3f translation = keyframes[i].transform().translation();
                    translation.z *= scale;
                }

                transformSheet.readFrom(transform);
            } else {
                transformSheet.readFrom(self.getTransfroms().get("Root"));
            }

        });
    }

    public PiercingFalconAnimation(float transitionTime, AnimationManager.AnimationAccessor<? extends AttackAnimation> accessor, AssetAccessor<? extends Armature> armature, Phase... phases) {
        super(transitionTime, accessor, armature, phases);
        this.newTimePair(0.0F, Float.MAX_VALUE);
        this.addStateRemoveOld(EntityState.TURNING_LOCKED, true);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, (self, entitypatch, transformSheet) -> {
            LivingEntity attackTarget = entitypatch.getTarget();
            if (!(Boolean)self.getProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE).orElse(false) && attackTarget != null) {
                TransformSheet transform = self.getTransfroms().get("Root").copyAll();
                Keyframe[] keyframes = transform.getKeyframes();
                int startFrame = 0;
                int endFrame = transform.getKeyframes().length - 1;
                Vec3f keyLast = keyframes[endFrame].transform().translation();
                Vec3 pos = entitypatch.getOriginal().getEyePosition();
                Vec3 targetpos = attackTarget.position().add(attackTarget.getDeltaMovement().scale(8.0));
                float horizontalDistance = Math.max((float)targetpos.subtract(pos).horizontalDistance() * 1.3F - (attackTarget.getBbWidth() + entitypatch.getOriginal().getBbWidth()), 0.0F);
                Vec3f worldPosition = new Vec3f(keyLast.x, 0.0F, -horizontalDistance);
                float scale = Math.min(worldPosition.length() / keyLast.length(), 2.0F);

                for(int i = startFrame; i <= endFrame; ++i) {
                    Vec3f translation = keyframes[i].transform().translation();
                    translation.z *= scale;
                }

                transformSheet.readFrom(transform);
            } else {
                transformSheet.readFrom(self.getTransfroms().get("Root"));
            }

        });
    }

    public PiercingFalconAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, String path, AssetAccessor<? extends Armature> armature) {
        super(convertTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, path, armature);
        this.newTimePair(0.0F, Float.MAX_VALUE);
        this.addStateRemoveOld(EntityState.TURNING_LOCKED, true);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, (self, entitypatch, transformSheet) -> {
            LivingEntity attackTarget = entitypatch.getTarget();
            if (!(Boolean)self.getProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE).orElse(false) && attackTarget != null) {
                TransformSheet transform = self.getTransfroms().get("Root").copyAll();
                Keyframe[] keyframes = transform.getKeyframes();
                int startFrame = 0;
                int endFrame = transform.getKeyframes().length - 1;
                Vec3f keyLast = keyframes[endFrame].transform().translation();
                Vec3 pos = entitypatch.getOriginal().getEyePosition();
                Vec3 targetpos = attackTarget.position().add(attackTarget.getDeltaMovement().scale(8.0));
                float horizontalDistance = Math.max((float)targetpos.subtract(pos).horizontalDistance() * 1.3F - (attackTarget.getBbWidth() + entitypatch.getOriginal().getBbWidth()), 0.0F);
                Vec3f worldPosition = new Vec3f(keyLast.x, 0.0F, -horizontalDistance);
                float scale = Math.min(worldPosition.length() / keyLast.length(), 2.0F);

                for(int i = startFrame; i <= endFrame; ++i) {
                    Vec3f translation = keyframes[i].transform().translation();
                    translation.z *= scale;
                }

                transformSheet.readFrom(transform);
            } else {
                transformSheet.readFrom(self.getTransfroms().get("Root"));
            }

        });
    }

    public PiercingFalconAnimation(float convertTime, String path, AssetAccessor<? extends Armature> armature, Phase... phases) {
        super(convertTime, path, armature, phases);
        this.newTimePair(0.0F, Float.MAX_VALUE);
        this.addStateRemoveOld(EntityState.TURNING_LOCKED, true);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE);
        this.addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, (self, entitypatch, transformSheet) -> {
            LivingEntity attackTarget = entitypatch.getTarget();
            if (!(Boolean)self.getProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE).orElse(false) && attackTarget != null) {
                TransformSheet transform = self.getTransfroms().get("Root").copyAll();
                Keyframe[] keyframes = transform.getKeyframes();
                int startFrame = 0;
                int endFrame = transform.getKeyframes().length - 1;
                Vec3f keyLast = keyframes[endFrame].transform().translation();
                Vec3 pos = entitypatch.getOriginal().getEyePosition();
                Vec3 targetpos = attackTarget.position().add(attackTarget.getDeltaMovement().scale(8.0));
                float horizontalDistance = Math.max((float)targetpos.subtract(pos).horizontalDistance() * 1.3F - (attackTarget.getBbWidth() + entitypatch.getOriginal().getBbWidth()), 0.0F);
                Vec3f worldPosition = new Vec3f(keyLast.x, 0.0F, -horizontalDistance);
                float scale = Math.min(worldPosition.length() / keyLast.length(), 2.0F);

                for(int i = startFrame; i <= endFrame; ++i) {
                    Vec3f translation = keyframes[i].transform().translation();
                    translation.z *= scale;
                }

                transformSheet.readFrom(transform);
            } else {
                transformSheet.readFrom(self.getTransfroms().get("Root"));
            }

        });
    }

    @Override
    public void begin(LivingEntityPatch<?> entitypatch) {
        super.begin(entitypatch);

        entitypatch.setLastAttackSuccess(false);
    }


    protected void hurtCollidingEntities(LivingEntityPatch<?> entitypatch, float prevElapsedTime, float elapsedTime, EntityState prevState, EntityState state, Phase phase) {
        LivingEntity attacker = entitypatch.getOriginal();
        float prevPoseTime = prevState.attacking() ? prevElapsedTime : phase.preDelay;
        float poseTime = state.attacking() ? elapsedTime : phase.contact;
        List<Entity> list = this.getPhaseByTime(elapsedTime).getCollidingEntities(entitypatch, this, prevPoseTime, poseTime, this.getPlaySpeed(entitypatch, this));
        if (!list.isEmpty()) {
            HitEntityList hitEntities = new HitEntityList(entitypatch, list, phase.getProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY).orElse(HitEntityList.Priority.DISTANCE));
            int maxStrikes = this.getMaxStrikes(entitypatch, phase);
            while (entitypatch.getCurrenltyHurtEntities().size() < maxStrikes && hitEntities.next())
            {
                Entity target = hitEntities.getEntity();
                LivingEntity trueEntity = this.getTrueEntity(target);
                HurtableEntityPatch<?> hitHurtableEntityPatch = EpicFightCapabilities.getEntityPatch(target, HurtableEntityPatch.class);
                if (trueEntity != null && trueEntity.isAlive() && !entitypatch.getCurrenltyAttackedEntities().contains(trueEntity) && !entitypatch.isTargetInvulnerable(target) && (target instanceof LivingEntity || target instanceof PartEntity) && attacker.hasLineOfSight(target)) {
                    EpicFightDamageSource source = this.getEpicFightDamageSource(entitypatch, target, phase);
                    if (hitHurtableEntityPatch != null) {
                        if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).isPresent()) {
                            if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.NONE) {
                                if (trueEntity instanceof Player) {
                                    source.setStunType(StunType.LONG);
                                    source.setImpact((float) ((double) (source.getImpact() * 4.0F) / (1.0 - trueEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE))));
                                } else {
                                    source.setStunType(StunType.NONE);
                                }
                            } else if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.HOLD && ((LivingEntity) hitHurtableEntityPatch.getOriginal()).hasEffect((MobEffect) EpicFightMobEffects.STUN_IMMUNITY.get())) {
                                source.setStunType(StunType.NONE);
                            } else if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.FALL && ((LivingEntity) hitHurtableEntityPatch.getOriginal()).hasEffect((MobEffect) EpicFightMobEffects.STUN_IMMUNITY.get())) {
                                source.setStunType(StunType.NONE);
                            } else if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.KNOCKDOWN && ((LivingEntity) hitHurtableEntityPatch.getOriginal()).hasEffect((MobEffect) EpicFightMobEffects.STUN_IMMUNITY.get())) {
                                source.setStunType(StunType.NONE);
                            } else {
                                source = this.getEpicFightDamageSource(entitypatch, target, phase);
                            }
                        } else {
                            source = this.getEpicFightDamageSource(entitypatch, target, phase);
                        }
                    }

                    int prevInvulTime = target.invulnerableTime;
                    target.invulnerableTime = 0;
                    AttackResult attackResult = entitypatch.attack(source, target, phase.hand);
                    target.invulnerableTime = prevInvulTime;
                    if (attackResult.resultType.dealtDamage()) {
                        if (source.getStunType() == StunType.KNOCKDOWN) {
                            trueEntity.addEffect(new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 0, true, false, false));
                            if (trueEntity.hasEffect(MobEffects.SLOW_FALLING)) {
                                trueEntity.removeEffect(MobEffects.SLOW_FALLING);
                            }

                            if (trueEntity.hasEffect(MobEffects.SLOW_FALLING)) {
                                trueEntity.removeEffect(MobEffects.SLOW_FALLING);
                            }
                        }

                        target.level().playSound(null, target.getX(), target.getY(), target.getZ(), this.getHitSound(entitypatch, phase), target.getSoundSource(), 1.0F, 1.0F);
                        this.spawnHitParticle((ServerLevel) target.level(), entitypatch, target, phase);
                        if (hitHurtableEntityPatch != null && phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).isPresent() && !hitHurtableEntityPatch.getOriginal().hasEffect((MobEffect) EpicFightMobEffects.STUN_IMMUNITY.get())) {
                            float stunTime;
                            if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.NONE && !(trueEntity instanceof Player)) {
                                stunTime = (float) ((double) (source.getImpact() * 0.4F) * (1.0 - trueEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)));
                                if (hitHurtableEntityPatch.getOriginal().isAlive()) {
                                    hitHurtableEntityPatch.applyStun(source.getStunType() == StunType.KNOCKDOWN ? StunType.KNOCKDOWN : StunType.LONG, stunTime);
                                    float power = source.getImpact() * 0.25F;
                                    double distanceX = attacker.getX() - target.getX();

                                    double distanceZ;
                                    for (distanceZ = attacker.getZ() - target.getZ(); distanceX * distanceX + distanceZ * distanceZ < 1.0E-4; distanceZ = (Math.random() - Math.random()) * 0.01) {
                                        distanceX = (Math.random() - Math.random()) * 0.01;
                                    }

                                    power = (float) ((double) power * (1.0 - trueEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)));

                                    if ((double) power > 0.0) {
                                        target.hasImpulse = true;
                                        Vec3 vec3 = target.getDeltaMovement();
                                        Vec3 vec31 = (new Vec3(distanceX, 0.0, distanceZ)).normalize().scale(power);
                                        target.lookAt(EntityAnchorArgument.Anchor.FEET, attacker.position());
                                        target.setDeltaMovement(vec3.x / 2.0 - vec31.x, target.onGround() ? Math.min(0.4, vec3.y / 2.0) : 0.0, vec3.z / 2.0 - vec31.z);
                                    }
                                }
                            }

                            if (phase.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).get() == StunType.FALL) {
                                stunTime = (float) ((double) (source.getImpact() * 0.4F) * (1.0 - trueEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)));
                                if (hitHurtableEntityPatch.getOriginal().isAlive()) {
                                    hitHurtableEntityPatch.applyStun(source.getStunType() == StunType.KNOCKDOWN ? StunType.KNOCKDOWN : StunType.SHORT, stunTime);
                                    double power = source.getImpact() * 0.3F;
                                    Vec3f directionVector = new Vec3f(0f, 0f, 1f);
                                    OpenMatrix4f rotation = new OpenMatrix4f().rotate(-(float)Math.toRadians(entitypatch.getOriginal().yBodyRotO), new Vec3f(0.0F, 1.0F, 0.0F));
                                    OpenMatrix4f.transform3v(rotation, directionVector, directionVector);
                                    double d1 = directionVector.toDoubleVector().x();
                                    double d0 = directionVector.toDoubleVector().z();
                                    Vec3 lateralDirection = new Vec3(d1, 0, d0).normalize().scale(-1);
                                    double d2 = -0.5;

                                    if (!(trueEntity instanceof Player)) {
                                        power *= 1.0 - trueEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                                    }

                                    if (power > 0.0) {
                                        target.hasImpulse = true;
                                        Vec3 vec3 = attacker.getDeltaMovement();
                                        Vec3 vec31 = (new Vec3(lateralDirection.x(), d2, lateralDirection.z())).normalize().scale(power);
                                        if (!(trueEntity instanceof Player) || !(entitypatch instanceof PlayerPatch)) {
                                            target.setDeltaMovement(vec3.x / 2.0 - vec31.x, vec3.y / 2.0 - vec31.y, vec3.z / 2.0 - vec31.z);
                                        }
                                    }

                                    if (trueEntity instanceof Player && entitypatch instanceof PlayerPatch) {
                                        trueEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, (int) (power * 4.0 * 6.0), true, false, false));
                                    }

                                    trueEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, (int) (power * 8.0 * 6.0), 20, true, false, false));
                                }
                            }
                        }
                    }

                    entitypatch.getCurrenltyAttackedEntities().add(trueEntity);
                    if (attackResult.resultType.shouldCount()) {
                        entitypatch.getCurrenltyHurtEntities().add(trueEntity);
                    }
                }
            }

        }
    }
    @Override
    public void postInit() {
        super.postInit();

        if (!this.properties.containsKey(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED)) {
            float basisSpeed = Float.parseFloat(String.format(Locale.US, "%.2f", (1.0F / this.getTotalTime())));
            this.addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, basisSpeed);
        }
    }
    @Override
    protected Vec3 getCoordVector(LivingEntityPatch<?> entitypatch, AssetAccessor<? extends DynamicAnimation> dynamicAnimation) {
        Vec3 vec3 = super.getCoordVector(entitypatch, dynamicAnimation);

        if (entitypatch.shouldBlockMoving() && this.getProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE).orElse(false)) {
            vec3 = vec3.scale(0.0F);
        }

        return vec3;
    }
}
