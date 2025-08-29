package net.forixaim.battle_arts.core_assets.capabilities;

import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.ex_cap.api.MaterialPropertyManager;
import net.forixaim.ex_cap.api.Registries;
import net.forixaim.ex_cap.api.material.MaterialProperties;
import net.forixaim.ex_cap.capabilities.weapon_presets.ExCapWeapons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry
{
    public static final Function<Item, CapabilityItem.Builder> BATTLE_AXE = item -> {
        try
        {
            return BattleArtsWeapons.BATTLE_AXE.export();
        }
        catch (final NoSuchMethodError e)
        {
            LogUtils.getLogger().warn(e.getMessage());
            return BattleArtsWeapons.BATTLE_AXE.export(true);
        }
    };

    public static final Function<Item, CapabilityItem.Builder> HEAVY_SPEAR = item -> {
        CapabilityItem.Builder builder0;

        try
        {
            builder0 = BattleArtsWeapons.HEAVY_SPEAR.export();
        }
        catch (NoSuchMethodError e)
        {
            LogUtils.getLogger().warn(e.getMessage());
            builder0 = BattleArtsWeapons.HEAVY_SPEAR.export(true);
        }

        Map<Attribute, ValueModifier> attributeModifier = BattleArtsWeapons.HEAVY_SPEAR.getAttModifiers();


        if (item instanceof TieredItem tieredItem && builder0 instanceof WeaponCapability.Builder builder) {
            if (MaterialPropertyManager.getProperties().containsKey(tieredItem.getTier()))
            {
                MaterialProperties properties = MaterialPropertyManager.getProperties().get(tieredItem.getTier());
                attributeModifier.forEach((attribute, modifier) -> {
                    double finalValue = ValueModifier.calculator().attach(modifier).getResult(properties.attributeModifier().get(attribute).floatValue());
                    builder.addStyleAttibutes(CapabilityItem.Styles.COMMON, Pair.of(attribute, new AttributeModifier("ex_cap_attribute", finalValue, AttributeModifier.Operation.ADDITION)));
                });
            }
            else
            {
                MaterialProperties properties = Registries.quickRegister(1, 1, 1);
                attributeModifier.forEach((attribute, modifier) -> {
                    double finalValue = ValueModifier.calculator().attach(modifier).getResult(properties.attributeModifier().get(attribute).floatValue());
                    builder.addStyleAttibutes(CapabilityItem.Styles.COMMON, Pair.of(attribute, new AttributeModifier("ex_cap_attribute", finalValue, AttributeModifier.Operation.ADDITION)));
                });
            }
            builder.hitSound(tieredItem.getTier() == Tiers.WOOD ? EpicFightSounds.BLUNT_HIT.get() : EpicFightSounds.BLADE_HIT.get());
            builder.hitParticle(tieredItem.getTier() == Tiers.WOOD ? EpicFightParticles.HIT_BLUNT.get() : EpicFightParticles.HIT_BLADE.get());
        }

        return builder0;
    };

    private static ResourceLocation name(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    @SubscribeEvent
    public static void Register(WeaponCapabilityPresetRegistryEvent Event)
    {
        Event.getTypeEntry().put(name("battle_axe"), BATTLE_AXE);
        Event.getTypeEntry().put(name("heavy_spear"), HEAVY_SPEAR);

    }
}
