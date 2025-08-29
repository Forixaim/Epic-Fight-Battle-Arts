package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.LancerStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.ex_cap.api.providers.ProviderConditional;

public class LancerProviders
{
    public static final ProviderConditional LANCER_DEFAULT = QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.LANCER,
            LancerStyles.LANCER_WEAPON_ART,
            false
    );
}
