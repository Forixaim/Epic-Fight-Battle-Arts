package net.forixaim.battle_arts.core_assets.skills;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.battle_arts.core_assets.skills.dodge.DraconicInstinct;
import net.forixaim.battle_arts.core_assets.skills.identity.VoiceOfDistortion;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.HeavyDraw;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.SkillDataKey;

public class BattleArtsDataKeys
{
    public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(EpicFightRegistries.SKILL_DATA_KEY, BattleArts.MOD_ID);
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> TRANQUILITY_SHEATH;
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> ARROGANCE_STACK;

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> PULLING = DATA_KEYS.register("pulling", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> PULL_LEVEL = DATA_KEYS.register("pull_level", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> COUNTER_WINDOW = DATA_KEYS.register("counter_window", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, Duelist.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Integer>> INSTINCT_GAUGE = DATA_KEYS.register("instinct_gauge", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.INT, 0, true, DraconicInstinct.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Integer>> INSTINCT_WINDOW = DATA_KEYS.register("instinct_window", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.INT, 0, true, DraconicInstinct.class));

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> DISTORTED = DATA_KEYS.register("distorted", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, VoiceOfDistortion.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> ANIM_ID;
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> CHARGING = DATA_KEYS.register("charging", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, false, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> CHARGE_POWER = DATA_KEYS.register("heavy_draw", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, HeavyDraw.class));


    static
    {
        ANIM_ID = DATA_KEYS.register("prev_anim", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, false, ArrogancePassive.class));
        TRANQUILITY_SHEATH = DATA_KEYS.register("batto_sheath", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, Ronin.class));
        ARROGANCE_STACK = DATA_KEYS.register("arrogance_stack", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, ArrogancePassive.class));
    }

}
