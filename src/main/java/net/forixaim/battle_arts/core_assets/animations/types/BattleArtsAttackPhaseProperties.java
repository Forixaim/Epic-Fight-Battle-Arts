package net.forixaim.battle_arts.core_assets.animations.types;

import com.mojang.serialization.Codec;
import yesman.epicfight.api.animation.property.AnimationProperty;

public class BattleArtsAttackPhaseProperties
{
    public static final AnimationProperty.AttackPhaseProperty<Double> KNOCKBACK_POWER =
            new AnimationProperty.AttackPhaseProperty<>("knockback_power", Codec.DOUBLE);
    public static final AnimationProperty.AttackPhaseProperty<Double> KNOCKBACK_ANGLE =
            new AnimationProperty.AttackPhaseProperty<>("knockback_angle", Codec.DOUBLE);
    public static final AnimationProperty.AttackPhaseProperty<Double> KNOCKBACK_LATERAL_ANGLE =
            new AnimationProperty.AttackPhaseProperty<>("knockback_lateral_angle", Codec.DOUBLE);
}
