package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class PikeItem extends BattleArtsItem {
    public PikeItem(Tier tier, Properties builder) {
        super(tier, builder.durability(Math.round(tier.getUses() * 1.1f)).attributes(createAttributes(tier)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 6, -3.0F, 0.0F);
    }

}
