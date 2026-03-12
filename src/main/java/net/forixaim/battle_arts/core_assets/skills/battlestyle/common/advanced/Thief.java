package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

public class Thief extends BattleStyle
{
    public Thief(SkillBuilder<?> builder) {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container,  eventListener);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, SkillRegistry.MUG);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
        super.onRemoved(container);
    }
}
