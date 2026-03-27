package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.MountedMoveset;
import net.forixaim.battle_arts_api.battle_arts_skills.CoreAPIDataKeys;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

public class Squire extends BattleStyle implements MountedMoveset
{
	//Linked Skills


    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);
        eventListener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, event -> container.getDataManager().setDataSync(CoreAPIDataKeys.HIT_STOP_TICKS, Math.round(event.getDamageSource().getBaseImpact())), this);
    }

    public Squire(SkillBuilder<?> builder)
	{
		super(builder);
	}
}
