package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.efm_ex.api.events.MoveSetDefinitionRegistryEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
        if (event.getEntity() instanceof Player player && !event.getLevel().isClientSide())
        {
            if (!(EpicFightCapabilities.getEntityPatch(player, PlayerPatch.class).getHoldingItemCapability(InteractionHand.MAIN_HAND) instanceof WeaponCapability))
                EpicFightCapabilities.getEntityPatch(player, ServerPlayerPatch.class).modifyLivingMotionByCurrentItem();
        }
    }
}
