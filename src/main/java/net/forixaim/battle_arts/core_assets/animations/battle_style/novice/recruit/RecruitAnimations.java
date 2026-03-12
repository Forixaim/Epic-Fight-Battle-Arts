package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class RecruitAnimations
{
	public static String recruitAnimationPath(WeaponCategory category, String entry)
	{
		return "battle_style/novice/recruit/" + category.toString().toLowerCase() + "/" + entry;
	}

	public static String recruitAnimationPath(String entry, WeaponCategory... categories)
	{
		StringBuilder hi = new StringBuilder("battle_style/novice/recruit/");

		for (WeaponCategory category : categories)
		{
			hi.append(category.toString().toLowerCase());
			hi.append("/");
		}
		hi.append(entry);
		return hi.toString();
	}

	public static void Build(AnimationManager.AnimationBuilder event)
	{
		RecruitSpearAnimations.Build(event);
	}
}
