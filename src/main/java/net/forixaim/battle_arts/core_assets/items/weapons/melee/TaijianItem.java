package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class TaijianItem extends BattleArtsItem
{
    public TaijianItem(Tier tier, Properties builder) {
        super(tier, builder.attributes(createAttributes(tier)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 3, -2.6F, 0.0F);
    }
}
