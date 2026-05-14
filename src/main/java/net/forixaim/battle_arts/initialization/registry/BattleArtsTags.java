package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public final class BattleArtsTags
{
    public static final TagKey<EntityType<?>> STOLEN = create("stolen");


    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, pName));
    }

}
