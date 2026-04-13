package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditional;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditionalType;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class RecruitProviders
{
    public static final ConditionalEntry RECRUIT_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("recruit_spear_check"),
            QuickFunctions.battleStyleCheck(
                    NoviceBattleStyles.RECRUIT,
                    RecruitWieldStyles.RECRUIT_SPEAR,
                    false
            )
    );

    public static final ConditionalEntry RECRUIT_SHIELD = new ConditionalEntry(
            BattleArts.identifier("recruit_spear_shield"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            RECRUIT_DEFAULT.builder(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.SHIELD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );
}