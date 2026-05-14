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

public final class BattleArtsSkills
{
    public static final DeferredRegister<Skill> REGISTRY = DeferredRegister.create(EpicFightRegistries.Keys.SKILL, BattleArts.MOD_ID);

    //Battle Styles
    public static final DeferredHolder<Skill, ArrogancePassive> ARROGANCE = REGISTRY.register("arrogance", key -> PassiveSkill.createPassiveBuilder(ArrogancePassive::new).build(key));
    public static final DeferredHolder<Skill, Squire> SQUIRE = REGISTRY.register("squire", key -> BattleStyle.createBattleStyle(Squire::new).build(key));
    public static final DeferredHolder<Skill, Recruit> RECRUIT = REGISTRY.register("recruit", key -> BattleStyle.createBattleStyle(Recruit::new).build(key));
    public static final DeferredHolder<Skill, Journeyman> JOURNEYMAN = REGISTRY.register("journeyman", key -> BattleStyle.createBattleStyle(Journeyman::new).build(key));
    public static final DeferredHolder<Skill, Ronin> RONIN = REGISTRY.register("ronin", key -> BattleStyle.createBattleStyle(Ronin::new).build(key));
    public static final DeferredHolder<Skill, Thief> THIEF = REGISTRY.register("thief", key -> BattleStyle.createBattleStyle(Thief::new).build(key));
    public static final DeferredHolder<Skill, Duelist> DUELIST = REGISTRY.register("duelist", key -> BattleStyle.createBattleStyle(Duelist::new).build(key));
    public static final DeferredHolder<Skill, Mercenary> MERCENARY = REGISTRY.register("mercenary", key -> BattleStyle.createBattleStyle(Mercenary::new).build(key));
    public static final DeferredHolder<Skill, Lancer> LANCER = REGISTRY.register("lancer", key -> BattleStyle.createBattleStyle(Lancer::new).build(key));
    public static final DeferredHolder<Skill, Fighter> FIGHTER = REGISTRY.register("fighter", key -> BattleStyle.createBattleStyle(Fighter::new).build(key));

    //Innates
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> HEAVY_BLOW = REGISTRY.register("heavy_blow", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireSwordAnimations.SQUIRE_SWORD_HEAVY_BLOW).newProperty().build(key));
    public static final DeferredHolder<Skill, HeavyDraw> POWER_DRAW = REGISTRY.register("power_draw", key -> WeaponInnateSkill.createWeaponInnateBuilder(HeavyDraw::new).setActivateType(Skill.ActivateType.HELD).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> HARD_THRUST = REGISTRY.register("hard_thrust", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(SquireDaggerAnimations.HARD_THRUST).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> SEISMIC_IMPACT = REGISTRY.register("seismic_impact", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanBattleAxeAnims.SEISMIC_IMPACT).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> SUPPRESSING_BLOW = REGISTRY.register("suppressing_blow", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanAnimations.JMAN_SUPPRESSING_BLOW).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> RECURVE_AXE = REGISTRY.register("recurve_axe", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(JourneymanAxeAnims.RECURVE_AXE).newProperty().build(key));
    public static final DeferredHolder<Skill, IronFortress> IRON_FORTRESS = REGISTRY.register("iron_fortress", key -> WeaponInnateSkill.createWeaponInnateBuilder(IronFortress::new).build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> DASHING_IMPALE = REGISTRY.register("dashing_impale", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(LancerSpearAnimations.DASHING_IMPALE).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> FIERCE_UPPER = REGISTRY.register("fierce_upper", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(MercenaryGreatswordAnimations.FIERCE_UPPER).newProperty().build(key));
    public static final DeferredHolder<Skill, PowerGeyser> POWER_GEYSER = REGISTRY.register("power_geyser", key -> CombatArt.createCombatArt(PowerGeyser::new).build(key));
    public static final DeferredHolder<Skill, Tranquility> TRANQUILITY = REGISTRY.register("tranquility", key -> WeaponInnateSkill.createWeaponInnateBuilder(Tranquility::new).newProperty().build(key));
    public static final DeferredHolder<Skill, TranquilityUnleash> TRANQUILITY_UNLEASH = REGISTRY.register("tranquility_unleash", key -> CombatArt.createCombatArt(TranquilityUnleash::new).build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> BLOSSOM_SLASH = REGISTRY.register("blossom_slash", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RoninTachiAnimations.BLOSSOM_SLASH).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> PUNCTURE_SWIPE = REGISTRY.register("puncture_swipe", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> QUAD_STING = REGISTRY.register("quad_sting", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistSwordAnimations.QUAD_STING).newProperty().build(key));
    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> RELENTLESS_PUNCTURE = REGISTRY.register("whirledge", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(DuelistDualbladesAnimations.WHIRLEDGE).newProperty().build(key));
    public static final DeferredHolder<Skill, SkyStriker> SKY_STRIKER = REGISTRY.register("sky_striker", key -> CombatArt.createCombatArt(SkyStriker::new).setResource(Skill.Resource.COOLDOWN).build(key));
    public static final DeferredHolder<Skill, Steal> STEAL = REGISTRY.register("steal", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder(Steal::new).setAnimations(ThiefDaggerAnimations.STEAL).newProperty().build(key));
    public static final DeferredHolder<Skill, Mug> MUG = REGISTRY.register("mug", key -> CombatArt.createCombatArt(Mug::new).build(key));

}
