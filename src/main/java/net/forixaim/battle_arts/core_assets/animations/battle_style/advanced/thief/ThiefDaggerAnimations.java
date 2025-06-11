package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireAnimations;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class ThiefDaggerAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/thief/dagger/idle", access ->
                new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        AUTO1 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto1",
                accessor -> new BasicAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));
        AUTO2 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto2",
                accessor -> new BasicAttackAnimation(0.2f, 0f, 0.3f, 0.45f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));
        AUTO3 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto3",
                accessor -> new BasicAttackAnimation(0.2f, 0f, 0.55f, 0.65f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));
    }
}
