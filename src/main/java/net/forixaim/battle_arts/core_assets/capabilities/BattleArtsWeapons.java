package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.initialization.registry.ItemRegistry;
import net.forixaim.efm_ex.api.events.ExCapWeaponRegistryEvent;
import net.forixaim.efm_ex.capabilities.CoreCapability;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.item.EpicFightItems;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BattleArtsWeapons
{
    public static CoreCapability BATTLE_AXE;

    @SubscribeEvent
    public static void registerCapabilities(final ExCapWeaponRegistryEvent event)
    {
        event.getExCapWeapons().put(EpicFightBattleArts.MOD_ID, BattleArtsWeapons::build);
    }

    public static void build()
    {
        BATTLE_AXE = CoreCapability.quickStart(
                builder -> builder.category(BattleStyleCategories.BATTLE_AXE)
                        .collider(ColliderPreset.LONGSWORD)
                        .hitSound(EpicFightSounds.BLADE_HIT.get())
                        .swingSound(EpicFightSounds.WHOOSH_BIG.get())
        );

        CoreCapability.addSheath(EpicFightItems.IRON_TACHI.get(), ItemRegistry.TACHI_SHEATH.get());
        CoreCapability.addSheath(EpicFightItems.GOLDEN_TACHI.get(), ItemRegistry.TACHI_SHEATH.get());
        CoreCapability.addSheath(EpicFightItems.DIAMOND_TACHI.get(), ItemRegistry.TACHI_SHEATH.get());
        CoreCapability.addSheath(EpicFightItems.NETHERITE_TACHI.get(), ItemRegistry.TACHI_SHEATH.get());
    }
}
