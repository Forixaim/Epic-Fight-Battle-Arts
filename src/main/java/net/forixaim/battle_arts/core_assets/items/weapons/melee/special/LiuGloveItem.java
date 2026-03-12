package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.AdaptiveGloveItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class LiuGloveItem extends AdaptiveGloveItem
{
    public LiuGloveItem() {
        super(SpecialTiers.LIU_ITEMS, new Properties().fireResistant().attributes(createAttributes(SpecialTiers.LIU_ITEMS)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 2, 0F, 0.0F);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        entity.igniteForSeconds(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
