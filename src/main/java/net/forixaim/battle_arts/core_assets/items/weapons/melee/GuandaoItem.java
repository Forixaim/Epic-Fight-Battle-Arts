package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class GuandaoItem extends BattleArtsItem {
    public GuandaoItem(Tier tier, Properties builder) {
        super(tier, builder.durability(Math.round(tier.getUses() * 1.15f)).attributes(createAttributes(tier)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 4, -2.9F, 0.0F);
    }

}
