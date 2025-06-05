package net.forixaim.battle_arts.core_assets.events;


import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerItemRenderers(PatchedRenderersEvent.RegisterItemRenderer event)
    {
        LogUtils.getLogger().debug("Registering item renderers");
    }


}
