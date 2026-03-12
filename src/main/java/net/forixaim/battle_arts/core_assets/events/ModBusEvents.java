package net.forixaim.battle_arts.core_assets.events;


import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.client.particle.BattleArtsProjectileTrailParticle;
import net.forixaim.battle_arts.core_assets.client.particle.SpecialMoveParticle;
import net.forixaim.battle_arts.initialization.registry.ParticleRegistry;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = BattleArts.MOD_ID, value = {Dist.CLIENT})
public class ModBusEvents
{
    @SubscribeEvent
    public static void registerParticle(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ParticleRegistry.SPECIAL_RING.get(), SpecialMoveParticle.Provider::new);
        event.registerSpecial(ParticleRegistry.PROJECTILE_TRAIL.get(), BattleArtsProjectileTrailParticle.createRecord());
    }

}
