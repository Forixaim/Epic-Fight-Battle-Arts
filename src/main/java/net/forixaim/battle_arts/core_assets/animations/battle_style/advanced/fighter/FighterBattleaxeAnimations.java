package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.fighter;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class FighterBattleaxeAnimations {
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/fighter/battle_axe/idle", access ->
                new StaticAnimation(0.1f, true, access, Armatures.BIPED));
        WALK = builder.nextAccessor("battle_style/advanced/fighter/battle_axe/walk", access ->
                new MovementAnimation(0.1f, true, access, Armatures.BIPED));
    }
}
