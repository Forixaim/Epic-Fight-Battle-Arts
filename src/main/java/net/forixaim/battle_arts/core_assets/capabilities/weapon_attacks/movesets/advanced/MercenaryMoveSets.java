package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Mercenary;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class MercenaryMoveSets
{
    public static final MoveSet.MoveSetBuilder mercenaryGreatsword = MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, MercenaryGreatswordAnimations.IDLE)
            .addLivingMotionsRecursive(MercenaryGreatswordAnimations.IDLE, LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLY)
            .addLivingMotionModifier(LivingMotions.KNEEL, MercenaryGreatswordAnimations.CROUCH)
            .addLivingMotionsRecursive(MercenaryGreatswordAnimations.IDLE,
                    LivingMotions.WALK,
                    LivingMotions.CHASE)
            .addLivingMotionModifier(LivingMotions.RUN, MercenaryGreatswordAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.BLOCK, MercenaryGreatswordAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, MercenaryGreatswordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, MercenaryGreatswordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, MercenaryGreatswordAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, MercenaryGreatswordAnimations.GUARD_PARRY_1, MercenaryGreatswordAnimations.GUARD_PARRY_2)
            .addAutoAttacks(MercenaryGreatswordAnimations.AUTO1, MercenaryGreatswordAnimations.AUTO2, MercenaryGreatswordAnimations.AUTO3, MercenaryGreatswordAnimations.AUTO4, MercenaryGreatswordAnimations.DASH_ATTACK, MercenaryGreatswordAnimations.AIRSLAM)
            .addInnateSkill(itemstack -> Mercenary.FIERCE_UPPER);
    ;
}
