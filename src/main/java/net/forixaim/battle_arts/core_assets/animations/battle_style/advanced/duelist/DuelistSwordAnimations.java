package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.damagesource.StunType;

public class DuelistSwordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIR_ATTACK;
    public static AnimationManager.AnimationAccessor<AttackAnimation> QUAD_STING;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/duelist/sword/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        WALK = builder.nextAccessor("battle_style/advanced/duelist/sword/walk", access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.3f));

        RUN = builder.nextAccessor("battle_style/advanced/duelist/sword/run", access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.3f));


        AUTO1 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto1", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.45f, 0.6f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));
        AUTO2 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto2", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.55f, 0.7f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO3 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto3", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        DASH_ATTACK = builder.nextAccessor("battle_style/advanced/duelist/sword/dash_attack", access ->
                new DashAttackAnimation(0.2f, 0.0f, 0.3f, 0.45f, 1.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1));

        AIR_ATTACK = builder.nextAccessor("battle_style/advanced/duelist/sword/aerial", access ->
                new AirSlashAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1.9f, false, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)

                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1.3f));

        QUAD_STING = builder.nextAccessor("battle_style/advanced/duelist/sword/quadsting", access ->
                new AttackAnimation(0.2f, access, Armatures.BIPED, new AttackAnimation.Phase(
                        0.0f, 0.0f, 0.5f, 0.6f, 0.65f, 0.65f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        0.65f, 0.0f, 0.65f, 0.75f, 0.8f, 0.8f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        0.8f, 0.0f, 0.8f, 0.9f, 1.1f, 1.1f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        1.1f, 0.0f, 1.1f, 1.2f, 2f, 2f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.4f));
    }
}
