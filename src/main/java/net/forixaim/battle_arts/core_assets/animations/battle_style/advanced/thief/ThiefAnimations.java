package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief;

import yesman.epicfight.api.animation.AnimationManager;

public class ThiefAnimations
{
    public static void listen(AnimationManager.AnimationBuilder builder)
    {
        ThiefDaggerAnimations.build(builder);
    }
}
