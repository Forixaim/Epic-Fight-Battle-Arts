package net.forixaim.battle_arts.core_assets.items.weapons.enchantment;

import net.forixaim.battle_arts.core_assets.items.weapons.ranged.BattleBowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentCategories
{
    public static final EnchantmentCategory BATTLE_BOW = EnchantmentCategory.create("IMPERATRICE_LUMIERE", item -> item instanceof BattleBowItem || item instanceof BowItem);

}
