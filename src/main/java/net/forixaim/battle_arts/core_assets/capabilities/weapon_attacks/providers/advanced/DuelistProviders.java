package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.DuelistStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;

import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.ex_cap.modules.core.data.ConditionalEntry;
import yesman.epicfight.api.ex_cap.modules.core.provider.ProviderConditional;
import yesman.epicfight.api.ex_cap.modules.core.provider.ProviderConditionalType;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class DuelistProviders
{
    public static final ConditionalEntry DUELIST_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("duelist_style_check"),
            QuickFunctions.battleStyleCheck(
                    SkillRegistry.DUELIST.get(),
                    DuelistStyles.DUELIST_SWORD,
                    false
            )
    );

    public static final ConditionalEntry DUELIST_LONGSWORDS = new ConditionalEntry(
            BattleArts.identifier("duelist_dual_longswords"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.builder(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.LONGSWORD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final ConditionalEntry DUELIST_UCHIGATANAS = new ConditionalEntry(
            BattleArts.identifier("duelist_dual_uchigatana"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.builder(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.UCHIGATANA)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final ConditionalEntry DUELIST_SWORDS = new ConditionalEntry(
            BattleArts.identifier("duelist_dual_swords"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.builder(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.SWORD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final ConditionalEntry DUELIST_TACHIS = new ConditionalEntry(
            BattleArts.identifier("duelist_dual_tachi"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.builder(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.TACHI)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );


}
