
package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BindingBladeItem extends FalchionItem
{
    public BindingBladeItem() {
        super(8, -2.6f, new Properties());
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.setSecondsOnFire(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
