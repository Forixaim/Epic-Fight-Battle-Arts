package net.forixaim.battle_arts.core_assets.skills;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.Ronin;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice.Recruit;
import net.forixaim.battle_arts.core_assets.skills.passive.ArrogancePassive;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.TranquilityPassive;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.api.utils.PacketBufferCodec;
import yesman.epicfight.skill.SkillDataKey;

public class BattleArtsDataKeys
{
    public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(new ResourceLocation("epicfight", "skill_data_keys"), EpicFightBattleArts.MOD_ID);
    public static final RegistryObject<SkillDataKey<Boolean>> BATTO_SHEATH;
    public static final RegistryObject<SkillDataKey<Float>> ARROGANCE_STACK;
    public static final RegistryObject<SkillDataKey<Boolean>> ANIM_ID;
    public static final RegistryObject<SkillDataKey<Boolean>> SNEAK_MOVE_LOCK
            = DATA_KEYS.register("sneak_move_lock", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, true, Recruit.class));

    static
    {
        ANIM_ID = DATA_KEYS.register("prev_anim", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, false, ArrogancePassive.class));
        BATTO_SHEATH = DATA_KEYS.register("batto_sheath", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, false, true, Ronin.class));
        ARROGANCE_STACK = DATA_KEYS.register("arrogance_stack", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0f, true, ArrogancePassive.class));
    }

}
