package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.entity_patch.FlyingShockwavePatch;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.world.capabilities.projectile.ArrowPatch;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModBusEvent
{
    @SubscribeEvent
    public static void registerEntityPatch(EntityPatchRegistryEvent event)
    {
        event.getTypeEntry().put(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(), entity -> FlyingShockwavePatch::new);
        event.getTypeEntry().put(BattleArtsProjectiles.FIXED_ARROW.get(), entity -> ArrowPatch::new);
    }
}
