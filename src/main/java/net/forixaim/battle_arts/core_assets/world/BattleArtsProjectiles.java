package net.forixaim.battle_arts.core_assets.world;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.world.projectiles.FixedArrow;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BattleArtsProjectiles
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BattleArts.MOD_ID);

    public static final RegistryObject<EntityType<FlyingShockwaveProjectile>> FLYING_SHOCKWAVE = ENTITIES.register(
            "flying_shockwave", () -> EntityType.Builder.of(FlyingShockwaveProjectile::new, MobCategory.MISC).sized(1.5f, 3f).clientTrackingRange(12).build("flying_shockwave")
    );

    public static final RegistryObject<EntityType<FixedArrow>> FIXED_ARROW = ENTITIES.register(
            "fixed_arrow", () -> EntityType.Builder.<FixedArrow>of(FixedArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build("fixed_arrow")
    );
}
