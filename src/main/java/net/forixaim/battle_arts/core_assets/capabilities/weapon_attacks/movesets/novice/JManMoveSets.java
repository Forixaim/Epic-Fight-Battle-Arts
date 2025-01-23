package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;

public class JManMoveSets
{
    public static MoveSet.MoveSetBuilder JManBaxeMS;

    public static void build()
    {
        JManBaxeMS = MoveSet.builder()
                .addLivingMotionModifier(LivingMotions.IDLE, () -> JourneymanBattleAxeAnims.JMAN_BAXE_IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, () -> JourneymanBattleAxeAnims.JMAN_BAXE_WALK)
                .addLivingMotionModifier(LivingMotions.RUN, () -> JourneymanBattleAxeAnims.JMAN_BAXE_RUN);
    }
}

