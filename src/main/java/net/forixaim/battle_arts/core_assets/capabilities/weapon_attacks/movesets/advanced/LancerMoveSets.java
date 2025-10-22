package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import com.yesman.epicparcool.EpicParCool;
import com.yesman.epicparcool.ParcoolLivingMotions;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerHeavySpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Lancer;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import net.minecraftforge.fml.ModList;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class LancerMoveSets
{
    public static final MoveSet.MoveSetBuilder lancerSpear = MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, LancerSpearAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, LancerSpearAnimations.WALK)
            .addLivingMotionModifier(LivingMotions.RUN, LancerSpearAnimations.RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
            .addAutoAttacks(LancerSpearAnimations.AUTO1, LancerSpearAnimations.AUTO2,
                    LancerSpearAnimations.AUTO3,
                    LancerSpearAnimations.DASH, LancerSpearAnimations.AIRSLASH)
            .addInnateSkill(itemstack -> Lancer.DASHING_IMPALE);

    public static final MoveSet.MoveSetBuilder lancerHeavySpear = MoveSet.builder()
            .addLivingMotionModifier(LivingMotions.IDLE, LancerHeavySpearAnimations.IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, LancerHeavySpearAnimations.WALK)
            .addLivingMotionModifier(LivingMotions.RUN, LancerHeavySpearAnimations.RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
            .addAutoAttacks(LancerHeavySpearAnimations.AUTO1, LancerHeavySpearAnimations.AUTO2,
                    LancerHeavySpearAnimations.AUTO3,
                    LancerHeavySpearAnimations.DASH, LancerSpearAnimations.AIRSLASH);

    public static void registerCompatibility()
    {
        if (ModList.get().isLoaded(EpicParCool.MODID))
        {
            lancerSpear.addLivingMotionModifier(ParcoolLivingMotions.FAST_RUN, LancerSpearAnimations.SPRINT);
            lancerHeavySpear.addLivingMotionModifier(ParcoolLivingMotions.FAST_RUN, LancerHeavySpearAnimations.SPRINT);
        }
    }
}
