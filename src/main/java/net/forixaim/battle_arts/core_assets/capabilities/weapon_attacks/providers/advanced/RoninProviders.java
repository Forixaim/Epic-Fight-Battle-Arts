package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.bs_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.efm_ex.api.providers.ProviderConditional;
import net.forixaim.efm_ex.api.providers.ProviderConditionalType;

public class RoninProviders
{
    public static ProviderConditional RONIN_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.RONIN,
            RoninStyles.RONIN_UCHIGATANA,
            false
    );

    public static ProviderConditional RONIN_STYLE_CHECK_SHEATH = ProviderConditional.builder()
            .setType(ProviderConditionalType.DATA_KEY)
            .setWieldStyle(RoninStyles.RONIN_UCHIGATANA_SHEATHE)
            .isVisibleOffHand(false)
            .setSlot(BattleArtsSkillSlots.BATTLE_STYLE)
            .setKey(BattleArtsDataKeys.BATTO_SHEATH.get())
            .build();

}
