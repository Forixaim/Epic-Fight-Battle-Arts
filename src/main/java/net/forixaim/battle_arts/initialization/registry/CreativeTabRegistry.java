package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.entries.EpicFightCreativeTabs;


public class CreativeTabRegistry
{
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BattleArts.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_ITEMS = CREATIVE_MODE_TABS.register("items", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.battle_arts.items"))
			.icon(() -> new ItemStack(ItemRegistry.IRON_SABRE))
			.withTabsBefore(EpicFightCreativeTabs.ITEMS.getId()).hideTitle()
			.backgroundTexture(ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, "textures/gui/battle_arts.png"))
			.displayItems((params, output) -> ItemRegistry.ITEMS.getEntries().forEach(item ->
                    {
                        if (item == ItemRegistry.TACHI_SHEATH)
                        {
                            return;
                        }
                        output.accept(item.get());
                    }))
			.build());

}
