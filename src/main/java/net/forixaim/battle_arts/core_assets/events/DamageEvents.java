package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.events.player.BattleArtsPlayerEvents;
import net.forixaim.battle_arts.core_assets.events.player.PlayerDeathEvent;
import net.forixaim.battle_arts.core_assets.events.player.PlayerReviveEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

@Mod.EventBusSubscriber(modid = BattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DamageEvents
{
    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event)
    {
        if (event.getEntity() instanceof Player player)
        {
            if (player.level().isClientSide)
                return;
            ServerPlayerPatch serverPlayer = EpicFightCapabilities.getEntityPatch(player, ServerPlayerPatch.class);
            if (serverPlayer.getEventListener().triggerEvents(BattleArtsPlayerEvents.PLAYER_DEATH_EVENT, new PlayerDeathEvent<>(serverPlayer, event.getSource())))
            {
                event.setCanceled(true);
                serverPlayer.getEventListener().triggerEvents(BattleArtsPlayerEvents.PLAYER_REVIVE_EVENT, new PlayerReviveEvent<>(serverPlayer));
            }
        }
    }
}
