package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.BattleArtsItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.TieredWeaponItem;

import javax.annotation.Nullable;
import java.util.List;

public class Enki extends BattleArtsItem {
    public Enki() {
        super(SpecialTiers.ENKI, new Properties().attributes(createAttributes(Tiers.NETHERITE)).rarity(Rarity.EPIC));
    }

    public static ItemAttributeModifiers createAttributes(Tier iter) {
        return TieredWeaponItem.createAttributes(iter, 8, -2.3F, 0.0F);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("item.battle_arts.enki.tooltip"));
    }
}
