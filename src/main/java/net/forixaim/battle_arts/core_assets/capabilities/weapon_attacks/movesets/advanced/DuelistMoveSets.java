package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import yesman.epicfight.api.animation.LivingMotions;

import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

public class DuelistMoveSets
{
    public static final MoveSetEntry DUELIST_SWORD = new MoveSetEntry(BattleArts.identifier("duelist_sword"), MoveSet.builder()
            .addLivingMotionsRecursive(DuelistSwordAnimations.IDLE, LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL)
            .addLivingMotionsRecursive(DuelistSwordAnimations.WALK, LivingMotions.WALK)
            .addLivingMotionsRecursive(DuelistSwordAnimations.RUN, LivingMotions.RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, DuelistSwordAnimations.GUARD_SET)
            .addGuardAnimations(GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_1)
            .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_2)
            .revelationAttack(DuelistSwordAnimations.KNEE_SMASH)
            .addComboAttacks(DuelistSwordAnimations.AUTO1, DuelistSwordAnimations.AUTO2, DuelistSwordAnimations.AUTO3, DuelistSwordAnimations.DASH_ATTACK, DuelistSwordAnimations.AIR_ATTACK)
            .addInnateSkill((itemStack, playerPatch) -> Duelist.QUAD_STING));

    public static final MoveSetEntry DUELIST_DUALBLADES = new MoveSetEntry(BattleArts.identifier("duelist_dualblade"), MoveSet.builder()
            .addLivingMotionsRecursive(DuelistDualbladesAnimations.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.SNEAK, LivingMotions.KNEEL)
            .addLivingMotionModifier(LivingMotions.BLOCK, DuelistDualbladesAnimations.GUARD)
            .addGuardAnimations(GuardSkill.BlockType.GUARD, DuelistDualbladesAnimations.GUARD_HIT)
            .revelationAttack(DuelistSwordAnimations.KNEE_SMASH)
            .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, DuelistDualbladesAnimations.PARRY1, DuelistDualbladesAnimations.PARRY2)
            .addComboAttacks(DuelistDualbladesAnimations.AUTO1, DuelistDualbladesAnimations.AUTO2, DuelistDualbladesAnimations.AUTO3, DuelistSwordAnimations.DASH_ATTACK, DuelistDualbladesAnimations.AIRSLAM)
            .addInnateSkill((itemStack, playerPatch) -> Duelist.RELENTLESS_PUNCTURE));
}
