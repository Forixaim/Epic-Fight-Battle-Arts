package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.fighter;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerHeavySpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import yesman.epicfight.api.animation.AnimationManager;

public class FighterAnimations {
    public static void listen(AnimationManager.AnimationBuilder builder)
    {
        FighterBattleaxeAnimations.build(builder);
    }
}
