package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Squire;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class SquireMoveSets
{
    public static MoveSet.MoveSetBuilder SquireSwordMS;

    public static void build()
    {
        SquireSwordMS = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.IDLE,SquireSwordAnimations.SQUIRE_SWORD_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, SquireSwordAnimations.SQUIRE_SWORD_WALK)
                .addLivingMotionModifier(LivingMotions.RUN, SquireSwordAnimations.SQUIRE_SWORD_RUN)
                .addLivingMotionModifier(LivingMotions.KNEEL, SquireSwordAnimations.SQUIRE_SWORD_CROUCH)
                .addLivingMotionModifier(LivingMotions.SNEAK, SquireSwordAnimations.SQUIRE_SWORD_CROUCH_WALK)
                .addLivingMotionModifier(LivingMotions.BLOCK, SquireSwordAnimations.SQUIRE_SWORD_GUARD)
                .addGuardAnimations(EpicFightSkills.GUARD,
                        GuardSkill.BlockType.GUARD, SquireSwordAnimations.SQUIRE_SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.GUARD,
                        GuardSkill.BlockType.GUARD_BREAK, Animations.BIPED_COMMON_NEUTRALIZED)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.GUARD, SquireSwordAnimations.SQUIRE_SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.GUARD_BREAK, Animations.BIPED_COMMON_NEUTRALIZED)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.ADVANCED_GUARD, Animations.LONGSWORD_GUARD_ACTIVE_HIT1, Animations.LONGSWORD_GUARD_ACTIVE_HIT2)
                .addInnateSkill(itemStack -> Squire.HEAVY_BLOW)
                .addAutoAttacks(SquireSwordAnimations.SQUIRE_SWORD_AUTO_1,
                        SquireSwordAnimations.SQUIRE_SWORD_AUTO_2,
                        SquireSwordAnimations.SQUIRE_SWORD_AUTO_3,
                        SquireSwordAnimations.SQUIRE_SWORD_DASH_ATTACK,
                        SquireSwordAnimations.SQUIRE_SWORD_HOP_ATTACK);
    }
}
