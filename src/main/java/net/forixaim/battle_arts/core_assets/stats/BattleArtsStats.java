package net.forixaim.battle_arts.core_assets.stats;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraftforge.registries.DeferredRegister;

public class BattleArtsStats
{
    public static final ResourceLocation PARRIES = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "parries");

    public static void register()
    {
        Stats.CUSTOM.get(PARRIES);
    }

}
