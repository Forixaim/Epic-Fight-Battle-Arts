package net.forixaim.battle_arts.core_assets.world.projectiles;

import net.forixaim.battle_arts.core_assets.world.FlyingShockwaveProjectile;
import yesman.epicfight.world.capabilities.projectile.ProjectilePatch;

public class FlyingShockwavePatch extends ProjectilePatch<FlyingShockwaveProjectile>
{

    @Override
    protected void setMaxStrikes(FlyingShockwaveProjectile flyingShockwaveProjectile, int i)
    {
        flyingShockwaveProjectile.setMaxStrikes(i);
    }
}
