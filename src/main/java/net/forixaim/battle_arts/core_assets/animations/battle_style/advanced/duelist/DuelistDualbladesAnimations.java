package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackBasicAttackAnimation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.SwordItem;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.damagesource.StunType;

public class DuelistDualbladesAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> PARRY1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> PARRY2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<KnockbackBasicAttackAnimation> AIRSLAM;
    public static AnimationManager.AnimationAccessor<KnockbackAttackAnimation> WHIRLEDGE;


    public static void build(AnimationManager.AnimationBuilder builder)
    {
        Armatures.ArmatureAccessor<HumanoidArmature> biped = Armatures.BIPED;
        Joint toolR = biped.get().toolR;
        Joint toolL = biped.get().toolL;
        Joint root = biped.get().rootJoint;


        IDLE = builder.nextAccessor("battle_style/advanced/duelist/dualblades/idle", access ->
                new StaticAnimation(0.2f, true, access, biped));

        GUARD = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard", access ->
                new StaticAnimation(0.2f, true, access, biped));

        GUARD_HIT = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard_hit", access ->
                new GuardAnimation(0.0f, access, biped));

        PARRY1 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard_parry1", access ->
                new GuardAnimation(0.0f, access, biped));
        PARRY2 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard_parry2", access ->
                new GuardAnimation(0.0f, access, biped));

        AUTO1 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto1", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.35f, 0.45f, 0.55f, 0.55f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)),
                        new AttackAnimation.Phase(0.55f, 0.0f, 0.55f, 0.65f, 0.8f, 1.0f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO2 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto2", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.4f, 0.6f, 0.6f, 0.6f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)),
                        new AttackAnimation.Phase(0.6f, 0.0f, 0.65f, 0.8f, 1.0f, 1.0f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AIRSLAM = builder.nextAccessor("battle_style/advanced/duelist/dualblades/airslam", access ->
                new KnockbackBasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.4f, 0.5f, 0.6f, 0.6f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, -40.0)
                                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0))
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, AnimationEvent.SimpleEvent.create((livingEntityPatch, assetAccessor, animationParameters) ->
                        {
                            if (assetAccessor.get() instanceof AttackAnimation animation && livingEntityPatch.getOriginal().getOffhandItem().getItem() instanceof SwordItem swordItem)
                            {
                                animation.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(swordItem.getDamage()));
                            }
                        }, AnimationEvent.Side.SERVER))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO3 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto3", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.55f, 0.65f, 0.6f, 0.65f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25f)),
                        new AttackAnimation.Phase(0.65f, 0.0f, 0.65f, 0.75f, 0.75f, 0.75f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25f)),
                        new AttackAnimation.Phase(0.75f, 0.0f, 0.9f, 1f, 1f, 1f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25f)),
                        new AttackAnimation.Phase(1f, 0.0f, 1f, 1.1f, 3f, 3.0f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25f))
                )
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.3f));

        WHIRLEDGE = builder.nextAccessor("battle_style/advanced/duelist/dualblades/whirledge", access ->
                new KnockbackAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.3f, 0.3f, 0.4f, 0.4f, 0.4f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.1f)),
                        new AttackAnimation.Phase(0.4f, 0.0f, 0.4f, 0.5f, 0.5f, 0.5f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.15f)),
                        new AttackAnimation.Phase(0.5f, 0.0f, 0.5f, 0.6f, 0.6f, 0.6f, InteractionHand.MAIN_HAND,  toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2f)),
                        new AttackAnimation.Phase(0.6f, 0.0f, 0.6f, 0.7f, 0.7f, 0.7f, InteractionHand.OFF_HAND,  toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25f)),
                        new AttackAnimation.Phase(0.7f, 0.0f, 0.7f, 0.8f, 0.8f, 0.8f, InteractionHand.MAIN_HAND,  toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3f)),
                        new AttackAnimation.Phase(0.8f, 0.0f, 0.8f, 0.9f, 0.9f, 0.9f, InteractionHand.OFF_HAND,  toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.35f)),
                        new AttackAnimation.Phase(0.9f, 0.0f, 1.25f, 1.35f, 2f, 2f, InteractionHand.MAIN_HAND,  root, ColliderPreset.BATTOJUTSU_DASH)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL)
                                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 45.0)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                )
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.3f));
    }
}
