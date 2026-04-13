package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Journeyman;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;

public class JourneymanMoveSets
{
    public static final MoveSetEntry JOURNEYMAN_AXE = new MoveSetEntry(
            BattleArts.identifier("journeyman_axe"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(
                            JourneymanAxeAnims.IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN
                    )
                    .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            Animations.SWORD_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            Animations.SWORD_GUARD_ACTIVE_HIT1,
                            Animations.SWORD_GUARD_ACTIVE_HIT2,
                            Animations.SWORD_GUARD_ACTIVE_HIT3
                    )
                    .addComboAttacks(
                            JourneymanAxeAnims.AUTO1,
                            JourneymanAxeAnims.AUTO2,
                            JourneymanAxeAnims.AUTO3,
                            JourneymanAxeAnims.DASH,
                            JourneymanAxeAnims.AIRSLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Journeyman.RECURVE_AXE)
    );

    public static final MoveSetEntry JOURNEYMAN_BATTLE_AXE = new MoveSetEntry(
            BattleArts.identifier("journeyman_battle_axe"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, JourneymanBattleAxeAnims.JMAN_BAXE_IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, JourneymanBattleAxeAnims.JMAN_BAXE_WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, JourneymanBattleAxeAnims.JMAN_BAXE_RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY1,
                            JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY2
                    )
                    .addComboAttacks(
                            JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_1,
                            JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_2,
                            JourneymanBattleAxeAnims.JMAN_BAXE_AIR_ATTACK,
                            JourneymanBattleAxeAnims.JMAN_BAXE_DASH_ATTACK
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Journeyman.SEISMIC_IMPACT)
    );

    public static final MoveSetEntry JOURNEYMAN_UNARMED = new MoveSetEntry(
            BattleArts.identifier("journeyman_unarmed"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(
                            JourneymanAnimations.JMAN_UNARMED_IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.KNEEL
                    )
                    .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanAnimations.JMAN_UNARMED_GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            JourneymanAnimations.JMAN_UNARMED_GUARD_HIT
                    )
                    .addComboAttacks(
                            JourneymanAnimations.JMAN_UNARMED_AUTO1,
                            JourneymanAnimations.JMAN_UNARMED_AUTO2,
                            JourneymanAnimations.JMAN_UNARMED_DASH,
                            JourneymanAnimations.JMAN_SLEDGEHAMMER
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Journeyman.SUPPRESSING_BLOW)
    );
}