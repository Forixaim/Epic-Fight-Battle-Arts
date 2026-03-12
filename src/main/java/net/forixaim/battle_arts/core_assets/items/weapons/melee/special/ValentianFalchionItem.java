package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class ValentianFalchionItem extends FalchionItem
{
    public ValentianFalchionItem() {
        super(new Properties().attributes(createAttributes(Tiers.NETHERITE)));
        this.DRAGON_DAMAGE_MULTIPLIER = 1.0f;
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 7, -2.8F, 0.0F);
    }
}
