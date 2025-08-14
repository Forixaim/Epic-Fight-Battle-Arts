package net.forixaim.battle_arts.core_assets.events.player;

import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.entity.eventlistener.AbstractPlayerEvent;

public class PlayerReviveEvent<T extends PlayerPatch<?>> extends AbstractPlayerEvent<T>
{

    public PlayerReviveEvent(T playerPatch)
    {
        super(playerPatch, false);
    }
}
