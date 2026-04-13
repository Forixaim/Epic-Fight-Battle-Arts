package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.JourneymanStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;

public class JourneymanProviders
{
    public static ConditionalEntry JOURNEYMAN_DEFAULT = new ConditionalEntry(BattleArts.identifier(""), QuickFunctions.battleStyleCheck(
            NoviceBattleStyles.JOURNEYMAN,
            JourneymanStyles.JOURNEYMAN_WEAPON_ART,
            false
    ));
}