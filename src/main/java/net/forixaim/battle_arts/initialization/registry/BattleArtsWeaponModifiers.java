package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import yesman.epicfight.api.ex_cap.data.modifier.WeaponModifier;
import yesman.epicfight.registry.deferred.ModifierRegister;
import yesman.epicfight.registry.deferred.holders.DeferredModifier;
import yesman.epicfight.registry.entries.EpicFightItemCapabilityPresets;

public final class BattleArtsWeaponModifiers
{
    public static final ModifierRegister REGISTRY = ModifierRegister.create(BattleArts.MOD_ID);
    public static final DeferredModifier DAGGER = REGISTRY.registerModifier("dagger", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.DAGGER).addConditionalModifier(BattleArtsConditionals.SQUIRE_DEFAULT, BattleArtsConditionals.THIEF_DEFAULT)
            .addMovesetModifier(SquireWieldStyles.SQUIRE_SWORD, BattleArtsMovesets.Squire.SQUIRE_DAGGER)
            .addMovesetModifier(ThiefStyles.THIEF_WEAPON, BattleArtsMovesets.Thief.THIEF_DAGGER));

    public static final DeferredModifier SWORD_SHARED = REGISTRY.registerModifier("sword", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.SWORD, EpicFightItemCapabilityPresets.LONGSWORD, EpicFightItemCapabilityPresets.TACHI)
            .addConditionalModifier(BattleArtsConditionals.DUELIST_DEFAULT, BattleArtsConditionals.DUELIST_SWORDS, BattleArtsConditionals.DUELIST_LONGSWORDS,
                    BattleArtsConditionals.DUELIST_TACHIS, BattleArtsConditionals.SQUIRE_DEFAULT)
            .addMovesetModifier(SquireWieldStyles.SQUIRE_SWORD, BattleArtsMovesets.Squire.SQUIRE_SWORD)
            .addMovesetModifier(DuelistStyles.DUELIST_SWORD, BattleArtsMovesets.Duelist.DUELIST_SWORD)
            .addMovesetModifier(DuelistStyles.DUELIST_DUAL_SWORD, BattleArtsMovesets.Duelist.DUELIST_DUALBLADES));

    public static final DeferredModifier TACHI = REGISTRY.registerModifier("tachi", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.TACHI)
            .addConditionalModifier(BattleArtsConditionals.RONIN_DEFAULT)
            .addMovesetModifier(RoninStyles.TRANQUIL_STATE, BattleArtsMovesets.Ronin.RONIN_TACHI));

    public static final DeferredModifier UCHIGATANA = REGISTRY.registerModifier("uchigatana", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.UCHIGATANA)
            .addConditionalModifier(BattleArtsConditionals.RONIN_DEFAULT, BattleArtsConditionals.RONIN_SHEATH)
            .addMovesetModifier(RoninStyles.TRANQUIL_STATE, BattleArtsMovesets.Ronin.RONIN_UCHIGATANA)
            .addMovesetModifier(RoninStyles.SCATTER_STATE, BattleArtsMovesets.Ronin.RONIN_UCHIGATANA_SHEATHED));

    public static final DeferredModifier GREATSWORD = REGISTRY.registerModifier("greatsword", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.GREATSWORD)
            .addConditionalModifier(BattleArtsConditionals.SQUIRE_DEFAULT, BattleArtsConditionals.MERCENARY_DEFAULT)
            .addMovesetModifier(SquireWieldStyles.SQUIRE_SWORD, BattleArtsMovesets.Squire.SQUIRE_SWORD)
            .addMovesetModifier(MercenaryStyles.MERCENARY_WEAPON_ART, BattleArtsMovesets.Mercenary.MERCENARY_GREATSWORD));

    public static final DeferredModifier BOW = REGISTRY.registerModifier("bow", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.BOW)
            .addConditionalModifier(BattleArtsConditionals.SQUIRE_DEFAULT)
            .addMovesetModifier(SquireWieldStyles.SQUIRE_SWORD, BattleArtsMovesets.Squire.SQUIRE_BOW));

    public static final DeferredModifier SPEAR = REGISTRY.registerModifier("spear", () -> WeaponModifier.builder()
            .target(EpicFightItemCapabilityPresets.SPEAR)
            .addConditionalModifier(BattleArtsConditionals.RECRUIT_DEFAULT, BattleArtsConditionals.RECRUIT_SHIELD, BattleArtsConditionals.LANCER_DEFAULT)
            .addMovesetModifier(RecruitWieldStyles.RECRUIT_SPEAR, BattleArtsMovesets.Recruit.RECRUIT_MOVESET)
            .addMovesetModifier(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, BattleArtsMovesets.Recruit.RECRUIT_MOVESET_SHIELDED)
            .addMovesetModifier(LancerStyles.LANCER_WEAPON_ART, BattleArtsMovesets.Lancer.LANCER_SPEAR));

    public static final DeferredModifier AXE = REGISTRY.registerModifier("axe", () -> WeaponModifier.builder()
            .addConditionalModifier(BattleArtsConditionals.JOURNEYMAN_DEFAULT, BattleArtsConditionals.FIGHTER_DEFAULT)
            .addMovesetModifier(JourmeymanStyles.JOURNEYMAN_PRIMARY, BattleArtsMovesets.Journeyman.JOURNEYMAN_AXE));
}
