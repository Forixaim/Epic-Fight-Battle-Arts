package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackBasicAttackAnimation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.SelectiveAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;

public class LancerSpearAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<SelectiveAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> SPRINT;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK_FORWARD;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK_BACKWARD;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<KnockbackBasicAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<KnockbackBasicAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<KnockbackBasicAttackAnimation> AIRSLASH;




    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/lancer/spear/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        WALK_FORWARD = builder.nextAccessor("battle_style/advanced/lancer/spear/walk_fwd", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.5f));
        WALK_BACKWARD = builder.nextAccessor("battle_style/advanced/lancer/spear/walk_back", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.5f));
        WALK = builder.nextAccessor("battle_style/advanced/lancer/spear/walk", access -> new SelectiveAnimation(
                livingEntityPatch ->
                {
                    LivingEntity livingEntity = livingEntityPatch.getOriginal();
                    Vec3 lateralMovement = new Vec3(livingEntity.getDeltaMovement().x, 0, livingEntity.getDeltaMovement().z).normalize();
                    Vec3 lateralLook = new Vec3(livingEntity.getLookAngle().x, 0, livingEntity.getLookAngle().z);
                    return lateralMovement.dot(lateralLook) < 0 ? 1 : 0;
                }, access, WALK_FORWARD, WALK_BACKWARD
        ));
        RUN = builder.nextAccessor("battle_style/advanced/lancer/spear/run", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v));
        SPRINT = builder.nextAccessor("battle_style/advanced/lancer/spear/sprint", access -> new MovementAnimation(0.1f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v));

        AUTO1 = builder.nextAccessor("battle_style/advanced/lancer/spear/auto1", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.2f, 0.3f, 0.5f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v));
        AUTO2 = builder.nextAccessor("battle_style/advanced/lancer/spear/auto2", access ->
                new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.6f, 0.8f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v));
        AUTO3 = builder.nextAccessor("battle_style/advanced/lancer/spear/auto3", access ->
                new KnockbackBasicAttackAnimation(0.2f, 0.0f, 0.75f, 0.9f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 30d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.5f)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.2f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(EpicFightSounds.WHOOSH_ROD.get()), AnimationEvent.InTimeEvent.create(0.35f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(EpicFightSounds.WHOOSH_ROD.get())));

        DASH = builder.nextAccessor("battle_style/advanced/lancer/spear/dash", access ->
                new KnockbackBasicAttackAnimation(0.2f, 0.0f, 0.2f, 0.3f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 15d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.3d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.7f));

        AIRSLASH = builder.nextAccessor("battle_style/advanced/lancer/spear/airslash", access ->
                new KnockbackBasicAttackAnimation(0.1f, 0.0f, 0.1f, 0.4f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 70d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.2d)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1.2f));
    }
}
