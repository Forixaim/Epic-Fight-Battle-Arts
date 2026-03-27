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

    @SubscribeEvent
    public static void onHit(LivingDamageEvent.Pre event)
    {
        if (event.getEntity().getRandom().nextIntBetweenInclusive(1, 100) <= 20 && event.getSource().getWeaponItem() != null && event.getSource().getWeaponItem().is(ItemRegistry.ERDRICKS_SWORD))
        {
            event.getEntity().playSound(SoundRegistry.CRITICAL_HIT.get());
            event.setNewDamage(event.getOriginalDamage() * 2f);
        }
    }
}
