package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.DuelistStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.skills.combat_art.SkyStriker;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.EntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Duelist extends BattleStyle
{
	public static Skill QUAD_STING;
	public static Skill WHIRLEDGE;
	public static Skill SKY_STRIKER;

	private static final UUID EVENT_UUID = UUID.fromString("af0bfde5-2535-4ef6-b709-9277b17d2a1a");
	private static final CapabilityItem.WeaponCategories[] AVAILABLE_WEAPON_TYPES = {
			CapabilityItem.WeaponCategories.LONGSWORD,
			CapabilityItem.WeaponCategories.SWORD
	};

	@Override
	public void onInitiate(SkillContainer container)
	{
		super.onInitiate(container);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, SKY_STRIKER);
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID, CommonEvents::BUILD_METER);


		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID, event ->
		{
			if (event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getPlayerPatch()) == DuelistStyles.DUELIST_SWORD && event.getSkillContainer().getSkill().getCategory() == SkillCategories.BASIC_ATTACK && container.getDataManager().getDataValue(BattleArtsDataKeys.COUNTER_WINDOW.get()) > 0f)
			{
				event.getPlayerPatch().playAnimationSynchronized(DuelistSwordAnimations.DASH_ATTACK, 0);
			}
		});

		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID, CommonEvents.LOCK_MOVEMENT_GUARDING);
		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID, event ->
                container.getDataManager().setDataSync(BattleArtsDataKeys.COUNTER_WINDOW.get(), 15f));

		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_HURT, EVENT_UUID, event ->
		{
			if (EpicFightCapabilities.getEntityPatch(event.getDamageSource().getEntity(), EntityPatch.class) instanceof LivingEntityPatch<?> livingEntityPatch && event.getPlayerPatch().getEntityState().attacking())
			{
				livingEntityPatch.knockBackEntity(livingEntityPatch.getOriginal().position(), 2f);
				event.getPlayerPatch().knockBackEntity(event.getPlayerPatch().getOriginal().position(), 2f);
			}

		});
	}
	@Override
	public void onRemoved(SkillContainer container) {
		super.onRemoved(container);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID);

        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);

	}

	public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
	{
		QUAD_STING = worker.build("quad_sting", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistSwordAnimations.QUAD_STING)).newProperty();
		WHIRLEDGE = worker.build("whirledge", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistDualbladesAnimations.WHIRLEDGE)).newProperty();
		SKY_STRIKER = worker.build("sky_striker", SkyStriker::new, SkyStriker.createCombatArt().setResource(Resource.NONE));
	}

	public Duelist(Builder<? extends Skill> builder) {
		super(builder);
	}

	@Override
	public void updateContainer(SkillContainer container)
	{
		super.updateContainer(container);
		if (!container.getExecutor().isLogicalClient() && container.getDataManager().getDataValue(BattleArtsDataKeys.COUNTER_WINDOW.get()) > 0f)
		{
			container.getDataManager().setDataSyncF(BattleArtsDataKeys.COUNTER_WINDOW.get(), data -> data - 1.0f);
		}
	}
}
