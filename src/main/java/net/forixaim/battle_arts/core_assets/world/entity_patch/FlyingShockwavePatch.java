package net.forixaim.battle_arts.core_assets.world.entity_patch;

import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import yesman.epicfight.world.capabilities.projectile.ProjectilePatch;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;

public class FlyingShockwavePatch extends ProjectilePatch<FlyingShockwaveProjectile>
{

    @Override
    protected void setMaxStrikes(FlyingShockwaveProjectile flyingShockwaveProjectile, int i)
    {
        flyingShockwaveProjectile.setMaxStrikes(i);
    }

    @Override
    public EpicFightDamageSource createEpicFightDamageSource()
    {
        return null;
    }
}
