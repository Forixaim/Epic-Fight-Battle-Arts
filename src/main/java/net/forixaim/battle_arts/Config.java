package net.forixaim.battle_arts;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BattleArts.MOD_ID)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec.BooleanValue ULTRA_INSTINCT = BUILDER.comment("Whether Draconic Instinct will ").define("ultra_instinct", false);
    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean ultraInstinct;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event)
    {
        ultraInstinct = ULTRA_INSTINCT.get();
    }
}
