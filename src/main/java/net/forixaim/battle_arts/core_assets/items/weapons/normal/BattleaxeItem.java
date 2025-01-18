package net.forixaim.battle_arts.core_assets.items.weapons.normal;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.WeaponItem;

import javax.annotation.Nullable;
import java.util.List;

public class BattleaxeItem extends WeaponItem
{
	public BattleaxeItem(Tier tier, Properties builder)
	{
		super(tier, 7, -3f, builder.durability((int) (tier.getUses() * 1.2)).defaultDurability((int) (tier.getUses() * 1.2)));
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
		tooltip.add(Component.literal(""));
		tooltip.add(Component.translatable("item.battle_arts.battleaxe.tooltip"));
	}
}
