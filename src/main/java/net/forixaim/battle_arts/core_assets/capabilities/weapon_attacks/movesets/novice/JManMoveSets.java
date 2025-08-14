package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Journeyman;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class JManMoveSets
{
    public static MoveSet.MoveSetBuilder JManBaxeMS;
    public static MoveSet.MoveSetBuilder JourneymanAxeMS;
    public static MoveSet.MoveSetBuilder JManUnarmedMS;

    public static void build()
    {
        JourneymanAxeMS = MoveSet.builder()
                .addLivingMotionsRecursive(JourneymanAxeAnims.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN)
                .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, Animations.SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, Animations.SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, Animations.SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)
                .addAutoAttacks(JourneymanAxeAnims.AUTO1, JourneymanAxeAnims.AUTO2, JourneymanAxeAnims.AUTO3, JourneymanAxeAnims.DASH, JourneymanAxeAnims.AIRSLASH)
                .addInnateSkill(itemStack -> Journeyman.RECURVE_AXE);

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

        JManUnarmedMS = MoveSet.builder()
                .addLivingMotionsRecursive(JourneymanAnimations.JMAN_UNARMED_IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.KNEEL)
                .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanAnimations.JMAN_UNARMED_GUARD)
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, JourneymanAnimations.JMAN_UNARMED_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, JourneymanAnimations.JMAN_UNARMED_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, JourneymanAnimations.JMAN_UNARMED_GUARD_HIT)
                .addAutoAttacks(JourneymanAnimations.JMAN_UNARMED_AUTO1,  JourneymanAnimations.JMAN_UNARMED_AUTO2, JourneymanAnimations.JMAN_UNARMED_DASH, JourneymanAnimations.JMAN_SLEDGEHAMMER)
                .addInnateSkill(itemstack -> Journeyman.SUPPRESSING_BLOW);
    }
}

