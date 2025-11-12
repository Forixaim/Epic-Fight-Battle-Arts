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
            double entityId = Double.longBitsToDouble(this.getOriginal().getId());
            this.getOriginal().level().addParticle(new TrailParticleType(TrailInfo.builder()
                    .type(EpicFightParticles.PROJECTILE_TRAIL.get())
                    .r(0.859f)
                    .g(0.996f)
                    .b(1)
                    .startPos(new Vec3(1.5D, -0D, -0.0D))
                    .endPos(new Vec3(-1.0D, 3.7D, 0.0D))
                    .interpolations(4)
                    .lifetime(20)
                    .updateInterval(1)
                    .texture(ResourceLocation.fromNamespaceAndPath(EpicFightMod.MODID, "textures/particle/projectile_trail.png"))
                    .create(), ParticleRegistry.PROJECTILE_TRAIL.get()), entityId, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        }

    }

    @Override
    public EpicFightDamageSource createEpicFightDamageSource()
    {
        return new EpicFightDamageSource(this.getOriginal().level().damageSources().generic());
    }
}
