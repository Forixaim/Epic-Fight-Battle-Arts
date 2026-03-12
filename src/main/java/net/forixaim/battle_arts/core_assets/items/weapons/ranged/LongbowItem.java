package net.forixaim.battle_arts.core_assets.items.weapons.ranged;

import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.loading.FMLEnvironment;
import yesman.epicfight.world.item.TieredWeaponItem;

public class LongbowItem extends BattleBowItem
{
    public LongbowItem(Tier pTier, Properties pProperties)
    {
        super(pTier, pProperties.durability(LongbowItem.bowDurabilityCalculation(pTier)).attributes(createAttributes(pTier)));
        if(FMLEnvironment.dist.isClient())
            OverrideHelper.registerLongbowPropertyOverrides(this);
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 1, -3F, 0.0F);
    }

    @Override
    public float getPowerForTime(int pCharge)
    {
        float f = (float) pCharge / 40.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }

    public float getNockProgress(ItemStack stack, LivingEntity shooter)
    {
        return shooter.getTicksUsingItem() / (40f);
    }

    public static int bowDurabilityCalculation(Tier pTier)
    {
        if (pTier.getUses() < 384)
        {
            return Math.round(384f * ((pTier.getUses()/200f)+1));
        }
        return (int)Math.round(pTier.getUses() * 1.5);
    }
}
