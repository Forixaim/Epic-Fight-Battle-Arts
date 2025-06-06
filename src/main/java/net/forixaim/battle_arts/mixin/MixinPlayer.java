package net.forixaim.battle_arts.mixin;

import net.forixaim.battle_arts.core_assets.items.types.RangedTieredItem;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(Player.class)
public class MixinPlayer {
    @Shadow @Final private Inventory inventory;

    @Shadow @Final private Abilities abilities;

    @Inject(method = "getProjectile", at = @At("HEAD"), cancellable = true)
    private void getProjectile(ItemStack shootable, CallbackInfoReturnable<ItemStack> cir)
    {
        if (shootable.getItem() instanceof RangedTieredItem rti)
        {
            Predicate<ItemStack> predicate = rti.getSupportedHeldProjectiles();
            ItemStack itemstack = ProjectileWeaponItem.getHeldProjectile((Player)(Object)this, predicate);
            if (!itemstack.isEmpty()) {
                cir.setReturnValue(net.minecraftforge.common.ForgeHooks.getProjectile((Player)(Object)this, shootable, itemstack));
            } else {
                predicate = rti.getAllSupportedProjectiles();

                for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
                    ItemStack itemstack1 = this.inventory.getItem(i);
                    if (predicate.test(itemstack1)) {
                        cir.setReturnValue(net.minecraftforge.common.ForgeHooks.getProjectile((Player)(Object)this, shootable, itemstack1));
                    }
                }
                cir.setReturnValue(net.minecraftforge.common.ForgeHooks.getProjectile((Player)(Object)this, shootable, this.abilities.instabuild ? new ItemStack(Items.ARROW) : ItemStack.EMPTY));
            }
        }
    }
}
