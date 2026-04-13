package net.forixaim.battle_arts.core_assets.animations.battle_style.unique.iron_lotus;

import net.forixaim.battle_arts.core_assets.animations.BattleArtsEntityStates;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.ActionAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.world.damagesource.StunType;

public class IronLotusAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<ActionAnimation> DASH;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> AXE_DIVE;



    public static void Build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/unique/iron_lotus/fist/idle", access ->
                new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        DASH = builder.nextAccessor("battle_style/unique/iron_lotus/fist/dash", access ->
                new ActionAnimation(0.05f, access, Armatures.BIPED)
                        .addState(EntityState.CAN_SKILL_EXECUTION, false)
                        .addState(EntityState.CAN_BASIC_ATTACK, false)
                        .addState(EntityState.CAN_USE_ITEM, false)
                        .addState(BattleArtsEntityStates.DASHING, true));

        AUTO1 = builder.nextAccessor("battle_style/unique/iron_lotus/fist/auto1", access ->
                new BasicAttackAnimation(0.1f, 0.0f, 0.1f, 0.2f, 0.25f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.2F));

        AUTO2 = builder.nextAccessor("battle_style/unique/iron_lotus/fist/auto2", access ->
                new BasicAttackAnimation(0.1f, 0.0f, 0.1f, 0.2f, 0.25f, null, Armatures.BIPED.get().toolL,  access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.2F));

        AUTO3 = builder.nextAccessor("battle_style/unique/iron_lotus/fist/auto3", access ->
                new BattleArtsComboAttackAnimation(0.1f, 0.0f, 0.1f, 0.2f, 1.0f, null, Armatures.BIPED.get().legR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 0.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.5)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.2F));

        DASH_ATTACK = builder.nextAccessor("battle_style/unique/iron_lotus/fist/dash_attack", access ->
                new BattleArtsComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.4f, 1.0f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 15.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.5)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 5.0F));

        AXE_DIVE = builder.nextAccessor("battle_style/unique/iron_lotus/fist/axe_dive", access ->
                new BattleArtsComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.25f, 1.0f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, -90.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.5)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 5.0F)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime >= 0.2F && elapsedTime < 0.25F) {
                                float dpx = (float) livingEntityPatch.getOriginal().getX();
                                float dpy = (float) livingEntityPatch.getOriginal().getY();
                                float dpz = (float) livingEntityPatch.getOriginal().getZ();

                                for(BlockState block = livingEntityPatch.getOriginal().level().getBlockState(new BlockPos.MutableBlockPos(dpx, dpy, dpz)); (block.getBlock() instanceof BushBlock || block.isAir()) && !block.is(Blocks.VOID_AIR); block = livingEntityPatch.getOriginal().level().getBlockState(new BlockPos.MutableBlockPos(dpx, dpy, dpz))) {
                                    --dpy;
                                }

                                float distanceToGround = (float)Math.max(Math.abs(livingEntityPatch.getOriginal().getY() - (double)dpy) - (double)1.0F, 0.0F);
                                LivingEntity livingentity = livingEntityPatch.getOriginal();
                                Vec3f direction = new Vec3f(0, -1.5F, 0.0F);
                                OpenMatrix4f rotation = new OpenMatrix4f().rotate(-(float)Math.toRadians(livingEntityPatch.getOriginal().yBodyRotO + 90.0F), new Vec3f(0.0F, 1.0F, 0.0F));
                                OpenMatrix4f.transform3v(rotation, direction, direction);
                                if (distanceToGround > 0.5F) {
                                    livingentity.move(MoverType.SELF, direction.toDoubleVector());
                                    return 0.025F;
                                } else {
                                    return speed;
                                }
                            } else {
                                return speed;
                            }
                        }));





    }
}
