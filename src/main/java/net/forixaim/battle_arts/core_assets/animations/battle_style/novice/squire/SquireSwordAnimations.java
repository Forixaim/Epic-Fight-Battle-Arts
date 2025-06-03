package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class SquireSwordAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> SQUIRE_SWORD_IDLE;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> SQUIRE_SWORD_GUARD;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_HIT;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_PARRY_1;
	public static AnimationManager.AnimationAccessor<GuardAnimation> SQUIRE_SWORD_GUARD_PARRY_2;
	public static AnimationManager.AnimationAccessor<StaticAnimation> SQUIRE_SWORD_CROUCH;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_CROUCH_WALK;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SQUIRE_SWORD_AUTO_1;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SQUIRE_SWORD_AUTO_2;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SQUIRE_SWORD_AUTO_3;
	public static AnimationManager.AnimationAccessor<DashAttackAnimation> SQUIRE_SWORD_DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> SQUIRE_SWORD_HOP_ATTACK;

	public static AnimationManager.AnimationAccessor<AttackAnimation> SQUIRE_SWORD_HEAVY_BLOW;

	public static void Build(AnimationManager.AnimationBuilder event)
	{

		SQUIRE_SWORD_IDLE = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "idle"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "walk"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_RUN = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "run"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_CROUCH = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED)
				.addState(EntityState.MOVEMENT_LOCKED, true));

		SQUIRE_SWORD_CROUCH_WALK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch_walk"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1f));

		SQUIRE_SWORD_AUTO_1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto1"), accessor -> new BasicAttackAnimation(0.1f, 0f, 0.35f, 0.5f, 0.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));

		SQUIRE_SWORD_AUTO_2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto2"), accessor -> new BasicAttackAnimation(0.1f, 0f, 0.45f, 0.55f, 0.8f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));

		SQUIRE_SWORD_AUTO_3 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto3"), accessor -> new BasicAttackAnimation(0.1f, 0f, 0.45f, 0.55f, 2.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));

		SQUIRE_SWORD_DASH_ATTACK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "dash_attack"), accessor -> new DashAttackAnimation(0.2f, accessor, Armatures.BIPED,
				new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.3f, 0.4f, 0.5f, Armatures.BIPED.get().toolR, null)
						.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3f)),
				new AttackAnimation.Phase(0.5f, 0.0f, 0.9f, 1.0f, 3f, 2.0f, Armatures.BIPED.get().toolR, null)
						.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
						.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7f))
						.addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2f))));

		SQUIRE_SWORD_HOP_ATTACK = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "hop_attack"), accessor -> new AirSlashAnimation(0f, 0f, 0.5f, 0.65f, 2f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false));

		SQUIRE_SWORD_HEAVY_BLOW = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "heavy_blow"), accessor -> new AttackAnimation(0f, 0f, 1.6f, 1.8f, 5f, ColliderPreset.DUAL_SWORD_AIR_SLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2f))
				.addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(4f))
				.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
				.addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.1f)
				.addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
				.addState(EntityState.CAN_SKILL_EXECUTION, false));



		SQUIRE_SWORD_GUARD = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_GUARD_HIT = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_hit"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		SQUIRE_SWORD_GUARD_PARRY_1 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_1"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		SQUIRE_SWORD_GUARD_PARRY_2 = event.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_2"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));
	}
}
