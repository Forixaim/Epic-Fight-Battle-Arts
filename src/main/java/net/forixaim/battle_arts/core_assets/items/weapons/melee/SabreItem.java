package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;

import javax.annotation.Nullable;
import java.util.List;

public class SabreItem extends BattleArtsItem
{
	public SabreItem(Tier tier, Properties builder)
	{
		super(tier,  builder.attributes(createAttributes(tier)));
	}

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 3, -2.7F, 0.0F);
    }

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
		tooltip.add(Component.literal(""));
		tooltip.add(Component.translatable("item.battle_arts.sabre.tooltip"));
	}

}
