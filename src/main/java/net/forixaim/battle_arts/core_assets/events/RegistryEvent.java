package net.forixaim.battle_arts.core_assets.events;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.ErdricksSwordItem;
import net.forixaim.battle_arts.core_assets.world.tags.BattleArtsEntityTags;
import net.forixaim.battle_arts.initialization.registry.ItemRegistry;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;


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
