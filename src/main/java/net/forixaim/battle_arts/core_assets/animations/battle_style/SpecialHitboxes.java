package net.forixaim.battle_arts.core_assets.animations.battle_style;

import net.forixaim.battle_arts.BattleArts;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;
import yesman.epicfight.gameasset.ColliderPreset;

public class SpecialHitboxes
{
    public static final Collider NO_TIPPER = ColliderPreset.registerCollider(BattleArts.identifier("no_tipper"), new OBBCollider(0.1, 0.1, 0.1, 0, 0, 0));
}
