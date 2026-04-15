package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class AdvancedBattleStyles
{
    public static Skill RONIN;
    public static Skill THIEF;
    public static Skill DUELIST;
    public static Skill MERCENARY;
    public static Skill LANCER;

    public static void register(SkillBuildEvent.ModRegistryWorker worker)
    {
        Ronin.buildSkills(worker);
        Thief.buildSkills(worker);
        Duelist.buildSkills(worker);
        Mercenary.buildSkills(worker);
        Lancer.buildSkill(worker);
        THIEF = worker.build("thief", Thief::new, BattleStyle.createBattleStyleBuilder());
        LANCER = worker.build("lancer", Lancer::new, BattleStyle.createBattleStyleBuilder());
        RONIN = worker.build("ronin", Ronin::new, BattleStyle.createBattleStyleBuilder());
        DUELIST = worker.build("duelist", Duelist::new, BattleStyle.createBattleStyleBuilder());
        MERCENARY = worker.build("mercenary", Mercenary::new, BattleStyle.createBattleStyleBuilder());

    }
}
