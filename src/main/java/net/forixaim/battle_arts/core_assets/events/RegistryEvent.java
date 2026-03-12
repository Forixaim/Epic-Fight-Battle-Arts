package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;


@EventBusSubscriber(modid = BattleArts.MOD_ID)
public class RegistryEvent
{
    @SubscribeEvent
    public static void createTags(EntityJoinLevelEvent event)
    {
        if (event.getEntity() instanceof ThrownTrident)
        {
            event.getEntity().addTag(BattleArtsEntityTags.PUNCTURE_LEVEL_1.toString());
        }
    }


}
