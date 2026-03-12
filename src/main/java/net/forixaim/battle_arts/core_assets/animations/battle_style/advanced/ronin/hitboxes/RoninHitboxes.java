package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.hitboxes;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;

import static yesman.epicfight.gameasset.ColliderPreset.registerCollider;

public class RoninHitboxes
{
    public static final Collider BLOSSOM_SLASH = registerCollider(ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, "blossom_slash"), new OBBCollider(3, 3, 3, 0, 0, 0));

}
