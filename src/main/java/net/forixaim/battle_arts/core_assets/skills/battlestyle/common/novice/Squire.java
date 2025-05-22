package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;

public class Squire extends BattleStyle
{
	//Linked Skills
	public static Skill HEAVY_BLOW;


	public Squire(Builder<?> builder)
	{
		super(builder);
		innateInactiveColor = new float[]{0.271f, 0.212f, 0.133f};
		innateSkillColor = new float[]{1f, 0.561f, 0f};
	}



	public static void RegisterInnates(SkillBuildEvent.ModRegistryWorker worker)
	{
		HEAVY_BLOW = worker.build("squire_heavy_blow", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireSwordAnimations.SQUIRE_SWORD_HEAVY_BLOW))
				.newProperty();
	}
}
