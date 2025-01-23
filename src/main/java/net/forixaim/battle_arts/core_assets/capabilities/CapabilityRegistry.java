package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.efm_ex.capabilities.weapon_presets.ExCapWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.Locale;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry
{
    public static final Function<Item, CapabilityItem.Builder> BATTLE_AXE = item -> BattleArtsWeapons.BATTLE_AXE.export();

    private static ResourceLocation name(String name)
    {
        return new ResourceLocation(EpicFightBattleArts.MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    @SubscribeEvent
    public static void Register(WeaponCapabilityPresetRegistryEvent Event)
    {
        Event.getTypeEntry().put(name("battle_axe"), BATTLE_AXE);
    }
}
