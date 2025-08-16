package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary;

import yesman.epicfight.api.animation.AnimationManager;

public class MercenaryAnimations
{
    public static void listen(AnimationManager.AnimationBuilder builder)
    {
        MercenaryGreatswordAnimations.build(builder);
    }
}
