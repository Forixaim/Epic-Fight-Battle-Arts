package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.MercenaryStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;

public class MercenaryProviders
{
    public static final ConditionalEntry MERCENARY_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("mercenary_default"),
            QuickFunctions.battleStyleCheck(
                    AdvancedBattleStyles.MERCENARY,
                    MercenaryStyles.MERCENARY_WEAPON_ART,
                    false
            )
    );
}