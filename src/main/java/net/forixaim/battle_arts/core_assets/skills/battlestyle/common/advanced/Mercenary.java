package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.BattleArtsSkills;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

import java.util.UUID;

public class Mercenary extends BattleStyle
{


    private static final UUID EVENT_UUID = UUID.fromString("7e975e33-5226-47eb-8b0d-51fe9946f2e4");
    public Mercenary(SkillBuilder<?> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener)
    {
        super.onInitiate(container, listener);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, BattleArtsSkills.POWER_GEYSER);

        listener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, CommonEvents::LOCK_MOVEMENT_GUARDING, this);

    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
    }
}
