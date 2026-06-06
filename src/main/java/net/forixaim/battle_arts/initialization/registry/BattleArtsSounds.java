package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.generated.LangKeys;
import net.forixaim.battle_arts.generated.SoundKeys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class BattleArtsSounds
{
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BattleArts.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> JUMP = registerSound(SoundKeys.ENTITY_COMBAT_JUMP);
    public static final DeferredHolder<SoundEvent, SoundEvent> UNSHEATHE = registerSound(SoundKeys.ENTITY_COMBAT_UNSHEATHE);
    public static final DeferredHolder<SoundEvent, SoundEvent> SHEATHE = registerSound(SoundKeys.ENTITY_COMBAT_SHEATHE);
    public static final DeferredHolder<SoundEvent, SoundEvent> SPIKE = registerSound(SoundKeys.ENTITY_COMBAT_SPIKE);
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECIAL_MOVE = registerSound(SoundKeys.ENTITY_COMBAT_SPECIAL_MOVE);
    public static final DeferredHolder<SoundEvent, SoundEvent> HEAVY_SLASH = registerSound(SoundKeys.ENTITY_COMBAT_HEAVY_SLASH);
    public static final DeferredHolder<SoundEvent, SoundEvent> CRITICAL_HIT = registerSound(SoundKeys.ENTITY_COMBAT_CRITICAL_HIT);
    public static final DeferredHolder<SoundEvent, SoundEvent> CRITICAL_HIT_DQ8 = registerSound(SoundKeys.ENTITY_COMBAT_CRITICAL_HIT_8);




    private static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name) {
        ResourceLocation res = ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, name);
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(res));
    }
}
