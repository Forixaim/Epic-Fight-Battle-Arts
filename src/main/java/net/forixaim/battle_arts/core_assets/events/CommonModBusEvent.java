package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.core_assets.world.entities.TestEuclidiaEntity;
import net.forixaim.battle_arts.core_assets.world.entity_patch.TestEuclidiaHumanoid;
import net.forixaim.battle_arts.initialization.registry.BattleArtsEntities;
import net.forixaim.battle_arts.core_assets.world.entity_patch.FlyingShockwavePatch;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import yesman.epicfight.api.client.event.types.registry.RegisterPatchedRenderersEvent;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.event.types.registry.EntityPatchRegistryEvent;
import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;
import yesman.epicfight.world.capabilities.entitypatch.Factions;
import yesman.epicfight.world.capabilities.projectile.ArrowPatch;

public class CommonModBusEvent
{
    public static void registerEntityPatch(EntityPatchRegistryEvent event)
    {
        event.registerEntityPatch(BattleArtsEntities.FLYING_SHOCKWAVE.get(),FlyingShockwavePatch::new);
        event.registerEntityPatch(BattleArtsEntities.FIXED_ARROW.get(), ArrowPatch::new);
        event.registerEntityPatch(BattleArtsEntities.TEST_EUCLIDIA.get(), testEuclidiaEntity -> new TestEuclidiaHumanoid(testEuclidiaEntity, Factions.NEUTRAL));
    }

    public static void registerPatchedRenderer(RegisterPatchedRenderersEvent.AddEntity event)
    {
        var context = event.getContext();
        event.addPatchedEntityRenderer(BattleArtsEntities.TEST_EUCLIDIA.get(), entityType -> new PHumanoidRenderer<>(Meshes.BIPED_OLD_TEX, context, entityType).initLayerLast(context, entityType));

    }

    public static void onInitAttributes(EntityAttributeCreationEvent event)
    {
        event.put(BattleArtsEntities.TEST_EUCLIDIA.get(), TestEuclidiaEntity.createAttributes().build());
    }
}
