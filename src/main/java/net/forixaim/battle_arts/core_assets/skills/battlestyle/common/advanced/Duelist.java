package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.DuelistStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.combat_art.Mug;
import net.forixaim.battle_arts.core_assets.skills.combat_art.SkyStriker;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Steal;
import net.forixaim.bs_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
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
		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_EXECUTE_EVENT, EVENT_UUID, event ->
		{
			if (event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getPlayerPatch()) == DuelistStyles.DUELIST_SWORD && event.getSkillContainer().getSkill().getCategory() == SkillCategories.BASIC_ATTACK && container.getDataManager().getDataValue(BattleArtsDataKeys.COUNTER_WINDOW.get()) > 0f)
			{
				event.getPlayerPatch().playAnimationSynchronized(DuelistSwordAnimations.DASH_ATTACK, 0);
			}
		});
		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID, event ->
                container.getDataManager().setDataSync(BattleArtsDataKeys.COUNTER_WINDOW.get(), 15f, event.getPlayerPatch().getOriginal()));

		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.HURT_EVENT_PRE, EVENT_UUID, event ->
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
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SKILL_EXECUTE_EVENT, EVENT_UUID);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.HURT_EVENT_PRE, EVENT_UUID);

	}

	public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
	{
		QUAD_STING = worker.build("quad_sting", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistSwordAnimations.QUAD_STING)).newProperty();
		SKY_STRIKER = worker.build("sky_striker", SkyStriker::new, SkyStriker.createCombatArt().setResource(Resource.COOLDOWN));
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
			container.getDataManager().setDataSyncF(BattleArtsDataKeys.COUNTER_WINDOW.get(), data -> data -= 1.0f, container.getServerExecutor().getOriginal());
		}
	}
}
