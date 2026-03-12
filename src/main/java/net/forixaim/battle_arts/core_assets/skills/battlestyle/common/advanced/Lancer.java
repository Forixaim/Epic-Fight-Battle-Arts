package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

public class Lancer extends BattleStyle
{

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);
        eventListener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, CommonEvents::BUILD_METER, this);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
    }

    public Lancer(SkillBuilder<?> builder)
    {
        super(builder);
    }
}
