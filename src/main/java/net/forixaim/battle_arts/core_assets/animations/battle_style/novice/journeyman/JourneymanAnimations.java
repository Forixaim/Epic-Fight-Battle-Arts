package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman;

import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class JourneymanAnimations
{
    public static void Build()
    {
        JourneymanBattleAxeAnims.Build();
    }
    public static String jmanAnimationPath(WeaponCategory category, String entry)
    {
        return "battle_style/novice/journeyman/" + category.toString().toLowerCase() + "/" + entry;
    }
}
