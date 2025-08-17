package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackBasicAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

public class MercenaryGreatswordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> CROUCH;

    public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<KnockbackBasicAttackAnimation> AIRSLAM;
    public static AnimationManager.AnimationAccessor<KnockbackAttackAnimation> FIERCE_UPPER;


    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        CROUCH = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/crouch", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));


        GUARD = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        GUARD_HIT = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_hit", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_1 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_parry1", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_2 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/guard_parry2", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));

        AUTO1 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto1", access ->
                new BasicAttackAnimation(0.4f, 0.0f, 0.3f, 0.5f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO2 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto2", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO3 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto3", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO4 = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/auto4", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 1.2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        DASH_ATTACK = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/dash_attack", access ->
                new DashAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.7f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 1.1, 0.55F)));

        FIERCE_UPPER = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/fierce_upper", access ->
                new KnockbackAttackAnimation(0.2f, 0.0f, 0.5f, 0.7f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 2.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 75d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));


        AIRSLAM = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/airslam", access ->
                new KnockbackBasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 30d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3f))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0f, 0.5f))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.7f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 1.1, 0.55F)));
    }
}
