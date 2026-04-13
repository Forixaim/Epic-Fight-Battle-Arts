package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.client.particle.TrailParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = BattleArts.MOD_ID)
public class ParticleRegistry
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, BattleArts.MOD_ID);
    public static final RegistryObject<SimpleParticleType> SPECIAL_RING = PARTICLES.register("special_ring", () -> new SimpleParticleType(true));
    public static final RegistryObject<TrailParticleType> PROJECTILE_TRAIL = PARTICLES.register("projectile_trail", () -> new TrailParticleType(true));
}
