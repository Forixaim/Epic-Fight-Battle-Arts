package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.hitboxes;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.OBBCollider;

import static yesman.epicfight.gameasset.ColliderPreset.registerCollider;

public class JourneymanHitboxes
{
    public static final Collider SEISMIC_IMPACT = registerCollider(BattleArts.identifier("seismic_impact"), new OBBCollider(3, 0.5, 3, 0.0F, -0F, 0));

}
