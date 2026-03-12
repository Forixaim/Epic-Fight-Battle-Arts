package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.unique.iron_lotus.IronLotusAnimations;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSetEntry;

public class IronLotusMovesets
{
    public static MoveSetEntry IRON_LOTUS_FIST = new MoveSetEntry(BattleArts.identifier("iron_lotus_fist"), MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, IronLotusAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, IronLotusAnimations.IDLE)
            .addComboAttacks(IronLotusAnimations.AUTO1, IronLotusAnimations.AUTO2, IronLotusAnimations.AUTO3, IronLotusAnimations.DASH_ATTACK, IronLotusAnimations.AXE_DIVE));
}
