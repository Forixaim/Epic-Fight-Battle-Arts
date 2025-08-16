package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class MercenaryGreatswordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO4;

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
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.65f, 0.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));
    }
}
