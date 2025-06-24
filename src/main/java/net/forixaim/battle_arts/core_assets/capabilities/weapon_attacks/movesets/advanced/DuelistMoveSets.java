package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class DuelistMoveSets
{
    public static MoveSet.MoveSetBuilder DuelistSingleSword = MoveSet.builder()
            .addLivingMotionsRecursive(DuelistSwordAnimations.IDLE, LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL)
            .addLivingMotionsRecursive(DuelistSwordAnimations.WALK, LivingMotions.WALK)
            .addLivingMotionsRecursive(DuelistSwordAnimations.RUN, LivingMotions.RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, DuelistSwordAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_1)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_2)
            .addAutoAttacks(DuelistSwordAnimations.AUTO1, DuelistSwordAnimations.AUTO2, DuelistSwordAnimations.AUTO3, DuelistSwordAnimations.DASH_ATTACK, DuelistSwordAnimations.AIR_ATTACK)
            .addInnateSkill(itemStack -> Duelist.QUAD_STING);

    public static MoveSet.MoveSetBuilder DuelistDualblade = MoveSet.builder()
            .addLivingMotionsRecursive(DuelistDualbladesAnimations.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.SNEAK, LivingMotions.KNEEL)
            .addLivingMotionModifier(LivingMotions.BLOCK, DuelistDualbladesAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_1)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, DuelistSwordAnimations.GUARD_PARRY_2)
            .addAutoAttacks(DuelistDualbladesAnimations.AUTO1, DuelistDualbladesAnimations.AUTO2, DuelistDualbladesAnimations.AUTO3, DuelistSwordAnimations.DASH_ATTACK, Animations.SWORD_DUAL_AIR_SLASH)
            .addInnateSkill(itemStack -> EpicFightSkills.DANCING_EDGE);
}
