package net.forixaim.battle_arts.core_assets.events.player;

import net.minecraftforge.fml.LogicalSide;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

public class BattleArtsPlayerEvents
{
    public static final PlayerEventListener.EventType<PlayerDeathEvent<ServerPlayerPatch>> PLAYER_DEATH_EVENT = new PlayerEventListener.EventType<>(LogicalSide.SERVER);
    public static final PlayerEventListener.EventType<PlayerReviveEvent<ServerPlayerPatch>> PLAYER_REVIVE_EVENT = new PlayerEventListener.EventType<>(LogicalSide.SERVER);


}
