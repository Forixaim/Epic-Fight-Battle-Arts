package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;

@SuppressWarnings("unchecked")
public class DuelistMoveSets
{
    public static MoveSet.MoveSetBuilder DuelistSingleSword = MoveSet.builder()
            .addLivingMotionsRecursive(DuelistSwordAnimations.IDLE, LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL)
            .addLivingMotionsRecursive(DuelistSwordAnimations.WALK, LivingMotions.WALK)
            .addLivingMotionsRecursive(DuelistSwordAnimations.RUN, LivingMotions.RUN)
            .addAutoAttacks(DuelistSwordAnimations.AUTO1, DuelistSwordAnimations.AUTO2, DuelistSwordAnimations.AUTO3, DuelistSwordAnimations.DASH_ATTACK, DuelistSwordAnimations.AIR_ATTACK)
            .addInnateSkill(itemStack -> Duelist.QUAD_STING);
}
