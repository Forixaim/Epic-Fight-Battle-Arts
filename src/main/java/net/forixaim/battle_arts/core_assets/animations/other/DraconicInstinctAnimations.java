package net.forixaim.battle_arts.core_assets.animations.other;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.ActionAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class DraconicInstinctAnimations
{
    public static AnimationManager.AnimationAccessor<ActionAnimation> DODGE_1;
    public static AnimationManager.AnimationAccessor<ActionAnimation> DODGE_2;
    public static AnimationManager.AnimationAccessor<ActionAnimation> DODGE_3;
    public static AnimationManager.AnimationAccessor<ActionAnimation> DODGE_4;
    public static void build(AnimationManager.AnimationBuilder builder)
    {
        DODGE_1 = builder.nextAccessor("general/draconic_instinct/dodge1", access -> new ActionAnimation(0.1f, access, Armatures.BIPED));
        DODGE_2 = builder.nextAccessor("general/draconic_instinct/dodge2", access -> new ActionAnimation(0.1f, access, Armatures.BIPED));
        DODGE_3 = builder.nextAccessor("general/draconic_instinct/dodge3", access -> new ActionAnimation(0.1f, access, Armatures.BIPED));
        DODGE_4 = builder.nextAccessor("general/draconic_instinct/dodge4", access -> new ActionAnimation(0.1f, access, Armatures.BIPED));
    }
}
