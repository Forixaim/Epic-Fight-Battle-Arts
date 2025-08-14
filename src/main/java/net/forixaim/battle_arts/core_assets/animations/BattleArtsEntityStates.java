package net.forixaim.battle_arts.core_assets.animations;

import yesman.epicfight.api.animation.types.EntityState;

public class BattleArtsEntityStates
{
    public static final EntityState.StateFactor<Boolean> DASHING = new EntityState.StateFactor<Boolean>("dashing", false);

    public static boolean isDashing(EntityState state)
    {
        if (state.getState(DASHING) == null)
            return false;
        return state.getState(DASHING);
    }
}
