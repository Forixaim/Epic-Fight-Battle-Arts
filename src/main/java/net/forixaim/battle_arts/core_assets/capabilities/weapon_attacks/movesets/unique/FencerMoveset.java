package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique;

import net.forixaim.ex_cap.api.moveset.MoveSet;
import net.minecraftforge.fml.ModList;
import net.yonchi.refm.RapierForEpicfight;
import net.yonchi.refm.gameasset.RapierAnimations;
import net.yonchi.refm.gameasset.RapierSkills;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class FencerMoveset
{
    public static MoveSet.MoveSetBuilder FENCER_MOVESET;

    static {
        if (ModList.get().isLoaded(RapierForEpicfight.MOD_ID))
        {
            FENCER_MOVESET = MoveSet.builder()
                    .addAutoAttacks(RapierAnimations.RAPIER_AUTO1,
                            RapierAnimations.RAPIER_AUTO2,
                            RapierAnimations.RAPIER_AUTO3,
                            RapierAnimations.RAPIER_DASH,
                            RapierAnimations.RAPIER_AIR_SLASH)
                    .addInnateSkill(itemStack -> RapierSkills.DEADLYBACKFLIP)
                    .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, RapierAnimations.RAPIER_GUARD_HIT)
                    .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, RapierAnimations.RAPIER_GUARD_HIT)
                    .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, RapierAnimations.RAPIER_GUARD_HIT)
                    .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, RapierAnimations.RAPIER_GUARD_PARRY)
                    .addLivingMotionModifier(LivingMotions.BLOCK, RapierAnimations.RAPIER_GUARD)
                    .addLivingMotionModifier(LivingMotions.IDLE, RapierAnimations.BIPED_HOLD_RAPIER)
                    .addLivingMotionModifier(LivingMotions.WALK, RapierAnimations.BIPED_WALK_RAPIER)
                    .addLivingMotionModifier(LivingMotions.RUN, RapierAnimations.BIPED_RUN_RAPIER)
                    .addLivingMotionModifier(LivingMotions.SNEAK, RapierAnimations.BIPED_SNEAK_RAPIER)
                    .addLivingMotionModifier(LivingMotions.SWIM, RapierAnimations.BIPED_SWIM_RAPIER);
        }
    }
}
