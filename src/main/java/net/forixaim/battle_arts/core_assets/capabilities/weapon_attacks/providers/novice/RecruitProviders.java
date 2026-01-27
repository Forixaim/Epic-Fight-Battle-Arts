package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.ex_cap.api.providers.ProviderConditional;
import net.forixaim.ex_cap.api.providers.ProviderConditionalType;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class RecruitProviders
{
    public static final ProviderConditional RECRUIT_SPEAR_CHECK = QuickFunctions.battleStyleCheck(
            NoviceBattleStyles.RECRUIT,
            RecruitWieldStyles.RECRUIT_SPEAR,
            false
    );

    public static final ProviderConditional RECRUIT_SPEAR_SHIELD = ProviderConditional.builder()
            .setType(ProviderConditionalType.COMPOSITE)
            .setWieldStyle(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
            .isVisibleOffHand(true)
            .setProviderConditionals(RECRUIT_SPEAR_CHECK, ProviderConditional.builder()
                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                    .setCategory(CapabilityItem.WeaponCategories.SHIELD)
                    .setHand(InteractionHand.OFF_HAND)
                    .build())
            .build();
}
