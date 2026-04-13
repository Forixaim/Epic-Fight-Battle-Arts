package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.LancerStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;

public class LancerProviders
{
    public static final ConditionalEntry LANCER_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("lancer_default"),
            QuickFunctions.battleStyleCheck(
                    AdvancedBattleStyles.LANCER,
                    LancerStyles.LANCER_WEAPON_ART,
                    false
            )
    );
}
