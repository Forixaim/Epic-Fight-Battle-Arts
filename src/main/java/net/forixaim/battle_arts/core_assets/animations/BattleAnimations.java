package net.forixaim.battle_arts.core_assets.animations;


import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.BattleStyleRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;

/**
 * Chakram Animation Module,
 */
@Mod.EventBusSubscriber(modid = BattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BattleAnimations
{
	@SubscribeEvent
	public static void Listen(AnimationManager.AnimationRegistryEvent event)
	{
		event.newBuilder(BattleArts.MOD_ID, BattleStyleRegistry::Listen);
	}
}
