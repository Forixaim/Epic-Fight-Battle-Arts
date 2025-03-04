package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;

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
                .addAutoAttacks(RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO1,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AUTO2,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_DASH,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_AIRSLASH
                )
                .shouldRenderSheath(livingEntityPatch -> true)
                .addInnateSkill(itemStack -> Ronin.TRANQUILITY);

        RoninUchigatanaSheathed = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_RUN)
                .addLivingMotionsRecursive(RoninUchigatanaAnimations.RONIN_UCHIGATANA_IDLE, LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM)
                .addAutoAttacks(
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO1,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO2,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO3,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_DASH,
                        RoninUchigatanaAnimations.RONIN_UCHIGATANA_AIRSLASH)
                .shouldRenderSheath(livingEntityPatch -> true)
                .addInnateSkill(itemStack -> Ronin.TRANQUILITY);

        RoninTachi = MoveSet.builder()
                .addAutoAttacks(RoninTachiAnimations.AUTO1, RoninTachiAnimations.AUTO2, RoninTachiAnimations.AUTO3, Animations.TACHI_DASH, Animations.LONGSWORD_AIR_SLASH)
                .addLivingMotionModifier(LivingMotions.IDLE, RoninTachiAnimations.TACHI_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, RoninTachiAnimations.WALK)
                .addLivingMotionModifier(LivingMotions.RUN, RoninTachiAnimations.RUN)
                .shouldRenderSheath(livingEntityPatch -> true);
    }
}
