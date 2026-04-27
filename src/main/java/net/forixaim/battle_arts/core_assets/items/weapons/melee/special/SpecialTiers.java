package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum SpecialTiers implements Tier
{
    ENKI(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, Integer.MAX_VALUE, 17, 1.0f, 0, () -> Ingredient.EMPTY),
    LIU_ITEMS(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 6500, 9.0f, 1.0f, 0, () -> Ingredient.EMPTY),
    STEEL(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(Items.IRON_INGOT));
    private final TagKey<Block> harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;



    SpecialTiers(TagKey<Block> level, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = level;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn;
    }

    @Override
    public int getUses()
    {
        return maxUses;
    }

    @Override
    public float getSpeed()
    {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return attackDamage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient()
    {
        return repairMaterial.get();
    }

    @Override
    public @NotNull Tool createToolProperties(@NotNull TagKey<Block> p_335416_) {
        return Tier.super.createToolProperties(p_335416_);
    }
}
