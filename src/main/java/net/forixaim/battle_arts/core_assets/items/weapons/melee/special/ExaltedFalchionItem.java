package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class ExaltedFalchionItem extends FalchionItem
{
    public ExaltedFalchionItem() {
        super(new Properties().attributes(createAttributes(Tiers.NETHERITE)));
        this.DRAGON_DAMAGE_MULTIPLIER = 1.8f;
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 6, -2.6F, 0.0F);
    }
}
