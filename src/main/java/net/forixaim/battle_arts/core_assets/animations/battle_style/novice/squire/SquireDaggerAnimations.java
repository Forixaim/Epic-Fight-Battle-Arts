package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class SquireDaggerAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SPIKE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DISEMBOWELMENT;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        IDLE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "idle"),
                access -> new StaticAnimation(0.1f, true, access, Armatures.BIPED));

        AUTO1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto1"),
                accessor -> new BasicAttackAnimation(0.1f, 0f, 0.35f, 0.5f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));

        AUTO2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto2"),
                accessor -> new BasicAttackAnimation(0.1f, 0f, 0.4f, 0.6f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));

        AUTO3 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto3"),
                accessor -> new BasicAttackAnimation(0.1f, 0f, 0.4f, 0.5f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));

        DASH = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "dash"),
                accessor -> new DashAttackAnimation(0.1f, 0f, 0.4f, 0.5f, 1f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
        );

        SPIKE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "airslash"),
                accessor -> new AirSlashAnimation(0.1f, 0f, 0.15f, 0.25f, 0.6f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));

        DISEMBOWELMENT = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "innate"), accessor ->  new AttackAnimation(0.2f, accessor, Armatures.BIPED,
                new AttackAnimation.Phase(0.0f, 0.0f, 0.35f, 0.4f, 0.5f, 0.5f, Armatures.BIPED.get().toolR, null),
                new AttackAnimation.Phase(0.5f, 0.0f, 0.85f, 0.95f, 3f, 3.0f, Armatures.BIPED.get().toolR, null).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()))
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                {
                    if (elapsedTime > 0.3f && elapsedTime < 0.9f)
                        return 1.0f;
                    if (elapsedTime > 1.2f)
                        return 1.0f;
                    else
                        return speed;
                }));
    }
}
