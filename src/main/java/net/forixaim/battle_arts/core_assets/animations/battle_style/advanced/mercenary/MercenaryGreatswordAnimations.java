package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

public class MercenaryGreatswordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLAM;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
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

        AIRSLAM = builder.nextAccessor("battle_style/advanced/mercenary/greatsword/airslam", access ->
                new AirSlashAnimation(0.2f, 0.0f, 0.5f, 0.65f, 2f, false, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0f, 0.5f))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.7f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 1.1, 0.55F)));
    }
}
