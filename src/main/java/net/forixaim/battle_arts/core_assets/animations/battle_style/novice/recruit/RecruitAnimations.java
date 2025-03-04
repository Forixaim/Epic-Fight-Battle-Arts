package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class RecruitAnimations
{
	public static String recruitAnimationPath(WeaponCategory category, String entry)
	{
		return "battle_style/novice/recruit/" + category.toString().toLowerCase() + "/" + entry;
	}

	public static void Build(AnimationManager.AnimationBuilder event)
	{
		RecruitSpearAnimations.Build(event);
	}
}
