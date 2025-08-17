package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Thief;
import net.forixaim.ex_cap.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class ThiefMoveSets
{
    public static MoveSet.MoveSetBuilder ThiefDagger = MoveSet.builder()
            .addLivingMotionsRecursive(ThiefDaggerAnimations.IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.SNEAK, LivingMotions.RUN, LivingMotions.KNEEL)
            .addLivingMotionModifier(LivingMotions.BLOCK, ThiefDaggerAnimations.GUARD)
            .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, ThiefDaggerAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, ThiefDaggerAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, ThiefDaggerAnimations.GUARD_HIT)
            .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, ThiefDaggerAnimations.GUARD_PARRY_1, ThiefDaggerAnimations.GUARD_PARRY_2)
            .addAutoAttacks(ThiefDaggerAnimations.AUTO1, ThiefDaggerAnimations.AUTO2, ThiefDaggerAnimations.AUTO3, ThiefDaggerAnimations.DASH_ATTACK, ThiefDaggerAnimations.AIRSLASH)
            .addInnateSkill(itemStack -> Thief.STEAL);
}
