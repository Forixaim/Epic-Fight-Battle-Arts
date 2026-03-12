package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.LongswordItem;
import yesman.epicfight.world.item.TieredWeaponItem;

public class HalberdItem extends BattleArtsItem
{
    private final float destroySpeed;
    public HalberdItem(Tier tier, Properties builder) {
        super(tier, builder.durability(Math.round(tier.getUses() * 1.3f)).attributes(createAttributes(tier)));
        this.destroySpeed = tier.getSpeed();
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 6, -3.1F, 0.0F);
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        return pState.is(BlockTags.MINEABLE_WITH_AXE) ? this.destroySpeed : 1.0F;
    }

}
