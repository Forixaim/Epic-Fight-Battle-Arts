package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Recruit;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class RecruitMoveSets
{
    public static MoveSet.MoveSetBuilder RECRUIT_MOVESET;
    public static MoveSet.MoveSetBuilder RECRUIT_MOVESET_SHIELDED;

    public static void build()
    {
        RECRUIT_MOVESET = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.RECRUIT_SPEAR_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.RECRUIT_SPEAR_WALK)
                .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RECRUIT_SPEAR_RUN)
                .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.RECRUIT_SPEAR_CROUCH)
                .addLivingMotionModifier(LivingMotions.BLOCK, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD)
                .addAutoAttacks(
                        RecruitSpearAnimations.RECRUIT_SPEAR_STANDING_ATTACK, RecruitSpearAnimations.RECRUIT_SPEAR_STANDING_ATTACK_2,
                        RecruitSpearAnimations.RECRUIT_SPEAR_DASH_ATTACK, RecruitSpearAnimations.RECRUIT_SPEAR_AERIAL_POKE
                )
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY_2)
                .addInnateSkill(itemStack -> Recruit.IRON_FORTRESS);

        RECRUIT_MOVESET_SHIELDED = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_WALK)
                .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_RUN)
                .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_CROUCH)
                .addAutoAttacks(
                        RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO1, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO2, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO3,
                        RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DASH, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AIRSLASH
                )
                .addInnateSkill(itemStack -> Recruit.PUNCTURE_SWIPE);
    }
}
