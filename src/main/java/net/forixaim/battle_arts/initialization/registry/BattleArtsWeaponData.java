package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.SpecialHitboxes;
import net.minecraft.nbt.CompoundTag;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.registry.deferred.CustomDataRegister;
import yesman.epicfight.registry.deferred.holders.DeferredCustomData;
import yesman.epicfight.world.capabilities.item.custom.CustomData;

public final class BattleArtsWeaponData
{
    public static final CustomDataRegister REGISTRY = CustomDataRegister.createWeapon(BattleArts.MOD_ID);

    public static final DeferredCustomData<CustomData<Collider>> TIPPER_HITBOX =
            REGISTRY.registerCustomData("tipper_hitbox",
                    () -> CustomData.createDeserializable(SpecialHitboxes.NO_TIPPER, tag -> {
                        if (tag instanceof CompoundTag compoundTag)
                        {
                            return ColliderPreset.deserializeSimpleCollider(compoundTag);
                        }
                        return SpecialHitboxes.NO_TIPPER;
                    }));
}
