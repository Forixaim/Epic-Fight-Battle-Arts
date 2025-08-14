package net.forixaim.battle_arts.core_assets.skills.battlestyle.unique;

import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.skill.SkillContainer;

import java.util.UUID;

public class IronLotus extends BattleStyle
{
    private static final UUID ID = UUID.fromString("f0b5d0e6-bce5-4943-87ea-0609e82bdf4e");
    public IronLotus(Builder<?> builder)
    {
        super(builder);
    }


    @Override
    public void onInitiate(SkillContainer container)
    {


    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
    }

    @Override
    public void updateContainer(SkillContainer container)
    {
        super.updateContainer(container);
    }
}
