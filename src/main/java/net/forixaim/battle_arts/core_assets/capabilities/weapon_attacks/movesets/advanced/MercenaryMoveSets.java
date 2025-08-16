package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;

@SuppressWarnings("unchecked")
public class MercenaryMoveSets
{
    public static final MoveSet.MoveSetBuilder mercenaryGreatsword = MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, MercenaryGreatswordAnimations.IDLE)
            .addLivingMotionsRecursive(MercenaryGreatswordAnimations.IDLE,
                    LivingMotions.JUMP, LivingMotions.KNEEL, LivingMotions.SNEAK,
                    LivingMotions.SWIM, LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
            .addLivingMotionsRecursive(MercenaryGreatswordAnimations.IDLE,
                    LivingMotions.WALK,
                    LivingMotions.CHASE)
            .addLivingMotionModifier(LivingMotions.RUN, MercenaryGreatswordAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.BLOCK, Animations.GREATSWORD_GUARD)
            .addAutoAttacks(MercenaryGreatswordAnimations.AUTO1, MercenaryGreatswordAnimations.AUTO2, MercenaryGreatswordAnimations.AUTO3, MercenaryGreatswordAnimations.AUTO4, MercenaryGreatswordAnimations.DASH_ATTACK, MercenaryGreatswordAnimations.AIRSLAM)
            .addInnateSkill(itemstack -> EpicFightSkills.STEEL_WHIRLWIND);
    ;
}
