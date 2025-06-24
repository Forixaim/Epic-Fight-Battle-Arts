package net.forixaim.battle_arts.core_assets.skills.battlestyle;

import yesman.epicfight.world.entity.eventlistener.MovementInputEvent;

import java.util.function.Consumer;

public class CommonInputLocks
{
    public static final Consumer<MovementInputEvent> LOCK_MOVEMENT_USING_ITEM = event -> {
        if (event.getPlayerPatch().getOriginal().isUsingItem())
        {
            event.getMovementInput().forwardImpulse = 0;
            event.getMovementInput().leftImpulse = 0;
            event.getMovementInput().jumping = false;
        }
    };
}
