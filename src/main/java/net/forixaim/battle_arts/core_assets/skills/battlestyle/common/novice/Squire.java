package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.MountedMoveset;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.HeavyDraw;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class Squire extends BattleStyle implements MountedMoveset
{
	//Linked Skills
	public static Skill HEAVY_BLOW;
	public static Skill POWER_DRAW;
	public static Skill DISEMBOWELMENT;



	public Squire(Builder<?> builder)
	{
		super(builder);
		innateInactiveColor = new float[]{0.271f, 0.212f, 0.133f};
		innateSkillColor = new float[]{1f, 0.561f, 0f};
	}


	public static void RegisterInnates(SkillBuildEvent.ModRegistryWorker worker)
	{
		HEAVY_BLOW = worker.build("squire_heavy_blow", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireSwordAnimations.SQUIRE_SWORD_HEAVY_BLOW)).newProperty();
		POWER_DRAW = worker.build("power_draw", HeavyDraw::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(ActivateType.CHARGING)).newProperty();
		DISEMBOWELMENT = worker.build("disembowelment", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireDaggerAnimations.DISEMBOWELMENT)).newProperty();
	}
}
