package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.DuelistStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.skills.combat_art.SkyStriker;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import net.neoforged.neoforge.registries.DeferredHolder;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.EntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

public class Duelist extends BattleStyle
{


    @Override
	public void onInitiate(SkillContainer container, EntityEventListener eventListener)
	{
		super.onInitiate(container, eventListener);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, SkillRegistry.SKY_STRIKER);

        eventListener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, CommonEvents::BUILD_METER, this);
        eventListener.registerEvent(EpicFightEventHooks.Player.CAST_SKILL, event -> {if (event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getPlayerPatch()) == DuelistStyles.DUELIST_SWORD && event.getSkillContainer().getSkill().getCategory() == SkillCategories.BASIC_ATTACK && container.getDataManager().getDataValue(BattleArtsDataKeys.COUNTER_WINDOW) > 0f)
        {
            event.getPlayerPatch().playAnimationSynchronized(DuelistSwordAnimations.DASH_ATTACK, 0);
        }}, this);

        eventListener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, CommonEvents::LOCK_MOVEMENT_GUARDING, this);

        eventListener.registerEvent(EpicFightEventHooks.Entity.ON_DODGE, event -> {
            if (event.getEntityPatch() instanceof ServerPlayerPatch && container.getDataManager().hasData(BattleArtsDataKeys.COUNTER_WINDOW))
            {
                container.getDataManager().setDataSync(BattleArtsDataKeys.COUNTER_WINDOW, 15f);
            }
        }, this);

        eventListener.registerEvent(EpicFightEventHooks.Entity.TAKE_DAMAGE_PRE, event -> {
            if (EpicFightCapabilities.getEntityPatch(event.getDamageSource().getEntity(), EntityPatch.class) instanceof LivingEntityPatch<?> livingEntityPatch && event.getEntityPatch().getEntityState().attacking())
            {
                livingEntityPatch.knockBackEntity(livingEntityPatch.getOriginal().position(), 2f);
                event.getEntityPatch().knockBackEntity(event.getEntityPatch().getOriginal().position(), 2f);
            }
        }, this);
	}
	@Override
	public void onRemoved(SkillContainer container) {
		super.onRemoved(container);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
	}

    public Duelist(SkillBuilder<?> builder) {
		super(builder);
	}

	@Override
	public void updateContainer(SkillContainer container)
	{
		super.updateContainer(container);
		if (!container.getExecutor().isLogicalClient() && container.getDataManager().hasData(BattleArtsDataKeys.COUNTER_WINDOW) && container.getDataManager().getDataValue(BattleArtsDataKeys.COUNTER_WINDOW) > 0f)
		{
			container.getDataManager().setDataSyncF(BattleArtsDataKeys.COUNTER_WINDOW, data -> data - 1.0f);
		}
	}
}
