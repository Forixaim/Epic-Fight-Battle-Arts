package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireMountAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Squire;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import net.forixaim.ex_cap.api.moveset.RangedMoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class SquireMoveSets
{
    public static MoveSet.MoveSetBuilder SquireSwordMS;
    public static MoveSet.MoveSetBuilder SquireBowMS;
    public static MoveSet.MoveSetBuilder SquireDaggerMS;

    public static void build()
    {
        SquireSwordMS = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.MOUNT, SquireMountAnimations.IDLE)
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
                        GuardSkill.BlockType.ADVANCED_GUARD, SquireSwordAnimations.SQUIRE_SWORD_GUARD_PARRY_1, SquireSwordAnimations.SQUIRE_SWORD_GUARD_PARRY_2)
                .addInnateSkill(itemStack -> Squire.HEAVY_BLOW)
                .addAutoAttacks(SquireSwordAnimations.SQUIRE_SWORD_AUTO_1,
                        SquireSwordAnimations.SQUIRE_SWORD_AUTO_2,
                        SquireSwordAnimations.SQUIRE_SWORD_AUTO_3,
                        SquireSwordAnimations.SQUIRE_SWORD_DASH_ATTACK,
                        SquireSwordAnimations.SQUIRE_SWORD_HOP_ATTACK)
                .addMountAttacks(SquireMountAnimations.AUTO1, SquireMountAnimations.AUTO2);

        SquireBowMS = RangedMoveSet.builder()
                .addRangedAttackModifier(LivingMotions.AIM, Animations.BIPED_BOW_AIM)
                .addRangedAttackModifier(LivingMotions.SHOT, Animations.BIPED_BOW_SHOT)
                .addLivingMotionModifier(LivingMotions.AIM, Animations.BIPED_BOW_AIM)
                .addLivingMotionsRecursive(SquireBowAnimations.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.KNEEL)
                .addAutoAttacks(SquireBowAnimations.AUTO1, SquireBowAnimations.AUTO2, SquireBowAnimations.DASH, SquireBowAnimations.AIRSLASH)
                .addInnateSkill(itemStack -> Squire.POWER_DRAW);

        SquireDaggerMS = MoveSet.builder()
                .addGuardAnimations(EpicFightSkills.GUARD,
                        GuardSkill.BlockType.GUARD, Animations.SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.GUARD,
                        GuardSkill.BlockType.GUARD_BREAK, Animations.BIPED_COMMON_NEUTRALIZED)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.GUARD, Animations.SWORD_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.GUARD_BREAK, Animations.BIPED_COMMON_NEUTRALIZED)
                .addGuardAnimations(EpicFightSkills.PARRYING,
                        GuardSkill.BlockType.ADVANCED_GUARD, Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)

                .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                .addLivingMotionsRecursive(SquireDaggerAnimations.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.JUMP)
                .addAutoAttacks(SquireDaggerAnimations.AUTO1, SquireDaggerAnimations.AUTO2, SquireDaggerAnimations.AUTO3, SquireDaggerAnimations.DASH, SquireDaggerAnimations.SPIKE)
                .addInnateSkill(itemStack -> Squire.DISEMBOWELMENT);
    }
}
