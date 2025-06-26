package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.GuardAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;
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
    public static AnimationManager.AnimationAccessor<AttackAnimation> WHIRLEDGE;


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
                new GuardAnimation(0.2f, access, biped));

        PARRY1 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard_parry1", access ->
                new GuardAnimation(0.2f, access, biped));
        PARRY2 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/guard_parry2", access ->
                new GuardAnimation(0.2f, access, biped));

        AUTO1 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto1", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.35f, 0.45f, 0.55f, 0.55f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.55f, 0.0f, 0.55f, 0.65f, 0.8f, 1.0f, InteractionHand.MAIN_HAND, toolR, null))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO2 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto2", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.4f, 0.6f, 0.6f, 0.6f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.6f, 0.0f, 0.65f, 0.8f, 1.0f, 1.0f, InteractionHand.OFF_HAND, toolL, null)
                )
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AUTO3 = builder.nextAccessor("battle_style/advanced/duelist/dualblades/auto3", access ->
                new BasicAttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.55f, 0.65f, 0.6f, 0.65f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.65f, 0.0f, 0.65f, 0.75f, 0.75f, 0.75f, InteractionHand.MAIN_HAND, toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.75f, 0.0f, 0.9f, 1f, 1f, 1f, InteractionHand.OFF_HAND, toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(1f, 0.0f, 1f, 1.1f, 3f, 3.0f, InteractionHand.MAIN_HAND, toolR, null)
                )
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.3f));

        WHIRLEDGE = builder.nextAccessor("battle_style/advanced/duelist/dualblades/whirledge", access ->
                new AttackAnimation(0.2f, access, biped,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.7f, 0.75f, 0.75f, 0.75f, InteractionHand.OFF_HAND, root, Hitboxes.WHIRLEDGE_BOX)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.75f, 0.0f, 0.9f, 1.0f, 1.0f, 1.0f, InteractionHand.MAIN_HAND, root, Hitboxes.WHIRLEDGE_BOX)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(1.0f, 0.0f, 1.1f, 1.2f, 1.2f, 1.2f, InteractionHand.OFF_HAND,  root, Hitboxes.WHIRLEDGE_BOX)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(1.2f, 0.0f, 1.2f, 1.3f, 1.3f, 1.3f, InteractionHand.MAIN_HAND,  root, Hitboxes.WHIRLEDGE_BOX)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(1.3f, 0.0f, 1.4f, 1.5f, 1.5f, 1.5f, InteractionHand.MAIN_HAND,  root, Hitboxes.WHIRLEDGE_BOX)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(1.5f, 0.0f, 1.5f, 1.6f, 1.6f, 3f, InteractionHand.MAIN_HAND,  root, Hitboxes.WHIRLEDGE_BOX)
                )
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.3f));
    }
}
