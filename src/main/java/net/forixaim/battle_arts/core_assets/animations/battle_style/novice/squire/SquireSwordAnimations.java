package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class SquireSwordAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
	public static AnimationManager.AnimationAccessor<SelectiveAnimation> IDLE_SET;
	public static AnimationManager.AnimationAccessor<StaticAnimation> AIR_IDLE;

	public static AnimationManager.AnimationAccessor<StaticAnimation> FALL;

	public static AnimationManager.AnimationAccessor<ActionAnimation> JUMP;
	public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_HIT;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_PARRY_1;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_PARRY_2;
	public static AnimationManager.AnimationAccessor<StaticAnimation> SQUIRE_SWORD_CROUCH;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_CROUCH_WALK;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_1;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_2;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_3;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> SQUIRE_SWORD_HOP_ATTACK;

	public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> SQUIRE_SWORD_HEAVY_BLOW;

	public static void Build(AnimationManager.AnimationBuilder event)
	{

		IDLE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "idle"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		AIR_IDLE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "air_idle"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		FALL = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "fall"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		IDLE_SET = event.nextAccessor("battle_style/novice/squire/sword/idle_set_identifier", accessor -> new SelectiveAnimation(
				livingEntityPatch -> livingEntityPatch.getOriginal().onGround() ? 0 : 1, accessor,
				new DirectStaticAnimation(0.1f, true, BattleArts.identifier("battle_style/novice/squire/sword/idle_set/idle"), Armatures.BIPED), new DirectStaticAnimation(0.1f, true, BattleArts.identifier("battle_style/novice/squire/sword/idle_set/air_idle"), Armatures.BIPED)));


		JUMP = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "jump"),
				accessor -> new ActionAnimation(0.1f, accessor, Armatures.BIPED)
						.addStateRemoveOld(EntityState.MOVEMENT_LOCKED, false)
						.addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, true)
						.addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true));

		WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "walk"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));

		RUN = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "run"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));


		SQUIRE_SWORD_CROUCH = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED)
				.addState(EntityState.MOVEMENT_LOCKED, true));

		SQUIRE_SWORD_CROUCH_WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch_walk"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1f));

		SQUIRE_SWORD_AUTO_1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto1"), accessor -> new BattleArtsComboAttackAnimation(0.1f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_AUTO_2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto2"), accessor -> new BattleArtsComboAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_AUTO_3 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto3"), accessor -> new BattleArtsComboAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 2.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_DASH_ATTACK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "dash_attack"), accessor -> new BattleArtsComboAttackAnimation(0.2f, accessor, Armatures.BIPED,
				new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.3f, 0.5f, 1.0f, Armatures.BIPED.get().toolR, null)
						.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2f))));

		SQUIRE_SWORD_HOP_ATTACK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "hop_attack"), accessor ->
				new AirSlashAnimation(0.1f, 0f, 0.2f, 0.35f, 2f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
						.addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)
						.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_HEAVY_BLOW = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "heavy_blow"), accessor -> new BattleArtsAttackAnimation(0.1f, 0f, 0.7f, 0.8f, 1.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2f))
				.addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2f))
				.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
				.addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
				.addState(EntityState.CAN_SKILL_EXECUTION, false));



		GUARD = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_GUARD_HIT = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_hit"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		SQUIRE_SWORD_GUARD_PARRY_1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_1"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		SQUIRE_SWORD_GUARD_PARRY_2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_2"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));
	}
}