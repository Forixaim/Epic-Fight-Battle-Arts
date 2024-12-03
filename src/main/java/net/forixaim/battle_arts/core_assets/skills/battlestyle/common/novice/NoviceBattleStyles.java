package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class NoviceBattleStyles
{
	public static Skill SQUIRE;

	public static void register(SkillBuildEvent.ModRegistryWorker worker)
	{
		SQUIRE = worker.build("squire", Squire::new, Squire.CreateBattleStyle());
	}
}