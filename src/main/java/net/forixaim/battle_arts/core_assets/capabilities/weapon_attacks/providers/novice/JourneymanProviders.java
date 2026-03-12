package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.JourmeymanStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.ex_cap.modules.core.data.ConditionalEntry;

public class JourneymanProviders
{
    public static ConditionalEntry JOURNEYMAN_DEFAULT = new ConditionalEntry(BattleArts.identifier(""), QuickFunctions.battleStyleCheck(
            SkillRegistry.JOURNEYMAN.get(),
            JourmeymanStyles.JMAN_BAXE,
            false
    ));
}
