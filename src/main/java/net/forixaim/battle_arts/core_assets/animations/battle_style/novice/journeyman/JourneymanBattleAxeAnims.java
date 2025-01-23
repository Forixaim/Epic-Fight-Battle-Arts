package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman;

import net.forixaim.battle_arts.core_assets.capabilities.BattleArtsWeapons;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

public class JourneymanBattleAxeAnims
{
    public static StaticAnimation JMAN_BAXE_IDLE;
    public static StaticAnimation JMAN_BAXE_WALK;
    public static StaticAnimation JMAN_BAXE_RUN;

    public static void Build()
    {
        HumanoidArmature biped = Armatures.BIPED;

        JMAN_BAXE_IDLE = new StaticAnimation(true, JourneymanAnimations.jmanAnimationPath(
                BattleStyleCategories.BATTLE_AXE, "idle"
        ), biped);

        JMAN_BAXE_WALK = new MovementAnimation(0.1f, true, JourneymanAnimations.jmanAnimationPath(
                BattleStyleCategories.BATTLE_AXE, "walk"
        ), biped);

        JMAN_BAXE_RUN = new MovementAnimation(0.2f, true, JourneymanAnimations.jmanAnimationPath(
                BattleStyleCategories.BATTLE_AXE, "run"
        ), biped).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.2f);
    }
}
