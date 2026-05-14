package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.client.particle.TrailParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class BattleArtsParticles
{
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, BattleArts.MOD_ID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPECIAL_RING = REGISTRY.register("special_ring", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, TrailParticleType> PROJECTILE_TRAIL = REGISTRY.register("projectile_trail", () -> new TrailParticleType(true));
}
