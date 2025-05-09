package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Journeyman;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class JManMoveSets
{
    public static MoveSet.MoveSetBuilder JManBaxeMS;

    public static void build()
    {
        JManBaxeMS = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.IDLE, JourneymanBattleAxeAnims.JMAN_BAXE_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, JourneymanBattleAxeAnims.JMAN_BAXE_WALK)
                .addLivingMotionModifier(LivingMotions.RUN, JourneymanBattleAxeAnims.JMAN_BAXE_RUN)
                .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD)
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY1, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY2)
                .addAutoAttacks(JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_1, JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_2, JourneymanBattleAxeAnims.JMAN_BAXE_AIR_ATTACK, JourneymanBattleAxeAnims.JMAN_BAXE_DASH_ATTACK)
                .addInnateSkill(itemstack -> Journeyman.SEISMIC_IMPACT);
    }
}

