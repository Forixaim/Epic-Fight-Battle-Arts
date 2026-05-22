package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class SquireGreatswordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> CROUCH;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> CROUCH_WALK;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/novice/squire/greatsword/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        CROUCH = builder.nextAccessor("battle_style/novice/squire/greatsword/crouch", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        WALK = builder.nextAccessor("battle_style/novice/squire/greatsword/walk", access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.5f));
        RUN = builder.nextAccessor("battle_style/novice/squire/greatsword/run", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED));
        CROUCH_WALK = builder.nextAccessor("battle_style/novice/squire/greatsword/crouch_walk", access -> new MovementAnimation(0.4f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 3.5f));
    }
}
