package net.forixaim.battle_arts.core_assets.animations;


import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.BattleStyleRegistry;

import yesman.epicfight.api.animation.AnimationManager;

/**
 * Chakram Animation Module,
 */
public class BattleAnimations
{
	public static void Listen(AnimationManager.AnimationRegistryEvent event)
	{
		event.newBuilder(BattleArts.MOD_ID, BattleStyleRegistry::Listen);
	}
}
