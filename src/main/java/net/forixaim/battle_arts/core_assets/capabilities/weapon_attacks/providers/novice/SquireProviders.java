package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.SquireWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.api.ex_cap.modules.core.data.ConditionalEntry;

public class SquireProviders
{
    public static final ConditionalEntry SQUIRE_DEFAULT = new ConditionalEntry(BattleArts.identifier("squire_check"), QuickFunctions.battleStyleCheck(
            SkillRegistry.SQUIRE.get(),
            SquireWieldStyles.SQUIRE_SWORD,
            false
    ));
}
