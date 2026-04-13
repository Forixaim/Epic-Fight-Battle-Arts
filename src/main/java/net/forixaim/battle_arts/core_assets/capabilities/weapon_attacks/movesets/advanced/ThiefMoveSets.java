package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Thief;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.skill.guard.GuardSkill;

public class ThiefMoveSets
{
    public static final MoveSetEntry THIEF_DAGGER = new MoveSetEntry(
            BattleArts.identifier("thief_dagger"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(
                            ThiefDaggerAnimations.IDLE,
                            LivingMotions.IDLE,
                            LivingMotions.WALK,
                            LivingMotions.SNEAK,
                            LivingMotions.RUN,
                            LivingMotions.KNEEL
                    )
                    .addLivingMotionModifier(LivingMotions.BLOCK, ThiefDaggerAnimations.GUARD)
                    .addGuardAnimations(
                            GuardSkill.BlockType.GUARD,
                            ThiefDaggerAnimations.GUARD_HIT
                    )
                    .addGuardAnimations(
                            GuardSkill.BlockType.ADVANCED_GUARD,
                            ThiefDaggerAnimations.GUARD_PARRY_1,
                            ThiefDaggerAnimations.GUARD_PARRY_2
                    )
                    .addComboAttacks(
                            ThiefDaggerAnimations.AUTO1,
                            ThiefDaggerAnimations.AUTO2,
                            ThiefDaggerAnimations.AUTO3,
                            ThiefDaggerAnimations.DASH_ATTACK,
                            ThiefDaggerAnimations.AIRSLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> Thief.STEAL)
    );
}
