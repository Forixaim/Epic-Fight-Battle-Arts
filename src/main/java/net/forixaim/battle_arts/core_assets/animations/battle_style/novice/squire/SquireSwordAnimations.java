package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsComboAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.registry.entries.EpicFightSkillDataKeys;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.skill.SkillDataManager;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

import java.util.List;

public class SquireSwordAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
	public static AnimationManager.AnimationAccessor<SelectiveAnimation> IDLE_SET;
	public static AnimationManager.AnimationAccessor<StaticAnimation> AIR_IDLE;

	public static AnimationManager.AnimationAccessor<StaticAnimation> FALL;

	public static AnimationManager.AnimationAccessor<ActionAnimation> JUMP;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
	public static AnimationManager.AnimationAccessor<StaticAnimation> IMPACT_GUARD;
	public static AnimationManager.AnimationAccessor<StaticAnimation> PARRY_STANCE_1;
	public static AnimationManager.AnimationAccessor<StaticAnimation> PARRY_STANCE_2;
	public static AnimationManager.AnimationAccessor<SelectiveAnimation> GUARD_SET;

	public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
	public static AnimationManager.AnimationAccessor<GuardAnimation> PARRY_1;
	public static AnimationManager.AnimationAccessor<GuardAnimation> PARRY_2;
	public static AnimationManager.AnimationAccessor<StaticAnimation> SQUIRE_SWORD_CROUCH;
	public static AnimationManager.AnimationAccessor<MovementAnimation> SQUIRE_SWORD_CROUCH_WALK;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_1;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_2;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_AUTO_3;
	public static AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> SQUIRE_SWORD_DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> SQUIRE_SWORD_HOP_ATTACK;

	public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> SQUIRE_SWORD_HEAVY_BLOW;

	public static void Build(AnimationManager.AnimationBuilder builder)
	{

		IDLE = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "idle"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		AIR_IDLE = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "air_idle"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		FALL = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "fall"),
				accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

		IDLE_SET = builder.nextAccessor("battle_style/novice/squire/sword/idle_set_identifier", accessor -> new SelectiveAnimation(
				livingEntityPatch -> livingEntityPatch.getOriginal().onGround() ? 0 : 1, accessor,
				new DirectStaticAnimation(0.1f, true, BattleArts.identifier("battle_style/novice/squire/sword/idle_set/idle"), Armatures.BIPED), new DirectStaticAnimation(0.1f, true, BattleArts.identifier("battle_style/novice/squire/sword/idle_set/air_idle"), Armatures.BIPED)));


		JUMP = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "jump"),
				accessor -> new ActionAnimation(0.1f, accessor, Armatures.BIPED)
						.addStateRemoveOld(EntityState.MOVEMENT_LOCKED, false)
						.addStateRemoveOld(EntityState.COMBO_ATTACKS_DOABLE, true)
						.addStateRemoveOld(EntityState.SKILL_EXECUTABLE, true));

		SQUIRE_SWORD_WALK = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "walk"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));

		SQUIRE_SWORD_RUN = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "run"),
				accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));


		SQUIRE_SWORD_CROUCH = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED)
				.addState(EntityState.MOVEMENT_LOCKED, true));

		SQUIRE_SWORD_CROUCH_WALK = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "crouch_walk"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1f));

		SQUIRE_SWORD_AUTO_1 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto1"), accessor -> new BattleArtsComboAttackAnimation(0.1f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_AUTO_2 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto2"), accessor -> new BattleArtsComboAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_AUTO_3 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "auto3"), accessor -> new BattleArtsComboAttackAnimation(0.2f, 0f, 0.2f, 0.35f, 2.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));

		SQUIRE_SWORD_DASH_ATTACK = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "dash_attack"), accessor -> new BattleArtsComboAttackAnimation(0.2f, accessor, Armatures.BIPED,
				new AttackAnimation.Phase(0.0f, 0.0f, 0.2f, 0.3f, 0.5f, 1.0f, Armatures.BIPED.get().toolR, null)
						.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2f))));

		SQUIRE_SWORD_HOP_ATTACK = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "hop_attack"), accessor ->
				new AirSlashAnimation(0.1f, 0f, 0.2f, 0.35f, 2f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)

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
						.addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)
						.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
						{
							if (v2 >= 0.25f && v2 < 0.3f && !livingEntityPatch.getOriginal().onGround())
							{
								return 0.01f;
							}
							else if (v2 >= 0.3f && v2 < 0.35f && !livingEntityPatch.getOriginal().onGround())
							{
								return 0;
							}
							return 1;
						}));

		SQUIRE_SWORD_HEAVY_BLOW = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "heavy_blow"), accessor -> new BattleArtsAttackAnimation(0.1f, 0f, 0.7f, 0.8f, 1.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2f))
				.addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2f))
				.addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
				.addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
				.addState(EntityState.SKILL_EXECUTABLE, false));

		GUARD_SET = builder.nextAccessor("battle_style/novice/squire/sword/guard_set", access -> new SelectiveAnimation(
				livingEntityPatch -> {
					if (livingEntityPatch instanceof PlayerPatch<?> playerPatch)
					{
						SkillDataManager dataManager = playerPatch.getSkill(SkillSlots.GUARD).getDataManager();
						if (playerPatch.getSkill(SkillSlots.GUARD).hasSkill(EpicFightSkills.PARRYING.get()) && dataManager.hasData(EpicFightSkillDataKeys.PARRY_MOTION_COUNTER))
						{
							return (dataManager.getDataValue(EpicFightSkillDataKeys.PARRY_MOTION_COUNTER) % 2) + 1;
						}
						if (playerPatch.getSkill(SkillSlots.GUARD).hasSkill(EpicFightSkills.IMPACT_GUARD.get()))
						{
							return 3;
						}
					}
					return 0;
				}, access, GUARD, PARRY_STANCE_2, PARRY_STANCE_1, IMPACT_GUARD
		));

		GUARD = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));

		IMPACT_GUARD = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "impact_guard"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		PARRY_STANCE_1 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "parry_ready_1"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));
		PARRY_STANCE_2 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "parry_ready_2"), accessor -> new StaticAnimation(0.1f, true, accessor, Armatures.BIPED));

		GUARD_HIT = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_hit"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		PARRY_1 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_1"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));

		PARRY_2 = builder.nextAccessor(SquireAnimations.squireAnimationPath(CapabilityItem.WeaponCategories.SWORD, "guard_parry_2"), accessor -> new GuardAnimation(0.1f, accessor, Armatures.BIPED)
				.addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.5f));
	}
}
