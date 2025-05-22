package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.combat_art.TranquilityUnleash;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Tranquility;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.TranquilityPassive;
import net.forixaim.bs_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;

import net.forixaim.efm_ex.capabilities.weaponcaps.EXWeaponCapability;
import net.minecraft.network.FriendlyByteBuf;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.BattojutsuPassive;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Ronin extends BattleStyle
{
	public static Skill TRANQUILITY;
	public static Skill TRANQUILITY_PASSIVE;
	public static Skill TRANQUILITY_UNLEASH;
	public static Skill BLOSSOM_SLASH;
	private static final UUID EVENT_UUID = UUID.fromString("55220562-9883-4a57-bd92-a6257127cb66");
	public Ronin(Builder<? extends Skill> builder)
	{
		super(builder);
	}

	@Override
	public void onInitiate(SkillContainer container) {
		super.onInitiate(container);
		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MODIFY_ATTACK_SPEED_EVENT, EVENT_UUID, event ->
		{
			if (event.getItemCapability().getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI)
			{
				event.setAttackSpeed(event.getAttackSpeed() * 2f);
			}
		});
	}

	public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
	{
		BLOSSOM_SLASH = worker.build("blossom_slash", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RoninTachiAnimations.BLOSSOM_SLASH)).newProperty();
		TRANQUILITY_PASSIVE = worker.build("tranquility_passive", TranquilityPassive::new, Skill.createBuilder().setResource(Resource.NONE).setCategory(SkillCategories.WEAPON_PASSIVE));
		TRANQUILITY = worker.build("tranquility", Tranquility::new, WeaponInnateSkill.createWeaponInnateBuilder().setResource(Resource.NONE));
		TRANQUILITY_UNLEASH = worker.build("tranquility_unleash", TranquilityUnleash::new, CombatArt.createCombatArt().setResource(Resource.COOLDOWN));
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
	}


	@Override
	public void executeOnServer(SkillContainer container, FriendlyByteBuf args)
	{
		super.executeOnServer(container, args);
		if (container.getDataManager().getDataValue(BattleArtsDataKeys.BATTO_SHEATH.get()))
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.BATTO_SHEATH.get(), false, container.getServerExecutor().getOriginal());
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
		else
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.BATTO_SHEATH.get(), true, container.getServerExecutor().getOriginal());
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
	}
}
