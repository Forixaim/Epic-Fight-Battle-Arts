package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer;

import yesman.epicfight.api.animation.AnimationManager;

public class LancerAnimations
{
    public static void listen(AnimationManager.AnimationBuilder builder)
    {
        LancerSpearAnimations.build(builder);
        LancerHeavySpearAnimations.build(builder);
    }
}
