package net.forixaim.battle_arts.core_assets.world.tags;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import yesman.epicfight.world.capabilities.item.WeaponCapabilityPresets;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;

public class BattleArtsExtraDamage
{
    public static final ExtraDamageInstance.ExtraDamage FALL_DISTANCE = new ExtraDamageInstance.ExtraDamage((attacker, itemstack, target, baseDamage, params) -> {
        int tier = 0;
        Item item = itemstack.getItem();
        if (item instanceof TieredItem tieredItem) {
            tier += WeaponCapabilityPresets.vanillaTierToLevel(tieredItem.getTier());
        }
        float maxDamage = baseDamage * (tier + 1);

        LogUtils.getLogger().debug("attacker: {}, fall distance: {}", attacker.getName(), attacker.fallDistance);

        return Math.clamp(attacker.getFallFlyingTicks() / 20f, baseDamage, maxDamage);
    }, (levelReader, itemstack, tooltips, baseDamage, params) -> {
        tooltips.append(Component.translatable("damage_source.battle_arts.fall_distance"));
    });
}
