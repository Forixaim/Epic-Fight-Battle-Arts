package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class SteelWeaponItem extends BattleArtsItem
{
    public SteelWeaponItem(Properties properties) {
        super(SpecialTiers.STEEL, properties);
    }

    public static ItemAttributeModifiers createSwordAttributes() {
        return TieredWeaponItem.createAttributes(SpecialTiers.STEEL, 3, -2.4F, 0.0F);
    }

    public static ItemAttributeModifiers createAxeAttributes() {
        return TieredWeaponItem.createAttributes(SpecialTiers.STEEL, 6, -3.1F, 0.0F);
    }
}
