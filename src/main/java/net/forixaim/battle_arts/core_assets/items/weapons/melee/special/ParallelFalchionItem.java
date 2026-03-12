
package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class ParallelFalchionItem extends FalchionItem
{
    public ParallelFalchionItem() {
        super(new Properties().attributes(createAttributes(Tiers.NETHERITE)));
        this.DRAGON_DAMAGE_MULTIPLIER = 0.85f;
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 5, -2.5F, 0.0F);
    }
}
