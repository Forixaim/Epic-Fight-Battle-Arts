package net.forixaim.battle_arts.core_assets.world.entity_patch;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.client.particle.TrailParticleType;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import net.forixaim.battle_arts.initialization.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.client.animation.property.TrailInfo;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.particle.EpicFightParticles;
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
    public void onAddedToWorld() {
        LogUtils.getLogger().debug("onAddedToWorld");
        if (this.getOriginal().level().isClientSide()) {

        }

    }

    @Override
    public EpicFightDamageSource createEpicFightDamageSource()
    {
        return new EpicFightDamageSource(this.getOriginal().level().damageSources().generic());
    }
}
