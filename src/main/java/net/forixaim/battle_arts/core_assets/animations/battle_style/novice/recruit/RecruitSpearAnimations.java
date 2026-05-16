package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import net.forixaim.battle_arts_api.animation_types.AnimationTags;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;

import yesman.epicfight.registry.entries.EpicFightParticles;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

import java.util.List;
import java.util.Set;

public class RecruitSpearAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
	public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
	public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> CROUCH;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> AUTO1;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> AUTO2;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> JUMP_ATTACK;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_HIT;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_PARRY;
	public static AnimationManager.AnimationAccessor<GuardAnimation> RECRUIT_SPEAR_GUARD_PARRY_2;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_SHIELD_IDLE;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_SHIELD_CROUCH;

	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_SHIELD_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_SHIELD_RUN;
	public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO1;
	public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO2;
	public static AnimationManager.AnimationAccessor<ComboAttackAnimation> RECRUIT_SPEAR_SHIELD_AUTO3;
	public static AnimationManager.AnimationAccessor<DashAttackAnimation> RECRUIT_SPEAR_SHIELD_DASH;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> RECRUIT_SPEAR_SHIELD_AIRSLASH;
	public static AnimationManager.AnimationAccessor<AttackAnimation> RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE;



	public static void Build(AnimationManager.AnimationBuilder event)
	{
		IDLE = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "idle"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		GUARD = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		WALK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "walk"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
						v * 1.5f));
		RUN = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "run"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED));
		CROUCH = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "crouch"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));

		AUTO1 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack"), accessor ->
				new BattleArtsComboAttackAnimation(0.2f, 0.0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)

						.addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(AnimationTags.SLASH))
						.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
		AUTO2 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack2"), accessor -> new
				BattleArtsComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.35f, 1.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(AnimationTags.PUNCTURE))
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		DASH_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "dash_attack"), accessor -> new BattleArtsComboAttackAnimation(0.1f, 0.0f, 0.2f, 0.35f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 45d)
				.addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1d)
				.addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(AnimationTags.PUNCTURE))

				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		JUMP_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "aerial_poke"),
				accessor -> new AirSlashAnimation(0.1f, 0.0f, 0.2f, 0.4f, 1.7f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
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
							if (v2 >= 0.3f && v2 < 0.4f && !livingEntityPatch.getOriginal().onGround())
							{
								return 0.005f;
							}
							return 1;
						})
		);
		RECRUIT_SPEAR_GUARD_HIT = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_hit"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD_PARRY = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_parry"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_GUARD_PARRY_2 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "guard_parry_2"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_IDLE = event.nextAccessor("battle_style/novice/recruit/spear_shield/idle", accessor -> new StaticAnimation(0.2f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_CROUCH = event.nextAccessor("battle_style/novice/recruit/spear_shield/crouch", accessor -> new StaticAnimation(0.2f, true, accessor, Armatures.BIPED));

		RECRUIT_SPEAR_SHIELD_WALK = event.nextAccessor("battle_style/novice/recruit/spear_shield/walk", accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_SHIELD_RUN = event.nextAccessor("battle_style/novice/recruit/spear_shield/run", accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED));

		RECRUIT_SPEAR_SHIELD_AUTO1 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto1", accessor ->  new ComboAttackAnimation(0.2f, 0.0f, 0.35f, 0.5f, 0.75f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_AUTO2 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto2", accessor ->  new ComboAttackAnimation(0.2f, 0.0f, 0.7f, 0.8f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_AUTO3 = event.nextAccessor("battle_style/novice/recruit/spear_shield/auto3", accessor ->  new ComboAttackAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
		RECRUIT_SPEAR_SHIELD_DASH = event.nextAccessor("battle_style/novice/recruit/spear_shield/dash", accessor ->  new DashAttackAnimation(0.2f, accessor, Armatures.BIPED,
                new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.3f, 1f, 0.0f, InteractionHand.OFF_HAND, Armatures.BIPED.get().rootJoint, ColliderPreset.BATTOJUTSU_DASH))
				.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
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
