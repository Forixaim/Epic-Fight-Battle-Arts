package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import net.forixaim.bs_api.proficiencies.Proficiencies;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;

public class Journeyman extends BattleStyle
{
    public static Skill WRATH;

    public Journeyman(Builder<?> builder) {
        super(builder);
        innateInactiveColor = new float[]{0.271f, 0.212f, 0.133f};
        innateSkillColor = new float[]{1f, 0.561f, 0f};
        proficiencySpecialization.add(Proficiencies.AXES);
    }
    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker) {

    }


}
