package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

import javax.annotation.Nullable;
import java.util.List;

public class VikingAxeItem extends BattleArtsItem
{
	public VikingAxeItem(Tier tier, Properties builder)
	{
		super(tier, builder.durability(Math.round(tier.getUses() * 1.2f)).attributes(createAttributes(tier)));
	}

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 3, -3F, 0.0F);
    }

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
		tooltip.add(Component.literal(""));
		tooltip.add(Component.translatable("item.battle_arts.viking_axe.tooltip"));
	}
}
