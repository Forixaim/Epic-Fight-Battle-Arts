package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.entries.EpicFightCreativeTabs;


public final class BattleArtsCreativeTabs
{
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BattleArts.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_ITEMS = REGISTRY.register("items", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.battle_arts.items"))
			.icon(() -> new ItemStack(BattleArtsItems.IRON_SABRE))
			.withTabsBefore(EpicFightCreativeTabs.ITEMS.getId()).hideTitle()
			.backgroundTexture(ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, "textures/gui/battle_arts.png"))
			.displayItems((params, output) -> BattleArtsItems.REGISTRY.getEntries().forEach(item ->
                    {
                        if ((item.get() instanceof TieredItem ti && ti.getTier() == SpecialTiers.STEEL) || item == BattleArtsItems.TACHI_SHEATH)
                        {
                            return;
                        }
                        output.accept(item.get());
                    }))
			.build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PVP_ITEMS = REGISTRY.register("pvp_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.battle_arts.pvp_items"))
            .icon(() -> new ItemStack(BattleArtsItems.STEEL_SABRE))
            .withTabsBefore(MAIN_ITEMS.getId()).hideTitle()
            .backgroundTexture(ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, "textures/gui/battle_arts.png"))
            .displayItems((params, output) -> BattleArtsItems.REGISTRY.getEntries().forEach(item ->
            {
                if (item.get() instanceof TieredItem ti && ti.getTier() == SpecialTiers.STEEL)
                    output.accept(item.get());
            }))
            .build());

}
