package net.forixaim.battle_arts.core_assets.items.types;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public abstract class RangedTieredItem extends TieredItem
{
    public static final Predicate<ItemStack> ARROW_ONLY = (p_43017_) -> p_43017_.is(ItemTags.ARROWS);
    public static final Predicate<ItemStack> ARROW_OR_FIREWORK = ARROW_ONLY.or((p_43015_) -> p_43015_.is(Items.FIREWORK_ROCKET));

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return getTier() != SpecialTiers.STEEL && super.isDamageable(stack);
    }

    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return this.getAllSupportedProjectiles();
    }

    public abstract Predicate<ItemStack> getAllSupportedProjectiles();

    public static ItemStack getHeldProjectile(LivingEntity pShooter, Predicate<ItemStack> pIsAmmo) {
        if (pIsAmmo.test(pShooter.getItemInHand(InteractionHand.OFF_HAND))) {
            return pShooter.getItemInHand(InteractionHand.OFF_HAND);
        } else {
            return pIsAmmo.test(pShooter.getItemInHand(InteractionHand.MAIN_HAND)) ? pShooter.getItemInHand(InteractionHand.MAIN_HAND) : ItemStack.EMPTY;
        }
    }



    public abstract int getDefaultProjectileRange();
    public RangedTieredItem(Tier pTier, Properties pProperties)
    {
        super(pTier, pProperties);
    }
}
