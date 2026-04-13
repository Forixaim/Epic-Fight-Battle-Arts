package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Mercenary;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.skill.guard.GuardSkill;

public class MercenaryMoveSets
{
    public static final MoveSetEntry MERCENARY_GREATSWORD = new MoveSetEntry(
            BattleArts.identifier("mercenary_greatsword"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, MercenaryGreatswordAnimations.IDLE)
                    .addLivingMotionsRecursive(
                            MercenaryGreatswordAnimations.IDLE,
                            LivingMotions.SNEAK,
                            LivingMotions.SWIM,
                            LivingMotions.FLY
                    )
                    .addLivingMotionModifier(LivingMotions.KNEEL, MercenaryGreatswordAnimations.CROUCH)
                    .addLivingMotionsRecursive(
                            MercenaryGreatswordAnimations.IDLE,
                            LivingMotions.WALK,
                            LivingMotions.CHASE
                    )
                    .addLivingMotionModifier(LivingMotions.RUN, MercenaryGreatswordAnimations.IDLE)
                    .addLivingMotionModifier(LivingMotions.BLOCK, MercenaryGreatswordAnimations.GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            MercenaryGreatswordAnimations.GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            MercenaryGreatswordAnimations.GUARD_PARRY_1,
                            MercenaryGreatswordAnimations.GUARD_PARRY_2
                    )
                    .addComboAttacks(
                            MercenaryGreatswordAnimations.AUTO1,
                            MercenaryGreatswordAnimations.AUTO2,
                            MercenaryGreatswordAnimations.AUTO3,
                            MercenaryGreatswordAnimations.AUTO4,
                            MercenaryGreatswordAnimations.DASH_ATTACK,
                            MercenaryGreatswordAnimations.AIRSLAM
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Mercenary.FIERCE_UPPER)
    );
    ;
}