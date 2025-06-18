package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.DuelistStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.efm_ex.api.providers.ProviderConditional;
import net.forixaim.efm_ex.api.providers.ProviderConditionalType;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class DuelistProviders
{
    public static ProviderConditional DUELIST_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.DUELIST,
            DuelistStyles.DUELIST_SWORD,
            false
    );

    public static final ProviderConditional DUELIST_DUAL_LONGSWORDS = ProviderConditional.builder()
            .setType(ProviderConditionalType.COMPOSITE)
            .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
            .isVisibleOffHand(true)
            .setProviderConditionals(DUELIST_STYLE_CHECK, ProviderConditional.builder()
                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                    .setCategory(CapabilityItem.WeaponCategories.LONGSWORD)
                    .setHand(InteractionHand.OFF_HAND)
                    .build())
            .build();

    public static final ProviderConditional DUELIST_DUAL_UCHIGATANA = ProviderConditional.builder()
            .setType(ProviderConditionalType.COMPOSITE)
            .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
            .isVisibleOffHand(true)
            .setProviderConditionals(DUELIST_STYLE_CHECK, ProviderConditional.builder()
                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                    .setCategory(CapabilityItem.WeaponCategories.UCHIGATANA)
                    .setHand(InteractionHand.OFF_HAND)
                    .build())
            .build();

    public static final ProviderConditional DUELIST_DUAL_SWORDS = ProviderConditional.builder()
            .setType(ProviderConditionalType.COMPOSITE)
            .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
            .isVisibleOffHand(true)
            .setProviderConditionals(DUELIST_STYLE_CHECK, ProviderConditional.builder()
                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                    .setCategory(CapabilityItem.WeaponCategories.SWORD)
                    .setHand(InteractionHand.OFF_HAND)
                    .build())
            .build();

    public static final ProviderConditional DUELIST_DUAL_TACHI = ProviderConditional.builder()
            .setType(ProviderConditionalType.COMPOSITE)
            .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
            .isVisibleOffHand(true)
            .setProviderConditionals(DUELIST_STYLE_CHECK, ProviderConditional.builder()
                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                    .setCategory(CapabilityItem.WeaponCategories.TACHI)
                    .setHand(InteractionHand.OFF_HAND)
                    .build())
            .build();


}
