package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.BattleArtsItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class LiuGuandaoItem extends BattleArtsItem
{
    public LiuGuandaoItem() {
        super(SpecialTiers.LIU_ITEMS, new Properties().fireResistant().durability(0).attributes(createAttributes(SpecialTiers.LIU_ITEMS)));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 6, -3.1F, 0.0F);
    }

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, @NotNull Player player, Entity entity)
    {
        entity.igniteForSeconds(5);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
