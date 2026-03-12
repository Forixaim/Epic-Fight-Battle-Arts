package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.minecraft.world.item.Tier;
import net.neoforged.fml.loading.FMLEnvironment;
import yesman.epicfight.world.item.TieredWeaponItem;

public class AdaptiveGloveItem extends TieredWeaponItem
{
    public AdaptiveGloveItem(Tier tier, Properties builder)
    {
        super(tier, builder);
        if (FMLEnvironment.dist.isClient())
            OverrideHelper.registerGloveOverrides(this);
    }
}
