package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;

import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.NoviceBattleStyles;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.unique.Fencer;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.unique.IronLotus;
import net.forixaim.battle_arts.core_assets.skills.dodge.DraconicInstinct;
import net.forixaim.battle_arts.core_assets.skills.identity.VoiceOfDistortion;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.dodge.DodgeSkill;
import yesman.epicfight.skill.passive.PassiveSkill;

@Mod.EventBusSubscriber(modid = BattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillRegistry
{
	public static Skill ARROGANCE;
	public static Skill MOUNTED_ATTACK;
	public static Skill DRACONIC_INSTINCT;
	public static Skill VOICE_OF_DISTORTION;
	public static Skill FENCER;
	public static Skill IRON_LOTUS;

	@SubscribeEvent
	public static void BuildSkillEvent(SkillBuildEvent OnBuild)
	{
		SkillBuildEvent.ModRegistryWorker registryWorker = OnBuild.createRegistryWorker(BattleArts.MOD_ID);
		ARROGANCE = registryWorker.build("arrogance", ArrogancePassive::new, PassiveSkill.createPassiveBuilder().setResource(Skill.Resource.NONE));
		VOICE_OF_DISTORTION = registryWorker.build("voice_of_distortion", VoiceOfDistortion::new, Skill.createIdentityBuilder().setResource(Skill.Resource.NONE).setActivateType(Skill.ActivateType.DURATION_INFINITE));
		DRACONIC_INSTINCT = registryWorker.build("draconic_instinct", DraconicInstinct::new, DodgeSkill.createDodgeBuilder().setResource(Skill.Resource.NONE));
		if (ModList.get().isLoaded("refm"))
		{
			FENCER = registryWorker.build("fencer", Fencer::new, BattleStyle.createBattleStyleBuilder());
		}
		IRON_LOTUS = registryWorker.build("iron_lotus", IronLotus::new, BattleStyle.createBattleStyleBuilder());

		NoviceBattleStyles.register(registryWorker);
		AdvancedBattleStyles.register(registryWorker);
	}


}
