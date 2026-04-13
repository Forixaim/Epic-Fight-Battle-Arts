package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Recruit;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.skill.guard.GuardSkill;

public class RecruitMoveSets
{
    public static final MoveSetEntry RECRUIT_MOVESET = new MoveSetEntry(
            BattleArts.identifier("recruit_moveset"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.RECRUIT_SPEAR_IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.RECRUIT_SPEAR_WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RECRUIT_SPEAR_RUN)
                    .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.RECRUIT_SPEAR_CROUCH)
                    .addLivingMotionModifier(LivingMotions.BLOCK, RecruitSpearAnimations.RECRUIT_SPEAR_GUARD)
                    .addComboAttacks(
                            RecruitSpearAnimations.RECRUIT_SPEAR_STANDING_ATTACK,
                            RecruitSpearAnimations.RECRUIT_SPEAR_STANDING_ATTACK_2,
                            RecruitSpearAnimations.RECRUIT_SPEAR_DASH_ATTACK,
                            RecruitSpearAnimations.RECRUIT_SPEAR_AERIAL_POKE
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY,
                            RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY_2
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Recruit.IRON_FORTRESS)
    );

    public static final MoveSetEntry RECRUIT_MOVESET_SHIELDED = new MoveSetEntry(
            BattleArts.identifier("recruit_moveset_shielded"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_RUN)
                    .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_CROUCH)
                    .addComboAttacks(
                            RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO1,
                            RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO2,
                            RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO3,
                            RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DASH,
                            RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AIRSLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Recruit.PUNCTURE_SWIPE)
    );
}