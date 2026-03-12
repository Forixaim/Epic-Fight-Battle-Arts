package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class DoryItem extends BattleArtsItem {
    public DoryItem(Tier tier, Properties builder) {
        super(tier, builder.durability(Math.round(tier.getUses() * 1.15f)).attributes(createAttributes(tier)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 3, -2.8F, 0.0F);
    }

}
