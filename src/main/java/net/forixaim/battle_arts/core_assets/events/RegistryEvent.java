package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegistryEvent
{
    @SubscribeEvent
    public static void registerMovesetDefinitions(EntityJoinLevelEvent event)
    {
        if (event.getEntity() instanceof ThrownTrident)
        {
            event.getEntity().addTag(BattleArtsEntityTags.PUNCTURE_LEVEL_1.toString());
        }
    }


}
