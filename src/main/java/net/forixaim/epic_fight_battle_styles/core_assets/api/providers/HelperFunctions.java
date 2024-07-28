package net.forixaim.epic_fight_battle_styles.core_assets.api.providers;

import net.minecraft.world.InteractionHand;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillSlot;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class HelperFunctions
{
	//Initial Helper Functions
	public static boolean itemCheck(LivingEntityPatch<?> entityPatch, WeaponCategory category, InteractionHand hand)
	{
		return entityPatch.getHoldingItemCapability(hand).getWeaponCategory() == category;
	}
	public static boolean skillCheck(LivingEntityPatch<?> entityPatch, Skill skill, SkillSlot slot)
	{
		if (entityPatch instanceof PlayerPatch)
		{
			return ((PlayerPatch<?>) entityPatch).getSkill(slot).hasSkill(skill);
		}
		return false;
	}
}