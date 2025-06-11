package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;

public class Thief extends BattleStyle
{
    public Thief(Builder<?> builder) {
        super(builder);
        innateInactiveColor = new float[]{0.671f, 0.71f, 0.71f};
        innateSkillColor = new float[]{0.929f, 0.996f, 1};
    }

    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
    {

    }
}
