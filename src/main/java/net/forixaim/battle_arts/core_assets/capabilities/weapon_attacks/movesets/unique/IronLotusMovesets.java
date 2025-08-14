package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique;

import net.forixaim.battle_arts.core_assets.animations.battle_style.unique.iron_lotus.IronLotusAnimations;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;

@SuppressWarnings("unchecked")
public class IronLotusMovesets
{
    public static MoveSet.MoveSetBuilder IRON_LOTUS_FIST = new MoveSet.MoveSetBuilder()
            .addLivingMotionModifier(LivingMotions.IDLE, IronLotusAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, IronLotusAnimations.IDLE)
            .addAutoAttacks(IronLotusAnimations.AUTO1, IronLotusAnimations.AUTO2, IronLotusAnimations.AUTO3, IronLotusAnimations.DASH_ATTACK, IronLotusAnimations.AXE_DIVE);
}
