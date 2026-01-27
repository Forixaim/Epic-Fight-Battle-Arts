package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.ThiefStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.ex_cap.api.providers.ProviderConditional;

public class ThiefProviders
{
    public static ProviderConditional THIEF_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.THIEF, ThiefStyles.THIEF_WEAPON, false
    );
}
