package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.modules.core.data.MoveSetEntry;
import yesman.epicfight.skill.guard.GuardSkill;

public class RoninMoveSets
{

    public static final MoveSetEntry RONIN_UCHIGATANA = new MoveSetEntry(
            BattleArts.identifier("ronin_uchigatana"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_IDLE,
                            LivingMotions.IDLE, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM
                    )
                    .addLivingMotionModifier(LivingMotions.WALK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_WALK)

                    .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD)
                    .addComboAttacks(
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO1,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO2,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_DASH,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AIRSLASH
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD_HIT
                    )
                    .shouldRenderSheath(livingEntityPatch -> true)
                    .addInnateSkill((itemStack, playerPatch) -> SkillRegistry.TRANQUILITY.get())
    );

    public static final MoveSetEntry RONIN_UCHIGATANA_SHEATHED = new MoveSetEntry(
            BattleArts.identifier("ronin_uchigatana_sheathed"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD)
                    .addLivingMotionsRecursive(
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM
                    )
                    .addComboAttacks(
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO1,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO2,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO3,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_DASH,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_AIRSLASH
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_1,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_2
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT
                    )
                    .shouldRenderSheath(livingEntityPatch -> true)
                    .addInnateSkill((itemStack, playerPatch) -> SkillRegistry.TRANQUILITY.get())
    );

    public static final MoveSetEntry RONIN_TACHI = new MoveSetEntry(
            BattleArts.identifier("ronin_tachi"),
            MoveSet.builder()
                    .addComboAttacks(
                            RoninTachiAnimations.AUTO1,
                            RoninTachiAnimations.AUTO2,
                            RoninTachiAnimations.AUTO3,
                            RoninTachiAnimations.DASH_ATTACK,
                            RoninTachiAnimations.AIRSLASH
                    )
                    .addLivingMotionModifier(LivingMotions.IDLE, RoninTachiAnimations.TACHI_IDLE)
                    .addLivingMotionModifier(LivingMotions.WALK, RoninTachiAnimations.WALK)
                    .addLivingMotionModifier(LivingMotions.RUN, RoninTachiAnimations.RUN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, RoninTachiAnimations.TACHI_GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            RoninTachiAnimations.TACHI_GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            RoninTachiAnimations.TACHI_PARRY_1,
                            RoninTachiAnimations.TACHI_PARRY_2
                    )
                    .shouldRenderSheath(livingEntityPatch -> true)
                    .addInnateSkill((itemStack, playerPatch) -> SkillRegistry.BLOSSOM_SLASH.get())
    );
}
