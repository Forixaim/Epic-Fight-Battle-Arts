package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;

public class ThiefDaggerAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> STEAL;
    public static AnimationManager.AnimationAccessor<AttackAnimation> MUG;


    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/thief/dagger/idle", access ->
                new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        GUARD = builder.nextAccessor("battle_style/advanced/thief/dagger/guard", access ->
                new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        GUARD_HIT = builder.nextAccessor("battle_style/advanced/thief/dagger/guard_hit", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_1 = builder.nextAccessor("battle_style/advanced/thief/dagger/guard_parry1", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_2 = builder.nextAccessor("battle_style/advanced/thief/dagger/guard_parry2", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));

        AUTO1 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto1",
                accessor -> new ComboAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));
        AUTO2 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto2",
                accessor -> new ComboAttackAnimation(0.2f, 0f, 0.3f, 0.45f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));
        AUTO3 = builder.nextAccessor("battle_style/advanced/thief/dagger/auto3",
                accessor -> new ComboAttackAnimation(0.2f, 0f, 0.55f, 0.65f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));

        DASH_ATTACK = builder.nextAccessor("battle_style/advanced/thief/dagger/dash_attack",
                accessor -> new DashAttackAnimation(0.2f, 0f, 0.3f, 0.4f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));

        AIRSLASH = builder.nextAccessor("battle_style/advanced/thief/dagger/airslash",
                accessor -> new AirSlashAnimation(0.2f, 0f, 0.2f, 0.3f, 1.7f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        STEAL = builder.nextAccessor("battle_style/advanced/thief/dagger/steal",
                accessor -> new AttackAnimation(0.2f, 0f, 0.65f, 0.75f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f));

        MUG = builder.nextAccessor("battle_style/advanced/thief/dagger/mug",
                accessor -> new AttackAnimation(0.2f, 0f, 1f, 1.15f, 1.7f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f)
                        .addState(EntityState.SKILL_EXECUTABLE, false));
    }
}
