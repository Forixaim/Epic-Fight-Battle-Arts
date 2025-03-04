package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class AdvancedBattleStyles
{
    public static Skill RONIN;
    public static void register(SkillBuildEvent.ModRegistryWorker worker)
    {
        Ronin.buildSkills(worker);
        RONIN = worker.build("ronin", Ronin::new, BattleStyle.CreateBattleStyle());

    }
}
