
package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;

import javax.annotation.Nullable;
import java.util.List;

public class BindingBladeItem extends FalchionItem
{
    public BindingBladeItem() {
        super(new Properties().attributes(createAttributes(Tiers.NETHERITE)));
        this.DRAGON_DAMAGE_MULTIPLIER = 1.4f;
    }


    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 8, -2.6F, 0.0F);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, @NotNull Player player, @NotNull Entity entity) {
        entity.igniteForSeconds(5);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("item.battle_arts.binding_blade.tooltip"));
    }
}
