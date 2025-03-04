package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EpicFightBattleArts.MOD_ID);

    public static final RegistryObject<SoundEvent> JUMP = registerSound("entity.combat.jump");
    public static final RegistryObject<SoundEvent> UNSHEATHE = registerSound("entity.combat.unsheathe");
    public static final RegistryObject<SoundEvent> SHEATHE = registerSound("entity.combat.sheathe");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        ResourceLocation res = new ResourceLocation(EpicFightBattleArts.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(res));
    }
}
