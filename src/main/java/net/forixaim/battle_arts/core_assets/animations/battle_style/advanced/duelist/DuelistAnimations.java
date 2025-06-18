package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.utils.math.OpenMatrix4f;

public class DuelistAnimations
{
    OpenMatrix4f matrix4f = new OpenMatrix4f();
    public static void listen(AnimationManager.AnimationBuilder builder)
    {
        DuelistSwordAnimations.build(builder);
        DuelistDualbladesAnimations.build(builder);
    }

}
