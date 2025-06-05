package net.forixaim.battle_arts.core_assets.client.overrides;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class OverrideHelper
{
    public static final ResourceLocation PULLING = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pulling");
    public static final ResourceLocation PULL = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pull");


    public static void registerLongbowPropertyOverrides(LongbowItem longbow)
    {
        ItemProperties.register(longbow, PULLING, (stack, world, living, value) ->
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f);
        ItemProperties.register(longbow, PULL, (stack, world, shooter, value) ->
                shooter != null && shooter.getUseItem() == stack ? longbow.getNockProgress(stack, shooter) : 0.0f);
    }
}
