package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.item.Tiers;
import yesman.epicfight.world.item.WeaponItem;

public class FalchionItem extends WeaponItem
{

    public FalchionItem(int damageIn, float speedIn, Properties builder) {
        super(Tiers.NETHERITE, damageIn, speedIn, builder.durability(0).defaultDurability(0).fireResistant());
    }
}
