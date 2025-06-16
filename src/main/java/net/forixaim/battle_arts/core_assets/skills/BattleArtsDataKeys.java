package net.forixaim.battle_arts.core_assets.skills;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.skills.base_attack.MountedBasicAttack;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Duelist;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Recruit;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.HeavyDraw;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.TranquilityPassive;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.api.utils.PacketBufferCodec;
import yesman.epicfight.skill.BasicAttack;
import yesman.epicfight.skill.SkillDataKey;
import yesman.epicfight.skill.weaponinnate.BladeRushSkill;

public class BattleArtsDataKeys
{
    public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(ResourceLocation.fromNamespaceAndPath("epicfight", "skill_data_keys"), EpicFightBattleArts.MOD_ID);
    public static final RegistryObject<SkillDataKey<Boolean>> BATTO_SHEATH;
    public static final RegistryObject<SkillDataKey<Integer>> COMBO_COUNTER = DATA_KEYS.register("combo_counter", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.INTEGER, 0, true, MountedBasicAttack.class));
    public static final RegistryObject<SkillDataKey<Float>> ARROGANCE_STACK;
    public static final RegistryObject<SkillDataKey<Boolean>> PULLING = DATA_KEYS.register("pulling", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, true, HeavyDraw.class));
    public static final RegistryObject<SkillDataKey<Float>> PULL_LEVEL = DATA_KEYS.register("pull_level", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0f, true, HeavyDraw.class));
    public static final RegistryObject<SkillDataKey<Float>> COUNTER_WINDOW = DATA_KEYS.register("counter_window", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0f, true, Duelist.class));



    public static final RegistryObject<SkillDataKey<Boolean>> ANIM_ID;
    public static final RegistryObject<SkillDataKey<Boolean>> CHARGING = DATA_KEYS.register("charging", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, false, HeavyDraw.class));
    public static final RegistryObject<SkillDataKey<Float>> CHARGE_POWER = DATA_KEYS.register("heavy_draw", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0f, true, HeavyDraw.class));
    public static final RegistryObject<SkillDataKey<Boolean>> SNEAK_MOVE_LOCK
            = DATA_KEYS.register("sneak_move_lock", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, true, Recruit.class));



    static
    {
        ANIM_ID = DATA_KEYS.register("prev_anim", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, false, ArrogancePassive.class));
        BATTO_SHEATH = DATA_KEYS.register("batto_sheath", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, true, Ronin.class));
        ARROGANCE_STACK = DATA_KEYS.register("arrogance_stack", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0f, true, ArrogancePassive.class));
    }

}
