package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.FighterStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.ex_cap.modules.core.data.ConditionalEntry;

public class FighterProviders
{
    public static final ConditionalEntry FIGHTER_DEFAULT = new ConditionalEntry(
            BattleArts.identifier("fighter_default"),
            QuickFunctions.battleStyleCheck(
                    SkillRegistry.FIGHTER.get(),
                    FighterStyles.FIGHTER_WEAPON_ART,
                    false
            )
    );
}
