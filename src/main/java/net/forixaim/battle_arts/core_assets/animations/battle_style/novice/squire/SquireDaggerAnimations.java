package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class SquireDaggerAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> CROUCH;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> CROUCH_WALK;


    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SPIKE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> HARD_THRUST;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        IDLE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "idle"),
                access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        CROUCH = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "crouch"),
                access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));

        WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "walk"),
                access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1.5f));

        CROUCH_WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "crouch_walk"),
                access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 4f));

        RUN = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "run"),
                access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v));

        AUTO1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto1"),
                accessor -> new ComboAttackAnimation(0.1f, 0f, 0.15f, 0.3f, 0.4f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, SquireDaggerAnimations::FIXED_1));

        AUTO2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto2"),
                accessor -> new ComboAttackAnimation(0.1f, 0f, 0.2f, 0.35f, 0.4f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, SquireDaggerAnimations::FIXED_1));

        AUTO3 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "auto3"),
                accessor -> new ComboAttackAnimation(0.1f, 0f, 0.2f, 0.35f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, SquireDaggerAnimations::FIXED_1));

        DASH = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "dash"),
                accessor -> new DashAttackAnimation(0.1f, 0f, 0.2f, 0.35f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)

                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, SquireDaggerAnimations::FIXED_1)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
        );

        SPIKE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "airslash"),
                accessor -> new AirSlashAnimation(0.1f, 0f, 0.2f, 0.35f, 1f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)
                        .addProperty(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, List.of(
                                AnimationEvent.SimpleEvent.create((livingEntityPatch, assetAccessor, animationParameters) ->

                                        {
                                            livingEntityPatch.getOriginal().setDeltaMovement(livingEntityPatch.getOriginal().getDeltaMovement().subtract(0, livingEntityPatch.getOriginal().getDeltaMovement().y, 0));
                                            if (livingEntityPatch instanceof PlayerPatch<?> patch && patch.getOriginal().getAbilities().flying)
                                            {
                                                patch.getOriginal().getAbilities().flying = false;
                                            }
                                        }
                                        , AnimationEvent.Side.BOTH)
                        ))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> {
                            if (v2 >= 0.3f && v2 < 0.35f && !livingEntityPatch.getOriginal().onGround())
                            {
                                return 0.0025f;
                            }
                            return 1;
                        }));

        HARD_THRUST = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.DAGGER, "innate"), accessor ->  new BattleArtsAttackAnimation(0.2f, accessor, Armatures.BIPED,
                new AttackAnimation.Phase(0.0f, 0.0f, 0.55f, 0.6f, 1.5f, 1.5f, Armatures.BIPED.get().toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(50)))
                .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        1));
    }

    public static float FIXED_1(DynamicAnimation animation, LivingEntityPatch<?> entityPatch, float speed, float prevElapsedTime, float elapsedTime)
    {
        return 1.0f;
    }
}
