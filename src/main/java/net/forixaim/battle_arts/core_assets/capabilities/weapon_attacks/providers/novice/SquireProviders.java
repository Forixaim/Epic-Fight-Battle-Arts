package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.SquireWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.ex_cap.api.providers.ProviderConditional;

public class SquireProviders
{
    public static final ProviderConditional SQUIRE_SWORD_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            NoviceBattleStyles.SQUIRE,
            SquireWieldStyles.SQUIRE_SWORD,
            false
    );
}
