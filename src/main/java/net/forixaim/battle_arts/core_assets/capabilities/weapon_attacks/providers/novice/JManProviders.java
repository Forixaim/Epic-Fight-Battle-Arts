package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.JManStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.efm_ex.api.providers.ProviderConditional;

public class JManProviders
{
    public static ProviderConditional JMAN_BAXE_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            NoviceBattleStyles.JOURNEYMAN,
            JManStyles.JMAN_BAXE,
            false
    );
}
