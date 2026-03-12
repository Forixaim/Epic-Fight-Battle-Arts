package net.forixaim.battle_arts.core_assets.world.projectiles;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class FixedArrow extends Arrow
{
    @Nullable
    private IntOpenHashSet piercingIgnoreEntityIds;
    @Nullable
    private List<Entity> piercedAndKilledEntities;
    private AnimationManager.AnimationAccessor<? extends AttackAnimation> attack = Animations.FIST_AUTO1;
    private AttackAnimation.Phase phase = null;
    int lifetime = 100;
    int lifetimeMultiplier = 1;
    double fixedDamage = 0.0;
    public FixedArrow(EntityType<? extends Arrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void setFixedDamage(double fixedDamage)
    {
        this.fixedDamage = fixedDamage;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        lifetimeMultiplier = 4;
    }

    public void setPhase(AttackAnimation.Phase phase) {
        this.phase = phase;
    }

    @Override
    public void tick() {
        super.tick();
        if (lifetime < 1)
            discard();
        lifetime -= lifetimeMultiplier;
    }

    public void setAttack(AnimationManager.AnimationAccessor<? extends AttackAnimation> attack) {
        this.attack = attack;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        if (this.getPierceLevel() > 0) {
            if (this.piercingIgnoreEntityIds == null) {
                this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
            }

            if (this.piercedAndKilledEntities == null) {
                this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
            }

            if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
                this.discard();
                return;
            }

            this.piercingIgnoreEntityIds.add(entity.getId());
        }


        Entity entity1 = this.getOwner();
        DamageSource damagesource;
        if (entity1 == null) {
            damagesource = this.damageSources().arrow(this, this);
        } else {
            damagesource = this.damageSources().arrow(this, entity1);
            if (entity1 instanceof LivingEntity) {
                ((LivingEntity)entity1).setLastHurtMob(entity);
            }
        }

        boolean flag = entity.getType() == EntityType.ENDERMAN;
        int k = entity.getRemainingFireTicks();
        if (this.isOnFire() && !flag) {
            entity.igniteForSeconds(5);
        }
        if (EpicFightCapabilities.getEntityPatch(entity1, LivingEntityPatch.class) instanceof PlayerPatch<?> playerPatch)
        {
            EpicFightDamageSource damageSource = playerPatch.getDamageSource(attack, InteractionHand.MAIN_HAND);
            if (phase != null && damageSource.getAnimation() instanceof AttackAnimation atk)
            {
                phase = atk.phases[0];
            }
            if (playerPatch.attack(damageSource, entity, InteractionHand.MAIN_HAND).resultType == AttackResult.ResultType.SUCCESS) {
                entity.invulnerableTime = 0;
                if (flag) {
                    return;
                }

                if (entity instanceof LivingEntity livingentity) {
                    if (!this.level().isClientSide && this.getPierceLevel() <= 0) {
                        livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                    }

                    this.doPostHurtEffects(livingentity);
                    if (livingentity != entity1 && livingentity instanceof Player && entity1 instanceof ServerPlayer && !this.isSilent()) {
                        ((ServerPlayer)entity1).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                    }

                    if (!entity.isAlive() && this.piercedAndKilledEntities != null) {
                        this.piercedAndKilledEntities.add(livingentity);
                    }

                    if (!this.level().isClientSide && entity1 instanceof ServerPlayer) {
                        ServerPlayer serverplayer = (ServerPlayer)entity1;
                        if (this.piercedAndKilledEntities != null && this.shotFromCrossbow()) {
                            CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, this.piercedAndKilledEntities);
                        } else if (!entity.isAlive() && this.shotFromCrossbow()) {
                            CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, Arrays.asList(entity));
                        }
                    }
                }

                this.playSound(this.getDefaultHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                if (this.getPierceLevel() <= 0) {
                    this.discard();
                }
            } else {
                entity.setRemainingFireTicks(k);
                this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
                this.setYRot(this.getYRot() + 180.0F);
                this.yRotO += 180.0F;
                if (!this.level().isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
                    if (this.pickup == AbstractArrow.Pickup.ALLOWED) {
                        this.spawnAtLocation(this.getPickupItem(), 0.1F);
                    }

                    this.discard();
                }
            }
        }
        else
        {
            if (entity.hurt(damagesource, (float) fixedDamage)) {
                entity.invulnerableTime = 0;
                if (flag) {
                    return;
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity)entity;
                    if (!this.level().isClientSide && this.getPierceLevel() <= 0) {
                        livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                    }

                    this.doPostHurtEffects(livingentity);
                    if (entity1 != null && livingentity != entity1 && livingentity instanceof Player && entity1 instanceof ServerPlayer && !this.isSilent()) {
                        ((ServerPlayer)entity1).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                    }

                    if (!entity.isAlive() && this.piercedAndKilledEntities != null) {
                        this.piercedAndKilledEntities.add(livingentity);
                    }

                    if (!this.level().isClientSide && entity1 instanceof ServerPlayer) {
                        ServerPlayer serverplayer = (ServerPlayer)entity1;
                        if (this.piercedAndKilledEntities != null && this.shotFromCrossbow()) {
                            CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, this.piercedAndKilledEntities);
                        } else if (!entity.isAlive() && this.shotFromCrossbow()) {
                            CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, Arrays.asList(entity));
                        }
                    }
                }

                this.playSound(this.getDefaultHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
                if (this.getPierceLevel() <= 0) {
                    this.discard();
                }
            } else {
                entity.setRemainingFireTicks(k);
                this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
                this.setYRot(this.getYRot() + 180.0F);
                this.yRotO += 180.0F;
                if (!this.level().isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
                    if (this.pickup == AbstractArrow.Pickup.ALLOWED) {
                        this.spawnAtLocation(this.getPickupItem(), 0.1F);
                    }

                    this.discard();
                }
            }
        }

    }
}
