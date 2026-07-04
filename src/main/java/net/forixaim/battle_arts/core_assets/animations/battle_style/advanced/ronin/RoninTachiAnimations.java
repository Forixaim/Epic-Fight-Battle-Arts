package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.hitboxes.RoninHitboxes;
import net.forixaim.battle_arts.core_assets.animations.types.RoninInnateAnimation;
import net.forixaim.battle_arts.initialization.registry.BattleArtsEntities;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class RoninTachiAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> TACHI_IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> TACHI_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> TACHI_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> TACHI_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> TACHI_PARRY_2;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLASH;
    public static AnimationManager.AnimationAccessor<RoninInnateAnimation> BLOSSOM_SLASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> FLYING_SHOCKWAVE;



    public static void onRegister(AnimationManager.AnimationBuilder event)
    {
        TACHI_IDLE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "idle"), access ->
                new StaticAnimation(true, access, Armatures.BIPED));
        WALK = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "walk"), access -> new MovementAnimation(
                true, access, Armatures.BIPED
        ));

        TACHI_GUARD = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "guard"), access ->
                new StaticAnimation(true, access, Armatures.BIPED));

        TACHI_GUARD_HIT = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "guard_hit"), access ->
                new GuardAnimation(0.1f, access, Armatures.BIPED));

        TACHI_PARRY_1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "parry1"), access ->
                new GuardAnimation(0.1f, access, Armatures.BIPED));

        TACHI_PARRY_2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "parry2"), access ->
                new GuardAnimation(0.1f, access, Armatures.BIPED));

        RUN = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "run"), access -> new MovementAnimation(
                true, access, Armatures.BIPED
        ));
        AUTO1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto1"), access ->
                new ComboAttackAnimation(0.1f, 0.0f, 0.6f, 0.75f, 1f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 0.75f)
                                return 1.0f;
                            else
                                return speed;
                        }));
        AUTO2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto2"), access ->
                new ComboAttackAnimation(0.1f, 0.0f, 0.9f, 1f, 1.3f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 1f)
                                return 1.0f;
                            else
                                return speed;
                        }));
        AUTO3 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto3"), access ->
                new ComboAttackAnimation(0.1f, 0.0f, 1.1f, 1.35f, 1.6f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 1.1f)
                                return 1.0f;
                            else
                                return speed;
                        }));
        DASH_ATTACK = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "dash_attack"), access ->
                new DashAttackAnimation(0.1f, 0.0f, 0.35f, 0.6f, 1.6f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 0.6f)
                                return 1.0f;
                            else
                                return speed * 0.75f;
                        }));

        AIRSLASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "airslash"), access ->
                new AirSlashAnimation(0.1f, 0.0f, 0.25f, 0.4f, 1.6f, false, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 0.4f)
                                return 1.0f;
                            else
                                return speed * 0.75f;
                        }));
        BLOSSOM_SLASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "innate"), access ->
                new RoninInnateAnimation(0.1f, access, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.1f, Armatures.BIPED.get().rootJoint, RoninHitboxes.BLOSSOM_SLASH),
                        new AttackAnimation.Phase(0.15f, 0.0f, 0.15f, 0.25f, 0.25f, 0.25f, Armatures.BIPED.get().rootJoint, RoninHitboxes.BLOSSOM_SLASH),
                        new AttackAnimation.Phase(0.25f, 0.0f, 0.3f, 0.4f, 0.4f, 0.4f, Armatures.BIPED.get().rootJoint, RoninHitboxes.BLOSSOM_SLASH),
                        new AttackAnimation.Phase(0.4f, 0.0f, 0.45f, 0.55f, 0.6f, 0.6f, Armatures.BIPED.get().rootJoint, RoninHitboxes.BLOSSOM_SLASH),
                        new AttackAnimation.Phase(0.6f, 0.0f, 0.6f, 0.8f, 2f, 2f, Armatures.BIPED.get().rootJoint, RoninHitboxes.BLOSSOM_SLASH)
                )
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(12f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(12f), 1)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1), 1)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(12f), 2)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1), 2)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(12f), 3)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1), 3)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 3)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(12f), 4)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG, 4)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                        {
                            if (elapsedTime > 0.8f)
                                return 1.0f;
                            else
                                return speed * 0.75f;
                        }));

        FLYING_SHOCKWAVE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "flying_shockwave"),
                accessor -> new AttackAnimation(0.0f, 0.0f, 0.9f, 1f, 2.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5f))
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.1f)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.9f, (livingEntityPatch, assetAccessor, animationParameters) ->
                        {
                            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
                            Vec3 shootVec = new Vec3(Math.cos(ang), 0 , Math.sin(ang));
                            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z);

                            FlyingShockwaveProjectile projectile = BattleArtsEntities.FLYING_SHOCKWAVE.get().create(livingEntityPatch.getOriginal().level());

                            float multiplier = 1.5f;

                            if (projectile != null)
                            {
                                projectile.setDamage((float) livingEntityPatch.getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE) * multiplier);

                                projectile.setPos(shootPos);
                                projectile.setMaxStrikes(3);
                                projectile.setOwner(livingEntityPatch.getOriginal());
                                projectile.shoot(shootVec.x(), 0, shootVec.z(), 4.2f, 0);
                                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
                            }
                        }, AnimationEvent.Side.SERVER)));
    }
}
