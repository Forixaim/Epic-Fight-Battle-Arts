package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.loading.FMLEnvironment;
import yesman.epicfight.world.item.WeaponItem;

public class AdaptiveGloveItem extends WeaponItem
{
    public AdaptiveGloveItem(Tier tier, int damageIn, float speedIn, Properties builder)
    {
        super(tier, damageIn, speedIn, builder);
        if (FMLEnvironment.dist.isClient())
            OverrideHelper.registerGloveOverrides(this);
    }
}
