package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwavePatch;
import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.forixaim.battle_arts.initialization.registry.ItemRegistry;
import net.forixaim.efm_ex.api.events.MoveSetDefinitionRegistryEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.client.renderer.patched.item.RenderTwoHandedRangedWeapon;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegistryEvent
{
    @SubscribeEvent
    public static void registerMovesetDefinitions(EntityJoinLevelEvent event)
    {
        if (event.getEntity() instanceof ThrownTrident)
        {
            event.getEntity().addTag(BattleArtsEntityTags.PUNCTURE_LEVEL_1.toString());
        }
    }



    @SubscribeEvent
    public static void registerEntityPatch(EntityPatchRegistryEvent event)
    {
        event.getTypeEntry().put(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(), entity -> FlyingShockwavePatch::new);
    }
}
