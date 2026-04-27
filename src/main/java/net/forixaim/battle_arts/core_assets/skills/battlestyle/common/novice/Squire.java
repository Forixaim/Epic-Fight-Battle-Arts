package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.MountedMoveset;
import net.forixaim.battle_arts.initialization.registry.ItemRegistry;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.CoreAPIDataKeys;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
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
        eventListener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, CommonEvents::LOCK_MOVEMENT_CROUCHING, this);
        eventListener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, event ->
        {
            container.getDataManager().setDataSync(CoreAPIDataKeys.HIT_STOP_TICKS, Math.round(event.getDamageSource().getBaseImpact()));
            if (event.getDamageSource().getAnimation() == SquireSwordAnimations.SQUIRE_SWORD_HEAVY_BLOW)
            {
                if (event.getEntityPatch().getOriginal().getMainHandItem().is(ItemRegistry.ERDRICKS_SWORD))
                    event.getTarget().playSound(SoundRegistry.CRITICAL_HIT.get(), 1.0f, 1.0f);
                if (event.getEntityPatch().getOriginal().getMainHandItem().is(ItemRegistry.DRAGOVIAN_KING_SWORD))
                    event.getTarget().playSound(SoundRegistry.CRITICAL_HIT_DQ8.get(), 1.0f, 1.0f);
            }
        }, this);;
    }

    public Squire(SkillBuilder<?> builder)
	{
		super(builder);
	}
}
