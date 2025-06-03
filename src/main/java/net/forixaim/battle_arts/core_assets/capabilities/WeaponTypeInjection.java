package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.JManStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.SquireWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.RoninMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JManMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.RoninProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.JManProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.RecruitProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.SquireProviders;
import net.forixaim.efm_ex.api.events.ExCapMovesetRegistryEvent;
import net.forixaim.efm_ex.capabilities.weapon_presets.CoreMovesets;
import net.forixaim.efm_ex.capabilities.weapon_presets.ExCapWeapons;
import net.forixaim.efm_ex.capabilities.weapon_presets.MainConditionals;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponTypeInjection
{

	@SubscribeEvent
	public static void inject(ExCapMovesetRegistryEvent event)
	{
		event.addProvider(ExCapWeapons.LONGSWORD, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.SWORD, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.TACHI, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE, MainConditionals.default2HWieldStyle);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE, JManProviders.JMAN_BAXE_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA, RoninProviders.RONIN_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA, RoninProviders.RONIN_STYLE_CHECK_SHEATH);
		event.addProvider(ExCapWeapons.DAGGER, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addMoveset(ExCapWeapons.DAGGER, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireDaggerMS);

		event.addProvider(ExCapWeapons.TACHI, RoninProviders.RONIN_STYLE_CHECK_TACHI);

		event.addMoveset(ExCapWeapons.LONGSWORD, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(ExCapWeapons.SWORD, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(ExCapWeapons.TACHI, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(BattleArtsWeapons.BATTLE_AXE, CapabilityItem.Styles.TWO_HAND, CoreMovesets.greatsword2HMS);
		event.addMoveset(BattleArtsWeapons.BATTLE_AXE, JManStyles.JMAN_BAXE, JManMoveSets.JManBaxeMS);
		event.addMoveset(ExCapWeapons.UCHIGATANA, RoninStyles.RONIN_UCHIGATANA, RoninMoveSets.RoninUchigatana);
		event.addMoveset(ExCapWeapons.UCHIGATANA, RoninStyles.RONIN_UCHIGATANA_SHEATHE, RoninMoveSets.RoninUchigatanaSheathed);
		event.addMoveset(ExCapWeapons.TACHI, RoninStyles.RONIN_TACHI, RoninMoveSets.RoninTachi);
		event.addProvider(ExCapWeapons.SPEAR, RecruitProviders.RECRUIT_SPEAR_CHECK, RecruitProviders.RECRUIT_SPEAR_SHIELD);
		event.addMoveset(ExCapWeapons.SPEAR, RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET);
		event.addMoveset(ExCapWeapons.SPEAR, RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED);
		event.addProvider(ExCapWeapons.BOW, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addMoveset(ExCapWeapons.BOW, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireBowMS);
	}

}
