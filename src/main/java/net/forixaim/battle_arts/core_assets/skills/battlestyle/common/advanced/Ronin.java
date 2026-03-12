package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.UsesUchigatana;
import net.forixaim.battle_arts.core_assets.skills.combat_art.TranquilityUnleash;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Tranquility;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.registries.DeferredHolder;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.UUID;

public class Ronin extends BattleStyle implements UsesUchigatana
{

	public Ronin(SkillBuilder<?> builder)
	{
		super(builder);
	}

	@Override
	public void onInitiate(SkillContainer container, EntityEventListener listener) {
		super.onInitiate(container, listener);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, SkillRegistry.TRANQUILITY_UNLEASH);

        listener.registerEvent(EpicFightEventHooks.Entity.MODIFY_ATTACK_SPEED, event -> {
            if (event.getItemCapability().getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI)
            {
                event.setAttackSpeed(event.getAttackSpeed() * 2f);
            }
        }, this);
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
        super.onRemoved(container);
		NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
	}


	@Override
	public void executeOnServer(SkillContainer container, CompoundTag args)
	{
		super.executeOnServer(container, args);
		if (container.getDataManager().getDataValue(BattleArtsDataKeys.TRANQUILITY_SHEATH))
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.TRANQUILITY_SHEATH, false);
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
		else
		{
			container.getDataManager().setDataSync(BattleArtsDataKeys.TRANQUILITY_SHEATH, true);
			container.getServerExecutor().modifyLivingMotionByCurrentItem(true);
		}
	}
}
