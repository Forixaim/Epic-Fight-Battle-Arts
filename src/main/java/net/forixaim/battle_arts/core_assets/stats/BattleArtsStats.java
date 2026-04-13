package net.forixaim.battle_arts.core_assets.stats;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;

public class BattleArtsStats
{
    public static final ResourceLocation PARRIES = ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, "parries");

    public static void register()
    {
        Stats.CUSTOM.get(PARRIES);
    }

}
