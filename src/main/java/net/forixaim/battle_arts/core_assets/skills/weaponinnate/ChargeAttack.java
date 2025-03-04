package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class ChargeAttack extends WeaponInnateSkill
{
	public static SkillBuilder<? extends WeaponInnateSkill> createChargeAttack()
	{
		return (new SkillBuilder<ChargeAttack>().setCategory(SkillCategories.WEAPON_INNATE).setResource(Resource.STAMINA));
	}

	public ChargeAttack(SkillBuilder<? extends WeaponInnateSkill> builder) {
		super(builder);
	}
}
