package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.ThiefStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.ex_cap.modules.core.data.ConditionalEntry;

public class ThiefProviders
{
    public static final ConditionalEntry THIEF_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("thief_style_check"),
            QuickFunctions.battleStyleCheck(
                    SkillRegistry.THIEF.get(),
                    ThiefStyles.THIEF_WEAPON,
                    false
            )
    );
}
