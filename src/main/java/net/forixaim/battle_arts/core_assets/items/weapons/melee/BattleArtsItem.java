package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Unbreakable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.world.item.TieredWeaponItem;

import java.util.function.Consumer;

public class BattleArtsItem extends TieredWeaponItem {
    public BattleArtsItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return getTier() != SpecialTiers.STEEL && super.isDamageable(stack);
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
        return stack;
    }

    @Override
    public <T extends LivingEntity> int damageItem(@NotNull ItemStack stack, int amount, @Nullable T entity, @NotNull Consumer<Item> onBroken) {
        return getTier() != SpecialTiers.STEEL ? 0 : amount;
    }
}
