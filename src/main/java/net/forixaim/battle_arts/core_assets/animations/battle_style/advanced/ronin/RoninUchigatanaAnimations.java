package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin;

import net.forixaim.battle_arts.initialization.registry.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.projectiles.FlyingShockwaveProjectile;
import net.forixaim.battle_arts.initialization.registry.BattleArtsSounds;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;

import yesman.epicfight.registry.entries.EpicFightParticles;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class RoninUchigatanaAnimations
{
    public static AnimationManager.AnimationAccessor<ActionAnimation> RONIN_UCHIGATANA_UNSHEATHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> RONIN_UCHIGATANA_IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> RONIN_UCHIGATANA_GUARD;
    public static AnimationManager.AnimationAccessor<StaticAnimation> RONIN_UCHIGATANA_SHEATHE_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> RONIN_UCHIGATANA_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> RONIN_UCHIGATANA_SHEATHE_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> RONIN_UCHIGATANA_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> RONIN_UCHIGATANA_GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RONIN_UCHIGATANA_RUN;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RONIN_UCHIGATANA_AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RONIN_UCHIGATANA_AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RONIN_UCHIGATANA_AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> RONIN_UCHIGATANA_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> RONIN_UCHIGATANA_AIRSLASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> FLASH_CLEAVE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> FLYING_SHOCKWAVE;


    public static AnimationManager.AnimationAccessor<MovementAnimation> RONIN_UCHIGATANA_SHEATHE_RUN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RONIN_UCHIGATANA_SHEATHE_WALK;

    public static AnimationManager.AnimationAccessor<ActionAnimation> RONIN_UCHIGATANA_SHEATHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> RONIN_UCHIGATANA_SHEATHE_IDLE;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RONIN_UCHIGATANA_SHEATHE_AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RONIN_UCHIGATANA_SHEATHE_AUTO2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> RONIN_UCHIGATANA_SHEATHE_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> RONIN_UCHIGATANA_SHEATHE_AIRSLASH;

    public static void onRegister(AnimationManager.AnimationBuilder event)
    {
        RONIN_UCHIGATANA_IDLE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "idle"), access -> new StaticAnimation(
                true, access, Armatures.BIPED
                )
        );

        RONIN_UCHIGATANA_GUARD = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "guard"), access ->
                new StaticAnimation(true, access, Armatures.BIPED));

        RONIN_UCHIGATANA_GUARD_HIT = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA,
                "guard_hit"), access ->
                new GuardAnimation(0.1f, 0.35f, access, Armatures.BIPED));

        RONIN_UCHIGATANA_SHEATHE_GUARD = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_guard"), access ->
                new StaticAnimation(true, access, Armatures.BIPED));

        RONIN_UCHIGATANA_SHEATHE_GUARD_HIT = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA,
                "sheathe_guard_hit"), access ->
                new GuardAnimation(0.1f, 0.35f, access, Armatures.BIPED));
        RONIN_UCHIGATANA_GUARD_PARRY_1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA,
                "guard_parry2"), access ->
                new GuardAnimation(0.1f, 0.35f, access, Armatures.BIPED));
        RONIN_UCHIGATANA_GUARD_PARRY_2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA,
                "guard_parry1"), access ->
                new GuardAnimation(0.1f, 0.35f, access, Armatures.BIPED));

        RONIN_UCHIGATANA_SHEATHE_IDLE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_idle_fix1"), access -> new StaticAnimation(
                        true, access, Armatures.BIPED
                )
        );
        RONIN_UCHIGATANA_RUN = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "run"), access -> new MovementAnimation(
                        true, access, Armatures.BIPED
                )
        );

        RONIN_UCHIGATANA_SHEATHE_RUN = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_run"), access -> new MovementAnimation(
                        true, access, Armatures.BIPED
                )
        );

        RONIN_UCHIGATANA_SHEATHE_WALK = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "walk"), access -> new MovementAnimation(
                        true, access, Armatures.BIPED
                )
        );

        RONIN_UCHIGATANA_SHEATHE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe"), access ->
                new ActionAnimation(0.05f, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.4f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(BattleArtsSounds.SHEATHE.get())));
        RONIN_UCHIGATANA_UNSHEATHE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "unsheathe"), access ->
                new ActionAnimation(0.05f, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.2f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(BattleArtsSounds.UNSHEATHE.get())));

        RONIN_UCHIGATANA_AIRSLASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "airslash"),
                access -> new AirSlashAnimation(0.2f, 0.0f, 0.5f, 0.65f, 1f, true, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));



        RONIN_UCHIGATANA_AUTO1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "auto1"),
                accessor -> new ComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.3f, 0.35f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.SWORDMASTER_SWING.get())
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
        RONIN_UCHIGATANA_AUTO2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "auto2"),
                accessor -> new ComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.3f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.SWORDMASTER_SWING.get())
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
        RONIN_UCHIGATANA_AUTO3 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "auto3"),
                accessor -> new ComboAttackAnimation(0.2f, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.35f, 1.1f, 1.1f,  Armatures.BIPED.get().toolR, null).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2f)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.SWORDMASTER_SWING.get()))
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
        RONIN_UCHIGATANA_DASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "dash_attack"),
            accessor -> new DashAttackAnimation(0.2f, 0.0f, 0.7f, 0.8f, 2.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                    .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get()).addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.2f).addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                    .addEvents(AnimationEvent.InTimeEvent.create(0.25f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(BattleArtsSounds.JUMP.get())));

        RONIN_UCHIGATANA_SHEATHE_AIRSLASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_air_attack"),
                access -> new AirSlashAnimation(0.0f, 0.0f, 0.05f, 0.15f, 0.75f, true, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.35f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.35f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.3f));

        FLASH_CLEAVE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "flash_cleave"),
                accessor -> new AttackAnimation(0.05f, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0f, 0f, 0.5f, 0.6f, 0.8f, 0.8f,  Armatures.BIPED.get().rootJoint, ColliderPreset.BATTOJUTSU_DASH))
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.0f)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.5f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.SERVER).params(BattleArtsSounds.HEAVY_SLASH.get())));

        FLYING_SHOCKWAVE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "flying_shockwave"),
                accessor -> new AttackAnimation(0.05f, 0.0f, 0.4f, 5f, 2.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4f))
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.1f)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.4f, (livingEntityPatch, assetAccessor, animationParameters) ->
                        {
                            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
                            Vec3 shootVec = new Vec3(Math.cos(ang), 0 , Math.sin(ang));
                            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z);

                            FlyingShockwaveProjectile projectile = BattleArtsProjectiles.FLYING_SHOCKWAVE.get().create(livingEntityPatch.getOriginal().level());

                            if (projectile != null)
                            {
                                projectile.setDamage((float) livingEntityPatch.getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE));
                                projectile.setPos(shootPos);
                                projectile.setMaxStrikes(3);
                                projectile.setOwner(livingEntityPatch.getOriginal());
                                projectile.shoot(shootVec.x(), 0, shootVec.z(), 4.2f, 0);
                                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
                            }
                        }, AnimationEvent.Side.SERVER)));

        RONIN_UCHIGATANA_SHEATHE_DASH = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_dash_attack"),
                accessor -> new DashAttackAnimation(0.2f, 0.0f, 0.2f, 0.35f, 2.0f, ColliderPreset.FIST, Armatures.BIPED.get().handR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.4f).addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));

        RONIN_UCHIGATANA_SHEATHE_AUTO1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_auto1"),
                accessor -> new ComboAttackAnimation(0.2f, 0.0f, 0.25f, 0.4f, 0.5f, ColliderPreset.FIST, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.1f));
        RONIN_UCHIGATANA_SHEATHE_AUTO2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.UCHIGATANA, "sheathe_auto2"),
                accessor -> new ComboAttackAnimation(0.2f, 0.0f, 0.45f, 0.5f, 0.75f, ColliderPreset.FIST, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2f))
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_ROD.get())
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2).addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.1f));
    }
}
