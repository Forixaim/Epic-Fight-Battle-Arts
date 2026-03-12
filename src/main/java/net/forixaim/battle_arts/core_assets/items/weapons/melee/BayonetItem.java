package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class BayonetItem extends BattleArtsItem
{
	public BayonetItem(Tier tier, Properties builder)
	{
		super(tier, builder.attributes(createAttributes(tier)));
	}

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 2, -1.8F, 0.0F);
    }

}
