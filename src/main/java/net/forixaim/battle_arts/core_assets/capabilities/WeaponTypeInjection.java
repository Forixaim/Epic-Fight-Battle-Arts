package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.DuelistStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.MercenaryStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.ThiefStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.JManStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.SquireWieldStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.unique.FencerStyles;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.unique.IronLotusStyles;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.DuelistMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.MercenaryMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.RoninMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.ThiefMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JManMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique.FencerMoveset;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique.IronLotusMovesets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.DuelistProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.MercenaryProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.RoninProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.ThiefProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.JManProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.RecruitProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.novice.SquireProviders;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.unique.UniqueProviders;
import net.forixaim.ex_cap.api.events.ExCapMovesetRegistryEvent;
import net.forixaim.ex_cap.capabilities.weapon_presets.CoreMovesets;
import net.forixaim.ex_cap.capabilities.weapon_presets.ExCapWeapons;
import net.forixaim.ex_cap.capabilities.weapon_presets.MainConditionals;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponTypeInjection
{

	@SubscribeEvent
	public static void inject(ExCapMovesetRegistryEvent event)
	{
		if (ModList.get().isLoaded("refm"))
		{
			event.addProvider(ExCapWeapons.LONGSWORD, UniqueProviders.FENCER_CHECK);
			event.addMoveset(ExCapWeapons.LONGSWORD, FencerStyles.FENCER_WEAPON_ART, FencerMoveset.FENCER_MOVESET);
		}
		event.addProvider(ExCapWeapons.LONGSWORD, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.SWORD, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.SWORD, DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.LONGSWORD, DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.TACHI, DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.TACHI, SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.AXE, JManProviders.JMAN_BAXE_STYLE_CHECK);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE, MainConditionals.default2HWieldStyle);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE, JManProviders.JMAN_BAXE_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA, RoninProviders.RONIN_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA, RoninProviders.RONIN_STYLE_CHECK_SHEATH);
		event.addProvider(ExCapWeapons.DAGGER, SquireProviders.SQUIRE_SWORD_STYLE_CHECK, ThiefProviders.THIEF_STYLE_CHECK);
		event.addMoveset(ExCapWeapons.DAGGER, SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireDaggerMS);
		event.addMoveset(ExCapWeapons.DAGGER, ThiefStyles.THIEF_WEAPON, ThiefMoveSets.ThiefDagger);
		event.addMoveset(ExCapWeapons.AXE, JManStyles.JMAN_BAXE, JManMoveSets.JourneymanAxeMS);
		event.addProvider(ExCapWeapons.GLOVE, JManProviders.JMAN_BAXE_STYLE_CHECK, UniqueProviders.IRON_LOTUS_CHECK);
		event.addMoveset(ExCapWeapons.GLOVE, JManStyles.JMAN_BAXE, JManMoveSets.JManUnarmedMS);
		event.addMoveset(ExCapWeapons.GLOVE, IronLotusStyles.IRON_LOTUS_PRIMARY, IronLotusMovesets.IRON_LOTUS_FIST);
		event.addProvider(ExCapWeapons.GREATSWORD, MercenaryProviders.MERCENARY_DEFAULT);
		event.addMoveset(ExCapWeapons.GREATSWORD, MercenaryStyles.MERCENARY_WEAPON_ART, MercenaryMoveSets.mercenaryGreatsword);

		event.addMoveset(ExCapWeapons.SWORD, DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);
		event.addMoveset(ExCapWeapons.LONGSWORD, DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);
		event.addMoveset(ExCapWeapons.TACHI, DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);

		event.addMoveset(ExCapWeapons.SWORD, DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);
		event.addMoveset(ExCapWeapons.LONGSWORD, DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);
		event.addMoveset(ExCapWeapons.TACHI, DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);

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
