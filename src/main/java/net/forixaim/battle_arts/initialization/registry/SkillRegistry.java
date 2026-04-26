package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.*;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Journeyman;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Recruit;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Squire;
import net.forixaim.battle_arts.core_assets.skills.combat_art.Mug;
import net.forixaim.battle_arts.core_assets.skills.combat_art.PowerGeyser;
import net.forixaim.battle_arts.core_assets.skills.combat_art.SkyStriker;
import net.forixaim.battle_arts.core_assets.skills.combat_art.TranquilityUnleash;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.HeavyDraw;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.IronFortress;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Steal;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Tranquility;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.passive.PassiveSkill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class SkillRegistry
{
    public static final DeferredRegister<Skill> SKILLS = DeferredRegister.create(EpicFightRegistries.Keys.SKILL, BattleArts.MOD_ID);

    //Battle Styles
    public static final DeferredHolder<Skill, ArrogancePassive> ARROGANCE = SKILLS.register("arrogance", key -> PassiveSkill.createPassiveBuilder(ArrogancePassive::new).build(key));
    public static final DeferredHolder<Skill, Squire> SQUIRE = SKILLS.register("squire", key -> BattleStyle.createBattleStyle(Squire::new).build(key));
    public static final DeferredHolder<Skill, Recruit> RECRUIT = SKILLS.register("recruit", key -> BattleStyle.createBattleStyle(Recruit::new).build(key));
    public static final DeferredHolder<Skill, Journeyman> JOURNEYMAN = SKILLS.register("journeyman", key -> BattleStyle.createBattleStyle(Journeyman::new).build(key));
    public static final DeferredHolder<Skill, Ronin> RONIN = SKILLS.register("ronin", key -> BattleStyle.createBattleStyle(Ronin::new).build(key));
    public static final DeferredHolder<Skill, Thief> THIEF = SKILLS.register("thief", key -> BattleStyle.createBattleStyle(Thief::new).build(key));
    public static final DeferredHolder<Skill, Duelist> DUELIST = SKILLS.register("duelist", key -> BattleStyle.createBattleStyle(Duelist::new).build(key));
    public static final DeferredHolder<Skill, Mercenary> MERCENARY = SKILLS.register("mercenary", key -> BattleStyle.createBattleStyle(Mercenary::new).build(key));
    public static final DeferredHolder<Skill, Lancer> LANCER = SKILLS.register("lancer", key -> BattleStyle.createBattleStyle(Lancer::new).build(key));
    public static final DeferredHolder<Skill, Fighter> FIGHTER = SKILLS.register("fighter", key -> BattleStyle.createBattleStyle(Fighter::new).build(key));

    //Innates
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> HEAVY_BLOW = SKILLS.register("heavy_blow", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireSwordAnimations.SQUIRE_SWORD_HEAVY_BLOW).newProperty().build(key));
    public static final DeferredHolder<Skill, HeavyDraw> POWER_DRAW = SKILLS.register("power_draw", key -> WeaponInnateSkill.createWeaponInnateBuilder(HeavyDraw::new).setActivateType(Skill.ActivateType.HELD).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> HARD_THRUST = SKILLS.register("hard_thrust", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireDaggerAnimations.HARD_THRUST).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> SEISMIC_IMPACT = SKILLS.register("seismic_impact", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanBattleAxeAnims.SEISMIC_IMPACT).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> SUPPRESSING_BLOW = SKILLS.register("suppressing_blow", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanAnimations.JMAN_SUPPRESSING_BLOW).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> RECURVE_AXE = SKILLS.register("recurve_axe", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanAxeAnims.RECURVE_AXE).newProperty().build(key));
    public static final DeferredHolder<Skill, IronFortress> IRON_FORTRESS = SKILLS.register("iron_fortress", key -> WeaponInnateSkill.createWeaponInnateBuilder(IronFortress::new).build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> DASHING_IMPALE = SKILLS.register("dashing_impale", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(LancerSpearAnimations.DASHING_IMPALE).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> FIERCE_UPPER = SKILLS.register("fierce_upper", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(MercenaryGreatswordAnimations.FIERCE_UPPER).newProperty().build(key));
    public static final DeferredHolder<Skill, PowerGeyser> POWER_GEYSER = SKILLS.register("power_geyser", key -> CombatArt.createCombatArt(PowerGeyser::new).build(key));
    public static final DeferredHolder<Skill, Tranquility> TRANQUILITY = SKILLS.register("tranquility", key -> WeaponInnateSkill.createWeaponInnateBuilder(Tranquility::new).newProperty().build(key));
    public static final DeferredHolder<Skill, TranquilityUnleash> TRANQUILITY_UNLEASH = SKILLS.register("tranquility_unleash", key -> CombatArt.createCombatArt(TranquilityUnleash::new).build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> BLOSSOM_SLASH = SKILLS.register("blossom_slash", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RoninTachiAnimations.BLOSSOM_SLASH).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> PUNCTURE_SWIPE = SKILLS.register("puncture_swipe", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> QUAD_STING = SKILLS.register("quad_sting", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistSwordAnimations.QUAD_STING).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> RELENTLESS_PUNCTURE = SKILLS.register("whirledge", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistDualbladesAnimations.WHIRLEDGE).newProperty().build(key));
    public static final DeferredHolder<Skill, SkyStriker> SKY_STRIKER = SKILLS.register("sky_striker", key -> CombatArt.createCombatArt(SkyStriker::new).setResource(Skill.Resource.COOLDOWN).build(key));
    public static final DeferredHolder<Skill, Steal> STEAL = SKILLS.register("steal", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder(Steal::new).setAnimations(ThiefDaggerAnimations.STEAL).newProperty().build(key));
    public static final DeferredHolder<Skill, Mug> MUG = SKILLS.register("mug", key -> CombatArt.createCombatArt(Mug::new).build(key));

}
