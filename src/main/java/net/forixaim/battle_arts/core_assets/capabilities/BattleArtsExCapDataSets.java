package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JourneymanMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.JourneymanProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.RecruitProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.SquireProviders;
import yesman.epicfight.api.ex_cap.modules.core.data.ExCapData;
import yesman.epicfight.api.ex_cap.modules.core.data.ExCapDataEntry;

public class BattleArtsExCapDataSets
{
    public static ExCapDataEntry UCHIGATANA = new ExCapDataEntry(
            BattleArts.identifier("uchigatana"), ExCapData.builder()
            .addConditional(RoninProviders.RONIN_DEFAULT.id(), RoninProviders.RONIN_SHEATH.id())
            .addMoveset(RoninStyles.RONIN_UCHIGATANA, RoninMoveSets.RONIN_UCHIGATANA.id())
            .addMoveset(RoninStyles.RONIN_UCHIGATANA_SHEATHE, RoninMoveSets.RONIN_UCHIGATANA_SHEATHED.id())
            
    );

    public static ExCapDataEntry LONGSWORD = new ExCapDataEntry(BattleArts.identifier("longsword"), ExCapData.builder()
            .addConditional(SquireProviders.SQUIRE_DEFAULT.id(), DuelistProviders.DUELIST_DEFAULT.id(), DuelistProviders.DUELIST_SWORDS.id(), DuelistProviders.DUELIST_TACHIS.id(), DuelistProviders.DUELIST_LONGSWORDS.id())
            .addMoveset(SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SQUIRE_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DUELIST_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DUELIST_DUALBLADES.id())
            );


    public static ExCapDataEntry TACHI = new ExCapDataEntry(BattleArts.identifier("tachi"), ExCapData.builder()
            .addConditional(RoninProviders.RONIN_TACHI.id(), SquireProviders.SQUIRE_DEFAULT.id(), DuelistProviders.DUELIST_DEFAULT.id(), DuelistProviders.DUELIST_SWORDS.id(), DuelistProviders.DUELIST_TACHIS.id(), DuelistProviders.DUELIST_LONGSWORDS.id())
            .addMoveset(RoninStyles.RONIN_TACHI, RoninMoveSets.RONIN_TACHI.id())
            .addMoveset(SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SQUIRE_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DUELIST_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DUELIST_DUALBLADES.id())
            
    );

    public static ExCapDataEntry SWORD = new ExCapDataEntry(BattleArts.identifier("sword"), ExCapData.builder()
            .addConditional(SquireProviders.SQUIRE_DEFAULT.id(), DuelistProviders.DUELIST_DEFAULT.id(), DuelistProviders.DUELIST_SWORDS.id(), DuelistProviders.DUELIST_TACHIS.id(), DuelistProviders.DUELIST_LONGSWORDS.id())
            .addMoveset(SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SQUIRE_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DUELIST_SWORD.id())
            .addMoveset(DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DUELIST_DUALBLADES.id())
            );

    public static ExCapDataEntry AXE = new ExCapDataEntry(BattleArts.identifier("axe"), ExCapData.builder()
            .addConditional(JourneymanProviders.JOURNEYMAN_DEFAULT.id())
            .addMoveset(JourmeymanStyles.JMAN_BAXE, JourneymanMoveSets.JOURNEYMAN_AXE.id())
            );

    public static ExCapDataEntry BOW = new ExCapDataEntry(BattleArts.identifier("bow"), ExCapData.builder()
            .addConditional(SquireProviders.SQUIRE_DEFAULT.id())
            .addMoveset(SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SQUIRE_BOW.id())
            );

    public static ExCapDataEntry DAGGER = new ExCapDataEntry(BattleArts.identifier("dagger"), ExCapData.builder()
            .addConditional(SquireProviders.SQUIRE_DEFAULT.id(), ThiefProviders.THIEF_DEFAULT.id())
            .addMoveset(SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SQUIRE_DAGGER.id())
            .addMoveset(ThiefStyles.THIEF_WEAPON, ThiefMoveSets.THIEF_DAGGER.id())
            );

    public static ExCapDataEntry BATTLE_AXE = new ExCapDataEntry(BattleArts.identifier("battle_axe"), ExCapData.builder()
            .addConditional(JourneymanProviders.JOURNEYMAN_DEFAULT.id())
            .addMoveset(JourmeymanStyles.JMAN_BAXE, JourneymanMoveSets.JOURNEYMAN_BATTLE_AXE.id())
            );

    public static ExCapDataEntry SPEAR = new ExCapDataEntry(BattleArts.identifier("spear"), ExCapData.builder()
            .addConditional(RecruitProviders.RECRUIT_DEFAULT.id(), RecruitProviders.RECRUIT_SHIELD.id(), LancerProviders.LANCER_DEFAULT.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED.id())
            .addMoveset(LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.LANCER_SPEAR.id())
            );

    public static ExCapDataEntry SHORT_SPEAR = new ExCapDataEntry(BattleArts.identifier("short_spear"), ExCapData.builder()
            .addConditional(RecruitProviders.RECRUIT_DEFAULT.id(), RecruitProviders.RECRUIT_SHIELD.id(), LancerProviders.LANCER_DEFAULT.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED.id())
            .addMoveset(LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.LANCER_SPEAR.id())
            );

    public static ExCapDataEntry GREATSWORD = new ExCapDataEntry(BattleArts.identifier("greatsword"), ExCapData.builder()
            .addConditional(MercenaryProviders.MERCENARY_DEFAULT.id())
            .addMoveset(MercenaryStyles.MERCENARY_WEAPON_ART, MercenaryMoveSets.MERCENARY_GREATSWORD.id())
            );

    public static ExCapDataEntry HEAVY_SPEAR = new ExCapDataEntry(BattleArts.identifier("heavy_spear"), ExCapData.builder()
            .addConditional(RecruitProviders.RECRUIT_DEFAULT.id(), RecruitProviders.RECRUIT_SHIELD.id(), LancerProviders.LANCER_DEFAULT.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET.id())
            .addMoveset(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED.id())
            .addMoveset(LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.LANCER_HEAVY_SPEAR.id())
            );

}
