package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class RecruitSpearAnimations
{
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_IDLE;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_WALK;
	public static AnimationManager.AnimationAccessor<MovementAnimation> RECRUIT_SPEAR_RUN;
	public static AnimationManager.AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_CROUCH;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_STANDING_ATTACK;
	public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_STANDING_ATTACK_2;
	public static AnimationManager.AnimationAccessor<DashAttackAnimation> RECRUIT_SPEAR_DASH_ATTACK;
	public static AnimationManager.AnimationAccessor<AirSlashAnimation> RECRUIT_SPEAR_AERIAL_POKE;

	public static void Build(AnimationManager.AnimationBuilder event)
	{
		RECRUIT_SPEAR_IDLE = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "idle"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_WALK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "walk"), accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_RUN = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "run"), accessor -> new MovementAnimation(true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_CROUCH = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "crouch"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_STANDING_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack"), accessor -> new BasicAttackAnimation(0.2f, 0.0f, 0.35f, 0.5f, 0.75f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_STANDING_ATTACK_2 = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "standing_attack2"), accessor -> new BasicAttackAnimation(0.0f, 0.0f, 0.55f, 0.8f, 1.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_DASH_ATTACK = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "dash_attack"), accessor -> new DashAttackAnimation(0.0f, 0.0f, 0.7f, 0.8f, 1.7f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
		RECRUIT_SPEAR_AERIAL_POKE = event.nextAccessor(RecruitAnimations.recruitAnimationPath(CapabilityItem.WeaponCategories.SPEAR, "aerial_poke"), accessor -> new AirSlashAnimation(0.0f, 0.0f, 0.7f, 0.8f, 1.7f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
	}
}
