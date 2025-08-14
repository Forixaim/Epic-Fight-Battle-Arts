package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum SpecialTiers implements Tier
{
    LIU_ITEMS(4, 0, 9.0f, 1.0f, 0, () -> Ingredient.EMPTY);
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    SpecialTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
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
    public int getLevel()
    {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return repairMaterial.get();
    }
}
