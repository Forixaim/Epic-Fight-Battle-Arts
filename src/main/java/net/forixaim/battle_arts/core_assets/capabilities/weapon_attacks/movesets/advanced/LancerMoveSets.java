package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;


import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerHeavySpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Lancer;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSetEntry;
import yesman.epicfight.skill.guard.GuardSkill;

public class LancerMoveSets
{
    public static final MoveSetEntry LANCER_SPEAR = new MoveSetEntry(
            BattleArts.identifier("lancer_spear"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, LancerSpearAnimations.IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, LancerSpearAnimations.WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, LancerSpearAnimations.RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
                    .addComboAttacks(
                            LancerSpearAnimations.AUTO1,
                            LancerSpearAnimations.AUTO2,
                            LancerSpearAnimations.AUTO3,
                            LancerSpearAnimations.DASH,
                            LancerSpearAnimations.AIRSLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> SkillRegistry.DASHING_IMPALE.get())
    );

    public static final MoveSetEntry LANCER_HEAVY_SPEAR = new MoveSetEntry(
            BattleArts.identifier("lancer_heavy_spear"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, LancerHeavySpearAnimations.IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, LancerHeavySpearAnimations.WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, LancerHeavySpearAnimations.RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
                    .addComboAttacks(
                            LancerHeavySpearAnimations.AUTO1,
                            LancerHeavySpearAnimations.AUTO2,
                            LancerHeavySpearAnimations.AUTO3,
                            LancerHeavySpearAnimations.DASH,
                            LancerSpearAnimations.AIRSLASH
                    )
    );


}
