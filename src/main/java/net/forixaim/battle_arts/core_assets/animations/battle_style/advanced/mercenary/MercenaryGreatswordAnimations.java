package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsIdleAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;

public class MercenaryGreatswordAnimations
{
    public static AnimationManager.AnimationAccessor<BattleArtsIdleAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> FLAUNT;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> SPRINT;
    public static AnimationManager.AnimationAccessor<StaticAnimation> CROUCH;

    public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> AIRSLAM;
    public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> FIERCE_UPPER;
    public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> POWER_GEYSER;



    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/idle", access -> new BattleArtsIdleAnimation(0.2f, access, Armatures.BIPED));
        CROUCH = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/crouch", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        WALK = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/walk", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.5f));
        RUN = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/run", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED));
        SPRINT = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/sprint", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED));
        GUARD = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        FLAUNT = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/flair", access -> new StaticAnimation(0.5f, false, access, Armatures.BIPED));
        GUARD_HIT = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_hit", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_1 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_parry1", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_2 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_parry2", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));

        AUTO1 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto1", access ->
                new ComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.35f, 0.6f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));

        AUTO2 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto2", access ->
                new ComboAttackAnimation(0.2f, 0.0f, 0.2f, 0.35f, 0.7f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));

        AUTO3 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto3", access ->
                new ComboAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO4 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto4", access ->
                new ComboAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 1.2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        DASH_ATTACK = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/dash_attack", access ->
                new DashAttackAnimation(0.1f, 0.0f, 0.3f, 0.35f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.4f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -4.0F), Armatures.BIPED.get().toolR, 1.1, 2F)));

        FIERCE_UPPER = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/fierce_upper", access ->
                new BattleArtsAttackAnimation(0.2f, 0.0f, 0.5f, 0.7f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 75d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        POWER_GEYSER = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/power_geyser", access ->
                new BattleArtsAttackAnimation(0.2f, 0.0f, 0.8f, 0.9f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.1f))
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 3.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 75d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.3f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.9f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.3F, -5.0F), Armatures.BIPED.get().toolR, 1.1, 1.55F)));

        AIRSLAM = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/airslam", access ->
                new BattleArtsComboAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 30d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3f))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0f, 0.5f))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.7f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 1.1, 0.55F)));
    }
}
