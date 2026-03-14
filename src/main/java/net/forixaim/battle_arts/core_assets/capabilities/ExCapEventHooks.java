package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JourneymanMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.JourneymanProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.RecruitProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.SquireProviders;
import yesman.epicfight.api.ex_cap.modules.assets.Builders;
import yesman.epicfight.api.ex_cap.modules.assets.ExCapDataSets;
import yesman.epicfight.api.ex_cap.modules.core.events.*;

public class ExCapEventHooks
{
    public static void onRegisterWeaponBuilder(ExCapBuilderCreationEvent event)
    {
        event.addBuilder(
                BattleArtsWeapons.BATTLE_AXE, BattleArtsWeapons.HEAVY_SPEAR, BattleArtsWeapons.SHORT_SPEAR
        );
    }

    public static void onRegisterDataSet(ExCapDataRegistrationEvent event)
    {
        event.addData(
                BattleArtsExCapDataSets.AXE, BattleArtsExCapDataSets.HEAVY_SPEAR, BattleArtsExCapDataSets.SHORT_SPEAR,
                BattleArtsExCapDataSets.DAGGER, BattleArtsExCapDataSets.SWORD, BattleArtsExCapDataSets.GREATSWORD,
                BattleArtsExCapDataSets.LONGSWORD, BattleArtsExCapDataSets.BOW, BattleArtsExCapDataSets.BATTLE_AXE,
                BattleArtsExCapDataSets.SPEAR, BattleArtsExCapDataSets.TACHI, BattleArtsExCapDataSets.UCHIGATANA
        );
    }

    public static void onRegisterProvider(ConditionalRegistryEvent event)
    {
        event.addConditional(
                FighterProviders.FIGHTER_DEFAULT,
                JourneymanProviders.JOURNEYMAN_DEFAULT,
                SquireProviders.SQUIRE_DEFAULT,
                RecruitProviders.RECRUIT_DEFAULT,
                RecruitProviders.RECRUIT_SHIELD,
                DuelistProviders.DUELIST_DEFAULT,
                DuelistProviders.DUELIST_LONGSWORDS,
                DuelistProviders.DUELIST_SWORDS,
                DuelistProviders.DUELIST_TACHIS,
                DuelistProviders.DUELIST_UCHIGATANAS,
                RoninProviders.RONIN_DEFAULT,
                RoninProviders.RONIN_SHEATH,
                RoninProviders.RONIN_TACHI,
                LancerProviders.LANCER_DEFAULT,
                MercenaryProviders.MERCENARY_DEFAULT,
                ThiefProviders.THIEF_DEFAULT
        );
    }

    public static void onRegisterMoveset(ExCapMovesetRegistryEvent event)
    {
        event.addMoveSet(
                SquireMoveSets.SQUIRE_BOW, SquireMoveSets.SQUIRE_DAGGER, SquireMoveSets.SQUIRE_SWORD,
                RecruitMoveSets.RECRUIT_MOVESET, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED,
                JourneymanMoveSets.JOURNEYMAN_AXE, JourneymanMoveSets.JOURNEYMAN_BATTLE_AXE, JourneymanMoveSets.JOURNEYMAN_UNARMED,
                RoninMoveSets.RONIN_TACHI, RoninMoveSets.RONIN_UCHIGATANA, RoninMoveSets.RONIN_UCHIGATANA_SHEATHED,
                DuelistMoveSets.DUELIST_DUALBLADES, DuelistMoveSets.DUELIST_SWORD,
                LancerMoveSets.LANCER_HEAVY_SPEAR, LancerMoveSets.LANCER_SPEAR,
                ThiefMoveSets.THIEF_DAGGER,
                MercenaryMoveSets.MERCENARY_GREATSWORD,
                FighterMovesets.FIGHTER_BATTLE_AXE
        );
    }

    public static void onPopulateData(ExCapabilityBuilderPopulationEvent event)
    {
        event.registerData(Builders.BOW.id(), BattleArtsExCapDataSets.BOW.id());
        event.registerData(Builders.SWORD.id(), BattleArtsExCapDataSets.SWORD.id());
        event.registerData(Builders.DAGGER.id(), BattleArtsExCapDataSets.DAGGER.id());
        event.registerData(Builders.LONGSWORD.id(), BattleArtsExCapDataSets.LONGSWORD.id());
        event.registerData(Builders.GREATSWORD.id(), BattleArtsExCapDataSets.GREATSWORD.id());
        event.registerData(Builders.TACHI.id(), BattleArtsExCapDataSets.TACHI.id());
        event.registerData(Builders.UCHIGATANA.id(), BattleArtsExCapDataSets.UCHIGATANA.id());
        event.registerData(Builders.SPEAR.id(), BattleArtsExCapDataSets.SPEAR.id());
        event.registerData(Builders.AXE.id(), BattleArtsExCapDataSets.AXE.id());
        event.registerData(BattleArtsWeapons.BATTLE_AXE.id(), ExCapDataSets.GREATSWORD.id(), BattleArtsExCapDataSets.BATTLE_AXE.id());
        event.registerData(BattleArtsWeapons.HEAVY_SPEAR.id(), ExCapDataSets.SPEAR.id(), BattleArtsExCapDataSets.HEAVY_SPEAR.id());
        event.registerData(BattleArtsWeapons.SHORT_SPEAR.id(),ExCapDataSets.SPEAR.id(),  BattleArtsExCapDataSets.SHORT_SPEAR.id());
    }

}
