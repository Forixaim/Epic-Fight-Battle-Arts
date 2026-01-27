package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.MercenaryStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.ex_cap.api.providers.ProviderConditional;

public class MercenaryProviders
{
    public static final ProviderConditional MERCENARY_DEFAULT = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.MERCENARY,
            MercenaryStyles.MERCENARY_WEAPON_ART,
            false
    );
}
