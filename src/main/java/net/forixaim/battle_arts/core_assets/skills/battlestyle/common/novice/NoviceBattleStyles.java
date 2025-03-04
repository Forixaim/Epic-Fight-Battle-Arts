package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class NoviceBattleStyles
{
	public static Skill SQUIRE;
	public static Skill RECRUIT;
	public static Skill JOURNEYMAN;

	public static void register(SkillBuildEvent.ModRegistryWorker worker)
	{
		Squire.RegisterInnates(worker);
		SQUIRE = worker.build("squire", Squire::new, Squire.CreateBattleStyle());

		Recruit.RegisterInnates(worker);
		RECRUIT = worker.build("recruit", Recruit::new, Recruit.CreateBattleStyle());

		Journeyman.buildSkills(worker);
		JOURNEYMAN = worker.build("journeyman", Journeyman::new, Journeyman.CreateBattleStyle());
	}
}
