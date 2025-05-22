package net.forixaim.battle_arts.core_assets.capabilities;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.EpicFightBattleArts;
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
    public static final Function<Item, CapabilityItem.Builder> BATTLE_AXE = item -> {
        try
        {
            return BattleArtsWeapons.BATTLE_AXE.export();
        }
        catch (final NoSuchMethodError e)
        {
            LogUtils.getLogger().warn(e.getMessage());
            return BattleArtsWeapons.BATTLE_AXE.export(true);
        }
    };

    private static ResourceLocation name(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    @SubscribeEvent
    public static void Register(WeaponCapabilityPresetRegistryEvent Event)
    {
        Event.getTypeEntry().put(name("battle_axe"), BATTLE_AXE);
    }
}
