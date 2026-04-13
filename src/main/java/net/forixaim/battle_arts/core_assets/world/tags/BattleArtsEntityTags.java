package net.forixaim.battle_arts.core_assets.world.tags;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class BattleArtsEntityTags
{
    public static final TagKey<EntityType<?>> PUNCTURE_LEVEL_1 = BattleArtsEntityTags.create("puncture_lv_1");
    public static final TagKey<EntityType<?>> PUNCTURE_LEVEL_2 = BattleArtsEntityTags.create("puncture_lv_2");
    public static final TagKey<EntityType<?>> PUNCTURE_LEVEL_3 = BattleArtsEntityTags.create("puncture_lv_3");

    private static TagKey<EntityType<?>> create(String id)
    {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, id));
    }
}
