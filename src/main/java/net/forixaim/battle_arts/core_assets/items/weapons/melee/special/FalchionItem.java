package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.BattleArtsItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class FalchionItem extends BattleArtsItem
{
    protected float DRAGON_DAMAGE_MULTIPLIER;

    public FalchionItem(Properties builder) {
        super(Tiers.NETHERITE, builder.durability(0).fireResistant().rarity(Rarity.EPIC));
        DRAGON_DAMAGE_MULTIPLIER = 0;
    }

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public float getAttackDamageBonus(@NotNull Entity target, float damage, @NotNull DamageSource damageSource) {
        if (target instanceof EnderDragon) {
            return damage * DRAGON_DAMAGE_MULTIPLIER;
        }

        return super.getAttackDamageBonus(target, damage, damageSource);
    }
}
