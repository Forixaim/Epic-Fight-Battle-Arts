package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;

import static yesman.epicfight.gameasset.ColliderPreset.registerCollider;

public class Hitboxes
{
    public static final Collider WHIRLEDGE_BOX = registerCollider(reg("whirledge"), new OBBCollider(2, 1, 2, 0, 1, 0));

    private static ResourceLocation reg(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, name);
    }
}
