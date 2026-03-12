package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.ComboAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;

public class SquireMountAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/novice/squire/mounted/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
                .addProperty(AnimationProperty.StaticAnimationProperty.ON_ITEM_CHANGE_EVENT,
                        AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK_WHEN_MOUNT_AND_ITEM_CHANGED, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS,
                        AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK_WHEN_MOUNT, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS,
                        AnimationEvent.Side.CLIENT)));
        AUTO1 = builder.nextAccessor("battle_style/novice/squire/mounted/auto1", access -> new ComboAttackAnimation(0.2f, 0.0f, 0.6f, 0.7f, 0.8f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
        AUTO2 = builder.nextAccessor("battle_style/novice/squire/mounted/auto2", access -> new ComboAttackAnimation(0.2f, 0.0f, 0.35f, 0.5f, 1.5f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
    }
}
