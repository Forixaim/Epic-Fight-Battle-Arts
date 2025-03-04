package net.forixaim.battle_arts.core_assets.animations;


import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.BattleStyleRegistry;
import net.forixaim.efm_ex.client.renderers.SheathRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.world.item.EpicFightItems;

/**
 * Chakram Animation Module,
 */
@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BattleAnimations
{
	@SubscribeEvent
	public static void Listen(AnimationManager.AnimationRegistryEvent event)
	{
		event.newBuilder(EpicFightBattleArts.MOD_ID, BattleStyleRegistry::Listen);
	}

	@SubscribeEvent
	public static void sheathRegistry(PatchedRenderersEvent.Add event)
	{
		event.addItemRenderer(EpicFightItems.IRON_TACHI.get(), new SheathRenderers());
		event.addItemRenderer(EpicFightItems.GOLDEN_TACHI.get(), new SheathRenderers());
		event.addItemRenderer(EpicFightItems.DIAMOND_TACHI.get(), new SheathRenderers());
		event.addItemRenderer(EpicFightItems.NETHERITE_TACHI.get(), new SheathRenderers());
	}
}
