package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.fighter.FighterBattleaxeAnimations;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSetEntry;

public class FighterMovesets {
    public static final MoveSetEntry FIGHTER_BATTLE_AXE = new MoveSetEntry(
            BattleArts.identifier("fighter_battle_axe"), MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, FighterBattleaxeAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, FighterBattleaxeAnimations.WALK));
}
