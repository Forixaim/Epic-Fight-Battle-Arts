package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireMountAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Squire;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;

public class SquireMoveSets
{
    public static final MoveSetEntry SQUIRE_SWORD = new MoveSetEntry(
            BattleArts.identifier("squire_sword"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.MOUNT, SquireMountAnimations.IDLE)
                    .addLivingMotionModifier(LivingMotions.IDLE, SquireSwordAnimations.IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, SquireSwordAnimations.SQUIRE_SWORD_WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, SquireSwordAnimations.SQUIRE_SWORD_RUN)
                    .addLivingMotionModifier(LivingMotions.JUMP, SquireSwordAnimations.JUMP)
                    .addLivingMotionModifier(LivingMotions.KNEEL, SquireSwordAnimations.SQUIRE_SWORD_CROUCH)
                    .addLivingMotionModifier(LivingMotions.SNEAK, SquireSwordAnimations.SQUIRE_SWORD_CROUCH_WALK)
                    .addLivingMotionModifier(LivingMotions.BLOCK, SquireSwordAnimations.SQUIRE_SWORD_GUARD)

                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            SquireSwordAnimations.SQUIRE_SWORD_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD_BREAK,
                            Animations.BIPED_COMMON_NEUTRALIZED
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            SquireSwordAnimations.SQUIRE_SWORD_GUARD_PARRY_1,
                            SquireSwordAnimations.SQUIRE_SWORD_GUARD_PARRY_2
                    )

                    .addComboAttacks(
                            SquireSwordAnimations.SQUIRE_SWORD_AUTO_1,
                            SquireSwordAnimations.SQUIRE_SWORD_AUTO_2,
                            SquireSwordAnimations.SQUIRE_SWORD_AUTO_3,
                            SquireSwordAnimations.SQUIRE_SWORD_DASH_ATTACK,
                            SquireSwordAnimations.SQUIRE_SWORD_HOP_ATTACK
                    )
                    .addMountAttacks(
                            SquireMountAnimations.AUTO1,
                            SquireMountAnimations.AUTO2
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Squire.HEAVY_BLOW)
    );

    public static final MoveSetEntry SQUIRE_BOW = new MoveSetEntry(
            BattleArts.identifier("squire_bow"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.AIM, Animations.BIPED_BOW_AIM)
                    .addLivingMotionModifier(LivingMotions.SHOT, Animations.BIPED_BOW_SHOT)
                    .addLivingMotionModifier(LivingMotions.AIM, Animations.BIPED_BOW_AIM)
                    .addLivingMotionsRecursive(
                            SquireBowAnimations.IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.KNEEL
                    )
                    .setMotionPredicate(
                            (livingEntityPatch, interactionHand) -> livingEntityPatch.getOriginal().isUsingItem() &&
                                    livingEntityPatch.getOriginal().getUseItem().getUseAnimation() == UseAnim.BOW
                                    ? LivingMotions.AIM : null)
                    .addComboAttacks(
                            SquireBowAnimations.AUTO1,
                            SquireBowAnimations.AUTO2,
                            SquireBowAnimations.DASH,
                            SquireBowAnimations.AIRSLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Squire.POWER_DRAW)
    );

    public static final MoveSetEntry SQUIRE_DAGGER = new MoveSetEntry(
            BattleArts.identifier("squire_dagger"),
            MoveSet.builder()
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            Animations.SWORD_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD_BREAK,
                            Animations.BIPED_COMMON_NEUTRALIZED
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            Animations.SWORD_GUARD_ACTIVE_HIT1,
                            Animations.SWORD_GUARD_ACTIVE_HIT2,
                            Animations.SWORD_GUARD_ACTIVE_HIT3
                    )

                    .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                    .addLivingMotionsRecursive(
                            SquireDaggerAnimations.IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.JUMP
                    )
                    .addComboAttacks(
                            SquireDaggerAnimations.AUTO1,
                            SquireDaggerAnimations.AUTO2,
                            SquireDaggerAnimations.AUTO3,
                            SquireDaggerAnimations.DASH,
                            SquireDaggerAnimations.SPIKE
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Squire.DISEMBOWELMENT)
    );
}