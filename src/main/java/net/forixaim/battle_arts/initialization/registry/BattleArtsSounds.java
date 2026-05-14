package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class BattleArtsSounds
{
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BattleArts.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> JUMP = registerSound("entity.combat.jump");
    public static final DeferredHolder<SoundEvent, SoundEvent> UNSHEATHE = registerSound("entity.combat.unsheathe");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHEATHE = registerSound("entity.combat.sheathe");
    public static final DeferredHolder<SoundEvent, SoundEvent> SPIKE = registerSound("entity.combat.spike");
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECIAL_MOVE = registerSound("entity.combat.special_move");
    public static final DeferredHolder<SoundEvent, SoundEvent> HEAVY_SLASH = registerSound("entity.combat.heavy_slash");
    public static final DeferredHolder<SoundEvent, SoundEvent> CRITICAL_HIT = registerSound("entity.combat.critical_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> CRITICAL_HIT_DQ8 = registerSound("entity.combat.critical_hit_8");




    private static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name) {
        ResourceLocation res = ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, name);
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(res));
    }
}
