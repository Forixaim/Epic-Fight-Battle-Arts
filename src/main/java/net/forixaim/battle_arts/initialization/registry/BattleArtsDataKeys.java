package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.battle_arts.core_assets.skills.dodge.DraconicInstinct;
import net.forixaim.battle_arts.core_assets.skills.identity.VoiceOfDistortion;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.HeavyDraw;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.SkillDataKey;

public final class BattleArtsDataKeys
{
    public static final DeferredRegister<SkillDataKey<?>> REGISTRY = DeferredRegister.create(EpicFightRegistries.SKILL_DATA_KEY, BattleArts.MOD_ID);
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> TRANQUILITY_SHEATH;
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> ARROGANCE_STACK;

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> PULLING = REGISTRY.register("pulling", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> PULL_LEVEL = REGISTRY.register("pull_level", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> COUNTER_WINDOW = REGISTRY.register("counter_window", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, Duelist.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Integer>> INSTINCT_GAUGE = REGISTRY.register("instinct_gauge", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.INT, 0, true, DraconicInstinct.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Integer>> INSTINCT_WINDOW = REGISTRY.register("instinct_window", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.INT, 0, true, DraconicInstinct.class));

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> DISTORTED = REGISTRY.register("distorted", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, VoiceOfDistortion.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> ANIM_ID;
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> CHARGING = REGISTRY.register("charging", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, false, HeavyDraw.class));
    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Float>> CHARGE_POWER = REGISTRY.register("heavy_draw", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, HeavyDraw.class));


    static
    {
        ANIM_ID = REGISTRY.register("prev_anim", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, false, ArrogancePassive.class));
        TRANQUILITY_SHEATH = REGISTRY.register("batto_sheath", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, true, Ronin.class));
        ARROGANCE_STACK = REGISTRY.register("arrogance_stack", () -> SkillDataKey.createSkillDataKey(ByteBufCodecs.FLOAT, 0.0f, true, ArrogancePassive.class));
    }

}
