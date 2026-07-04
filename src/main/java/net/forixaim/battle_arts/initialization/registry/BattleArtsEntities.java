package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.world.entities.TestEuclidiaEntity;
import net.forixaim.battle_arts.core_assets.world.projectiles.FixedArrow;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class BattleArtsEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BattleArts.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<FlyingShockwaveProjectile>> FLYING_SHOCKWAVE = REGISTRY.register(
            "flying_shockwave", () -> EntityType.Builder.of(FlyingShockwaveProjectile::new, MobCategory.MISC).sized(1.5f, 3f).clientTrackingRange(12).build("flying_shockwave")
    );

    public static final DeferredHolder<EntityType<?>, EntityType<TestEuclidiaEntity>> TEST_EUCLIDIA = REGISTRY.register(
            "test_euclidia", () -> EntityType.Builder.<TestEuclidiaEntity>of(TestEuclidiaEntity::new, MobCategory.MISC).sized(1.5f, 3f).clientTrackingRange(12).build("test_euclidia")
    );

    public static final DeferredHolder<EntityType<?>, EntityType<FixedArrow>> FIXED_ARROW = REGISTRY.register(
            "fixed_arrow", () -> EntityType.Builder.<FixedArrow>of(FixedArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build("fixed_arrow")
    );
}
