package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.RoninStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.QuickFunctions;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditional;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditionalType;
import yesman.epicfight.skill.Skill;


public class RoninProviders
{
    public static ConditionalEntry RONIN_DEFAULT = new ConditionalEntry(BattleArts.identifier("ronin_style_uchigatana"), QuickFunctions.battleStyleCheck(
            AdvancedBattleStyles.RONIN,
            RoninStyles.RONIN_UCHIGATANA,
            false
    ));

    public static ConditionalEntry RONIN_TACHI = new ConditionalEntry(
            BattleArts.identifier("ronin_style_tachi"),
            QuickFunctions.battleStyleCheck(
                    AdvancedBattleStyles.RONIN,
                    RoninStyles.RONIN_TACHI,
                    false
            )
    );

    public static ConditionalEntry RONIN_SHEATH = new ConditionalEntry(
            BattleArts.identifier("ronin_style_sheath"),
            ProviderConditional.builder()
                    .setType(ProviderConditionalType.DATA_KEY)
                    .setWieldStyle(RoninStyles.RONIN_UCHIGATANA_SHEATHE)
                    .isVisibleOffHand(false)
                    .setSlot(BattleArtsSkillSlots.BATTLE_STYLE)
                    .setKey(BattleArtsDataKeys.TRANQUILITY_SHEATH.get())
    );

}