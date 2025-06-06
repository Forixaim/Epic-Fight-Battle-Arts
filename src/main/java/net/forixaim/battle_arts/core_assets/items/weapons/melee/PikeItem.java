package net.forixaim.battle_arts.core_assets.items.weapons.melee;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

import java.util.UUID;

public class PikeItem extends WeaponItem {
    public PikeItem(Tier tier, Properties builder) {
        super(tier, 3, -3.0f, builder.durability((int) (tier.getUses() * 1.1)).defaultDurability((int) (tier.getUses() * 1.1)));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
    {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("62865914-3b42-49ee-8a58-4867a2bdd2e1"), "Shield modifier", -0.005, AttributeModifier.Operation.ADDITION));
            builder.putAll(super.getAttributeModifiers(slot, stack));
            return builder.build();

        }
        else if (slot == EquipmentSlot.OFFHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("62865914-3b42-49ee-8a58-4867a2bdd2e1"), "Shield modifier", -0.005, AttributeModifier.Operation.ADDITION));
            builder.putAll(super.getAttributeModifiers(slot, stack));
            return builder.build();
        }
        else {
            return super.getAttributeModifiers(slot, stack);
        }
    }
}
