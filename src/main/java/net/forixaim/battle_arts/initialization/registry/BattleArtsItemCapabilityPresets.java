package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.FighterStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.JourmeymanStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.LancerStyles;
import yesman.epicfight.registry.deferred.ItemPresetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredWeapon;
import yesman.epicfight.registry.entries.*;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public final class BattleArtsItemCapabilityPresets
{
    public static final ItemPresetRegister REGISTRY = ItemPresetRegister.create(BattleArts.MOD_ID);

    public static final DeferredWeapon BATTLE_AXE = REGISTRY.registerWeapon("battle_axe", () -> WeaponCapability.builder()
            .hitSound(EpicFightSounds.BLADE_HIT)
            .swingSound(EpicFightSounds.WHOOSH_BIG)
            .hitParticle(EpicFightParticles.HIT_BLADE)
            .category(BattleStyleCategories.BATTLE_AXE)
            .addConditionals(EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE, BattleArtsConditionals.JOURNEYMAN_DEFAULT, BattleArtsConditionals.FIGHTER_DEFAULT)
            .addMoveset(CapabilityItem.Styles.TWO_HAND, EpicFightMovesets.GREATSWORD_2H)
            .addMoveset(JourmeymanStyles.JOURNEYMAN_PRIMARY, BattleArtsMovesets.Journeyman.JOURNEYMAN_BATTLE_AXE)
            .addMoveset(FighterStyles.FIGHTER_WEAPON_ART, BattleArtsMovesets.Fighter.FIGHTER_BATTLE_AXE));

    public static final DeferredWeapon RAPIER = REGISTRY.registerWeapon("rapier", () -> )

    public static final DeferredWeapon HEAVY_SPEAR = REGISTRY.registerWeapon("heavy_spear", () -> WeaponCapability.builder()
            .parent(EpicFightItemCapabilityPresets.SPEAR)
            .addMoveset(LancerStyles.LANCER_WEAPON_ART, BattleArtsMovesets.Lancer.LANCER_HEAVY_SPEAR));

    public static final DeferredWeapon SHORT_SPEAR = REGISTRY.registerWeapon("short_spear", () -> WeaponCapability.builder()
            .parent(EpicFightItemCapabilityPresets.SPEAR));
}
