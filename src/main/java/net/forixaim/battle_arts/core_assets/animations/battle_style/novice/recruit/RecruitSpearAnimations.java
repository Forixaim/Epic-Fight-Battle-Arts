package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class RecruitSpearAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_IDLE;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_GUARD;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_CROUCH;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_STANDING_ATTACK;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_STANDING_ATTACK_2;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> RECRUIT_SPEAR_DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> RECRUIT_SPEAR_AERIAL_POKE;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_HIT;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_PARRY;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_PARRY_2;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_SHIELD_IDLE;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_SHIELD_CROUCH;

	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_SHIELD_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_SHIELD_RUN;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO1;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO2;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO3;
	public static AnimationManager.AnimationAccessor<DashAttackAnimation> RECRUIT_SPEAR_SHIELD_DASH;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> RECRUIT_SPEAR_SHIELD_AIRSLASH;
	public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE;



	public static void Build(AnimationManager.AnimationBuilder event)
	{
		RECRUIT_SPEAR_IDLE = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "idle"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_WALK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "walk"), accessor -> new MovementAnimation(0.1f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_RUN = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "run"), accessor -> new MovementAnimation(0.1f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_CROUCH = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "crouch"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_STANDING_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack"), accessor -> new BasicAttackAnimation(0.2f, 0.0f, 0.35f, 0.5f, 0.75f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_STANDING_ATTACK_2 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack2"), accessor -> new BasicAttackAnimation(0.0f, 0.0f, 0.55f, 0.8f, 1.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_DASH_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "dash_attack"), accessor -> new BattleArtsComboAttackAnimation(0.0f, 0.0f, 0.7f, 0.8f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 45d)
				.addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1d));
		RECRUIT_SPEAR_AERIAL_POKE = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "aerial_poke"), accessor -> new AirSlashAnimation(0.0f, 0.0f, 0.7f, 0.8f, 1.7f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD_HIT = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_hit"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD_PARRY = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_parry"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD_PARRY_2 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_parry_2"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_IDLE = event.nextAccessor("battle_style/novice/recruit/spear_shield/idle", accessor -> new StaticAnimation(0.2f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_CROUCH = event.nextAccessor("battle_style/novice/recruit/spear_shield/crouch", accessor -> new StaticAnimation(0.2f, true, accessor, Armatures.BIPED));

		RECRUIT_SPEAR_SHIELD_WALK = event.nextAccessor("battle_style/novice/recruit/spear_shield/walk", accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_RUN = event.nextAccessor("battle_style/novice/recruit/spear_shield/run", accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED));

		RECRUIT_SPEAR_SHIELD_AUTO1 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto1", accessor ->  new BasicAttackAnimation(0.2f, 0.0f, 0.35f, 0.5f, 0.75f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_AUTO2 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto2", accessor ->  new BasicAttackAnimation(0.2f, 0.0f, 0.7f, 0.8f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_AUTO3 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto3", accessor ->  new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_DASH = event.nextAccessor("battle_style/novice/recruit/spear_shield/dash", accessor ->  new DashAttackAnimation(0.2f, 0.0f, 0.2f, 0.3f, 1f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
				.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1))
				.addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
				.addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT));
		RECRUIT_SPEAR_SHIELD_AIRSLASH = event.nextAccessor("battle_style/novice/recruit/spear_shield/airslash", accessor ->  new AirSlashAnimation(0.2f, 0.0f, 0.35f, 0.5f, 1f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE = event.nextAccessor("battle_style/novice/recruit/spear_shield/dual_puncture", accessor ->  new AttackAnimation(0.2f, accessor, Armatures.BIPED,
				new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.3f, 0.5f, 0.5f, Armatures.BIPED.get().toolR, null),
				new AttackAnimation.Phase(0.5f, 0.0f, 1.1f, 1.2f, 3f, 2.0f, Armatures.BIPED.get().toolR, null).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()))
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.25f)
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
