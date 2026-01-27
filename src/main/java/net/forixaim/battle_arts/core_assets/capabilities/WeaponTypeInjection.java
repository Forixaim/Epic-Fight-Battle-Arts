package net.forixaim.battle_arts.core_assets.capabilities;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.*;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JManMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique.FencerMoveset;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.unique.IronLotusMovesets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.providers.advanced.*;
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
			event.addProvider(ExCapWeapons.LONGSWORD.get(), UniqueProviders.FENCER_CHECK);
			event.addMoveset(ExCapWeapons.LONGSWORD.get(), FencerStyles.FENCER_WEAPON_ART, FencerMoveset.FENCER_MOVESET);
		}
		event.addProvider(BattleArtsWeapons.HEAVY_SPEAR.get(), MainConditionals.default2HWieldStyle, MainConditionals.SwordShieldLS, RecruitProviders.RECRUIT_SPEAR_CHECK, RecruitProviders.RECRUIT_SPEAR_SHIELD, LancerProviders.LANCER_DEFAULT);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), CapabilityItem.Styles.TWO_HAND, CoreMovesets.spear2HMS);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), CapabilityItem.Styles.ONE_HAND, CoreMovesets.spear1HMS);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), CapabilityItem.Styles.MOUNT, CoreMovesets.mountedSpearMS);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET);
		event.addMoveset(BattleArtsWeapons.HEAVY_SPEAR.get(), LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.lancerHeavySpear);

        event.addProvider(BattleArtsWeapons.SHORT_SPEAR.get(), MainConditionals.default2HWieldStyle, MainConditionals.SwordShieldLS, RecruitProviders.RECRUIT_SPEAR_CHECK, RecruitProviders.RECRUIT_SPEAR_SHIELD, LancerProviders.LANCER_DEFAULT);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), CapabilityItem.Styles.TWO_HAND, CoreMovesets.spear2HMS);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), CapabilityItem.Styles.ONE_HAND, CoreMovesets.spear1HMS);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), CapabilityItem.Styles.MOUNT, CoreMovesets.mountedSpearMS);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET);
        event.addMoveset(BattleArtsWeapons.SHORT_SPEAR.get(), LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.lancerSpear);

		event.addProvider(ExCapWeapons.LONGSWORD.get(), SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.SWORD.get(), SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.SWORD.get(), DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.LONGSWORD.get(), DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.TACHI.get(), DuelistProviders.DUELIST_STYLE_CHECK, DuelistProviders.DUELIST_DUAL_SWORDS, DuelistProviders.DUELIST_DUAL_LONGSWORDS, DuelistProviders.DUELIST_DUAL_TACHI, DuelistProviders.DUELIST_DUAL_UCHIGATANA);
		event.addProvider(ExCapWeapons.TACHI.get(), SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addProvider(ExCapWeapons.AXE.get(), JManProviders.JMAN_BAXE_STYLE_CHECK);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE.get(), MainConditionals.default2HWieldStyle);
		event.addProvider(BattleArtsWeapons.BATTLE_AXE.get(), JManProviders.JMAN_BAXE_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA.get(), RoninProviders.RONIN_STYLE_CHECK);
		event.addProvider(ExCapWeapons.UCHIGATANA.get(), RoninProviders.RONIN_STYLE_CHECK_SHEATH);
		event.addProvider(ExCapWeapons.DAGGER.get(), SquireProviders.SQUIRE_SWORD_STYLE_CHECK, ThiefProviders.THIEF_STYLE_CHECK);
		event.addMoveset(ExCapWeapons.DAGGER.get(), SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireDaggerMS);
		event.addMoveset(ExCapWeapons.DAGGER.get(), ThiefStyles.THIEF_WEAPON, ThiefMoveSets.ThiefDagger);
		event.addMoveset(ExCapWeapons.AXE.get(), JManStyles.JMAN_BAXE, JManMoveSets.JourneymanAxeMS);
		event.addProvider(ExCapWeapons.GLOVE.get(), JManProviders.JMAN_BAXE_STYLE_CHECK, UniqueProviders.IRON_LOTUS_CHECK);
		event.addMoveset(ExCapWeapons.GLOVE.get(), JManStyles.JMAN_BAXE, JManMoveSets.JManUnarmedMS);
		event.addMoveset(ExCapWeapons.GLOVE.get(), IronLotusStyles.IRON_LOTUS_PRIMARY, IronLotusMovesets.IRON_LOTUS_FIST);
		event.addProvider(ExCapWeapons.GREATSWORD.get(), MercenaryProviders.MERCENARY_DEFAULT);
		event.addMoveset(ExCapWeapons.GREATSWORD.get(), MercenaryStyles.MERCENARY_WEAPON_ART, MercenaryMoveSets.mercenaryGreatsword);

		event.addMoveset(ExCapWeapons.SWORD.get(), DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);
		event.addMoveset(ExCapWeapons.LONGSWORD.get(), DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);
		event.addMoveset(ExCapWeapons.TACHI.get(), DuelistStyles.DUELIST_SWORD, DuelistMoveSets.DuelistSingleSword);

		event.addMoveset(ExCapWeapons.SWORD.get(), DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);
		event.addMoveset(ExCapWeapons.LONGSWORD.get(), DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);
		event.addMoveset(ExCapWeapons.TACHI.get(), DuelistStyles.DUELIST_DUAL_SWORD, DuelistMoveSets.DuelistDualblade);

		event.addProvider(ExCapWeapons.TACHI.get(), RoninProviders.RONIN_STYLE_CHECK_TACHI);

		event.addMoveset(ExCapWeapons.LONGSWORD.get(), SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(ExCapWeapons.SWORD.get(), SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(ExCapWeapons.TACHI.get(), SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireSwordMS);
		event.addMoveset(BattleArtsWeapons.BATTLE_AXE.get(), CapabilityItem.Styles.TWO_HAND, CoreMovesets.greatsword2HMS);
		event.addMoveset(BattleArtsWeapons.BATTLE_AXE.get(), JManStyles.JMAN_BAXE, JManMoveSets.JManBaxeMS);
		event.addMoveset(ExCapWeapons.UCHIGATANA.get(), RoninStyles.RONIN_UCHIGATANA, RoninMoveSets.RoninUchigatana);
		event.addMoveset(ExCapWeapons.UCHIGATANA.get(), RoninStyles.RONIN_UCHIGATANA_SHEATHE, RoninMoveSets.RoninUchigatanaSheathed);
		event.addMoveset(ExCapWeapons.TACHI.get(), RoninStyles.RONIN_TACHI, RoninMoveSets.RoninTachi);
		event.addProvider(ExCapWeapons.SPEAR.get(), RecruitProviders.RECRUIT_SPEAR_CHECK, RecruitProviders.RECRUIT_SPEAR_SHIELD, LancerProviders.LANCER_DEFAULT);
		event.addMoveset(ExCapWeapons.SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR, RecruitMoveSets.RECRUIT_MOVESET);
		event.addMoveset(ExCapWeapons.SPEAR.get(), LancerStyles.LANCER_WEAPON_ART, LancerMoveSets.lancerSpear);
		event.addMoveset(ExCapWeapons.SPEAR.get(), RecruitWieldStyles.RECRUIT_SPEAR_SHIELD, RecruitMoveSets.RECRUIT_MOVESET_SHIELDED);
		event.addProvider(ExCapWeapons.BOW.get(), SquireProviders.SQUIRE_SWORD_STYLE_CHECK);
		event.addMoveset(ExCapWeapons.BOW.get(), SquireWieldStyles.SQUIRE_SWORD, SquireMoveSets.SquireBowMS);

	}

}
