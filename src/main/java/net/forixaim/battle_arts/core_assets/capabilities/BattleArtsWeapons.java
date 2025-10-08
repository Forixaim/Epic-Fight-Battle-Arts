package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.ex_cap.capabilities.ExCapWeapon;
import net.forixaim.ex_cap.capabilities.weapon_presets.ExCapWeapons;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BattleArtsWeapons
{

    public static final DeferredRegister<ExCapWeapon> EX_CAP_WEAPONS = DeferredRegister.create(ExCapWeapons.REGISTRY_KEY, EpicFightBattleArts.MOD_ID);


    public static RegistryObject<ExCapWeapon> BATTLE_AXE = EX_CAP_WEAPONS.register("battle_axe", () -> ExCapWeapon.quickStart(
            builder -> builder.category(BattleStyleCategories.BATTLE_AXE)
                    .collider(ColliderPreset.LONGSWORD)
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .swingSound(EpicFightSounds.WHOOSH_BIG.get()), 1, 1, 1
    ));
    public static RegistryObject<ExCapWeapon> HEAVY_SPEAR = EX_CAP_WEAPONS.register("heavy_spear", () -> ExCapWeapon.quickStart(
            builder -> builder.category(CapabilityItem.WeaponCategories.SPEAR)
                    .collider(ColliderPreset.SPEAR)
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .swingSound(EpicFightSounds.WHOOSH_ROD.get()), 1, 1, 1
    ));
}
