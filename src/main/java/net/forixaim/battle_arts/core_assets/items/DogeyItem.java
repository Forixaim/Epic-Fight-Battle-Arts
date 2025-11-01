package net.forixaim.battle_arts.core_assets.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DogeyItem extends BlockItem
{
    public DogeyItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        pTooltip.add(Component.translatable("item.dogey.tooltip"));
    }
}
