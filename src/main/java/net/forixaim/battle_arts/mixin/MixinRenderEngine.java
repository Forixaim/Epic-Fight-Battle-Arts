package net.forixaim.battle_arts.mixin;

import com.google.gson.JsonElement;
import net.forixaim.battle_arts.core_assets.client.renderer.patched.GloveRenderer;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.AdaptiveGloveItem;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.BattleBowItem;
import net.forixaim.battle_arts.initialization.registry.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.client.events.engine.RenderEngine;
import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
import yesman.epicfight.client.renderer.patched.item.RenderTwoHandedRangedWeapon;

import java.util.Map;

@Mixin(RenderEngine.class)
public abstract class MixinRenderEngine
{
    @Shadow(remap = false) @Final private Map<Item, RenderItemBase> itemRendererMapByInstance;

    @Shadow(remap = false) @Final private Map<Class<?>, RenderItemBase> itemRendererMapByClass;

    @Inject(method = "reloadItemRenderers", at = @At("RETURN"), remap = false)
    private void reloadItemRenderers(Map<ResourceLocation, JsonElement> objects, CallbackInfo ci)
    {
        RenderTwoHandedRangedWeapon battleBowRenderer = new RenderTwoHandedRangedWeapon(objects.get(ForgeRegistries.ITEMS.getKey(Items.BOW)).getAsJsonObject());
        itemRendererMapByClass.put(BattleBowItem.class, battleBowRenderer);
    }
}
