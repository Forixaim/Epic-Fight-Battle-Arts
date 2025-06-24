package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = EpicFightBattleArts.MOD_ID)
public class ParticleRegistry
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, EpicFightBattleArts.MOD_ID);
}
