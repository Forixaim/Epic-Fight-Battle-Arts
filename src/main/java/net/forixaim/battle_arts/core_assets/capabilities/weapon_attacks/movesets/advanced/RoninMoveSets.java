package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.skill.guard.GuardSkill;

@SuppressWarnings("unchecked")
public class RoninMoveSets
{
    public static MoveSet.MoveSetBuilder RoninUchigatana;
    public static MoveSet.MoveSetBuilder RoninUchigatanaSheathed;
    public static MoveSet.MoveSetBuilder RoninTachi;

    public static void Build()
    {
        RoninUchigatana = MoveSet.builder()
                .addLivingMotionsRecursive(RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM)
                .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_RUN)
                .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD)
                .addAutoAttacks(RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO1,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO2,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_DASH,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AIRSLASH
                )
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD_HIT)
                .shouldRenderSheath(livingEntityPatch -> true)
                .addInnateSkill(itemStack -> Ronin.TRANQUILITY);

        RoninUchigatanaSheathed = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_RUN)
                .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD)
                .addLivingMotionsRecursive(RoninUchigatanaAnimations.RONIN_UCHIGATANA_IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM)
                .addAutoAttacks(
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO1,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO2,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO3,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_DASH,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AIRSLASH)
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_1, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_2)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT)
                .shouldRenderSheath(livingEntityPatch -> true)
                .addInnateSkill(itemStack -> Ronin.TRANQUILITY);

        RoninTachi = MoveSet.builder()
                .addAutoAttacks(RoninTachiAnimations.AUTO1, RoninTachiAnimations.AUTO2, RoninTachiAnimations.AUTO3, RoninTachiAnimations.DASH_ATTACK, RoninTachiAnimations.AIRSLASH)
                .addLivingMotionModifier(LivingMotions.IDLE, RoninTachiAnimations.TACHI_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, RoninTachiAnimations.WALK)
                .addLivingMotionModifier(LivingMotions.RUN, RoninTachiAnimations.RUN)
                .addLivingMotionModifier(LivingMotions.BLOCK, RoninTachiAnimations.TACHI_GUARD)
                .addGuardAnimations(EpicFightSkills.GUARD, GuardSkill.BlockType.GUARD, RoninTachiAnimations.TACHI_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.IMPACT_GUARD, GuardSkill.BlockType.GUARD, RoninTachiAnimations.TACHI_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.GUARD, RoninTachiAnimations.TACHI_GUARD_HIT)
                .addGuardAnimations(EpicFightSkills.PARRYING, GuardSkill.BlockType.ADVANCED_GUARD, RoninTachiAnimations.TACHI_PARRY_1, RoninTachiAnimations.TACHI_PARRY_2)
                .shouldRenderSheath(livingEntityPatch -> true)
                .addInnateSkill(itemStack -> Ronin.BLOSSOM_SLASH);
    }
}
