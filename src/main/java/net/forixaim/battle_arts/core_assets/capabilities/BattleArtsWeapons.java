package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.BattleArts;

import yesman.epicfight.api.ex_cap.modules.core.data.BuilderEntry;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class BattleArtsWeapons
{
    public static BuilderEntry BATTLE_AXE = new BuilderEntry(BattleArts.identifier("battle_axe"),
            WeaponCapability.builder().category(BattleStyleCategories.BATTLE_AXE)
                    .collider(ColliderPreset.LONGSWORD)
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .swingSound(EpicFightSounds.WHOOSH_BIG.get()));

    public static BuilderEntry HEAVY_SPEAR = new BuilderEntry(BattleArts.identifier("heavy_spear"),
            WeaponCapability.builder().category(CapabilityItem.WeaponCategories.SPEAR)
                    .collider(ColliderPreset.SPEAR)
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .swingSound(EpicFightSounds.WHOOSH_ROD.get()));

    public static BuilderEntry SHORT_SPEAR = new BuilderEntry(BattleArts.identifier("short_spear"),
            WeaponCapability.builder().category(CapabilityItem.WeaponCategories.SPEAR)
                    .collider(ColliderPreset.SPEAR)
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .swingSound(EpicFightSounds.WHOOSH_ROD.get()));
}
