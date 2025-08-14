package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.unique;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.unique.FencerStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.unique.IronLotusStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.ex_cap.api.providers.ProviderConditional;

public class UniqueProviders
{
    public static final ProviderConditional FENCER_CHECK
            = QuickFunctions.battleStyleCheck(
            SkillRegistry.FENCER, FencerStyles.FENCER_WEAPON_ART, false
    );

    public static final ProviderConditional IRON_LOTUS_CHECK
            = QuickFunctions.battleStyleCheck(
            SkillRegistry.IRON_LOTUS, IronLotusStyles.IRON_LOTUS_PRIMARY, false
    );
}
