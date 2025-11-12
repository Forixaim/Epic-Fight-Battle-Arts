package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.entity_patch.FlyingShockwavePatch;
import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.world.capabilities.projectile.ArrowPatch;

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


}
