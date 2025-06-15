package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.DuelistStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.efm_ex.api.providers.ProviderConditional;

public class DuelistProviders
{
    public static ProviderConditional DUELIST_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.DUELIST,
            DuelistStyles.DUELIST_SWORD,
            false
    );
}
