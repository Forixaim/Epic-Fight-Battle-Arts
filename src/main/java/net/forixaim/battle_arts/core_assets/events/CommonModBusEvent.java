package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.entity_patch.FlyingShockwavePatch;
import yesman.epicfight.api.event.types.registry.EntityPatchRegistryEvent;
import yesman.epicfight.world.capabilities.projectile.ArrowPatch;

public class CommonModBusEvent
{
    public static void registerEntityPatch(EntityPatchRegistryEvent event)
    {
        event.registerEntityPatch(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(),FlyingShockwavePatch::new);
        event.registerEntityPatch(BattleArtsProjectiles.FIXED_ARROW.get(), ArrowPatch::new);
    }
}
