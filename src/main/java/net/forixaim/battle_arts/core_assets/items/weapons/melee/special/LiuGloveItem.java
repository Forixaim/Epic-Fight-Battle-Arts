package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.AdaptiveGloveItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import yesman.epicfight.world.item.WeaponItem;

public class LiuGloveItem extends AdaptiveGloveItem
{
    public LiuGloveItem() {
        super(SpecialTiers.LIU_ITEMS, 2, 0f, new Properties().fireResistant().defaultDurability(0).durability(0));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        entity.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
