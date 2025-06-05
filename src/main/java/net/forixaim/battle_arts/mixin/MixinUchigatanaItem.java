package net.forixaim.battle_arts.mixin;

import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.item.UchigatanaItem;

@Mixin(UchigatanaItem.class)
public class MixinUchigatanaItem
{
    @Inject(method = "<init>", at = @At("RETURN"), remap = false)
    public void injectCon(Item.Properties build, CallbackInfo ci)
    {
    }
}
