package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;

public class BattleArtsItem extends TieredWeaponItem {
    public BattleArtsItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return getTier() != SpecialTiers.STEEL && super.isDamageable(stack);
    }
}
