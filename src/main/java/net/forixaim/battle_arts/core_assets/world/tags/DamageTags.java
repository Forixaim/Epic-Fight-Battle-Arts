package net.forixaim.battle_arts.core_assets.world.tags;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

public class DamageTags
{
    public static final TagKey<DamageType> DODGE_BYPASS_LEVEL_1 = create("dodge_bypass_1");
    public static final TagKey<DamageType> DODGE_BYPASS_LEVEL_2 = create("dodge_bypass_2");
    public static final TagKey<DamageType> DODGE_BYPASS_LEVEL_3 = create("dodge_bypass_3");


    private static TagKey<DamageType> create(String id)
    {
        return TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, id));
    }
}
