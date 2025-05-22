package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.world.item.EpicFightCreativeTabs;


public class CreativeTabRegistry
{
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EpicFightBattleArts.MOD_ID);

	public static final RegistryObject<CreativeModeTab> MAIN_ITEMS = CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.battle_arts.items"))
			.icon(() -> new ItemStack(ItemRegistry.IRON_SABRE.get()))
			.withTabsBefore(EpicFightCreativeTabs.ITEMS.getId()).hideTitle()
			.withBackgroundLocation(ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "textures/gui/battle_arts.png"))
			.displayItems((params, output) -> {
				ItemRegistry.ITEMS.getEntries().forEach(item ->
						{
							if (item == ItemRegistry.TACHI_SHEATH)
							{
								return;
							}
							output.accept(item.get());
						});
			})
			.build());

}
