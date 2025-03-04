package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public class RoninAnimations
{
    public static String roninAnimationPath(WeaponCategory category, String entry)
    {
        return "battle_style/advanced/ronin/" + category.toString().toLowerCase() + "/" + entry;
    }


    public static void Listen(AnimationManager.AnimationBuilder builder)
    {
        RoninUchigatanaAnimations.onRegister(builder);
        RoninTachiAnimations.onRegister(builder);
    }
}
