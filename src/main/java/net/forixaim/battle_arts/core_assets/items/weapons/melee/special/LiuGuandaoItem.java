package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import yesman.epicfight.world.item.WeaponItem;

public class LiuGuandaoItem extends WeaponItem
{
    public LiuGuandaoItem() {
        super(Tiers.NETHERITE, 4, -2.9f, new Properties().fireResistant().defaultDurability(0).durability(0));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        entity.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
