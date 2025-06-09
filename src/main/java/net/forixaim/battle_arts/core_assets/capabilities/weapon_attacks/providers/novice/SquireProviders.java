package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice;

import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.SquireWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.efm_ex.api.providers.ProviderConditional;
import net.forixaim.efm_ex.api.providers.ProviderConditionalType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PlayerRideableJumping;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class SquireProviders
{
    public static final ProviderConditional SQUIRE_SWORD_STYLE_CHECK = QuickFunctions.battleStyleCheck(
            NoviceBattleStyles.SQUIRE,
            SquireWieldStyles.SQUIRE_SWORD,
            false
    );
}
