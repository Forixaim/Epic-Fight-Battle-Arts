package net.forixaim.battle_arts;


import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import net.forixaim.battle_arts.core_assets.client.renderer.FixedArrowRenderer;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.client.model.FlyingShockwaveModel;
import net.forixaim.battle_arts.core_assets.client.renderer.FlyingShockwaveRenderer;
import net.forixaim.battle_arts.core_assets.world.ModelLayers;
import net.forixaim.battle_arts.initialization.registry.CreativeTabRegistry;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import yesman.epicfight.api.utils.ExtendableEnum;
import yesman.epicfight.main.EpicFightExtensions;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;


import static net.forixaim.battle_arts.initialization.registry.BlockRegistry.BLOCKS;
import static net.forixaim.battle_arts.initialization.registry.CreativeTabRegistry.CREATIVE_MODE_TABS;
import static net.forixaim.battle_arts.initialization.registry.ItemRegistry.ITEMS;
import static net.forixaim.battle_arts.initialization.registry.ParticleRegistry.PARTICLES;

@Mod(BattleArts.MOD_ID)
public class BattleArts
{

	public static final String MOD_ID = "battle_arts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation identifier(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

	public static boolean efExtra()
	{
		return ModList.get().isLoaded("epicfightx") && !ModList.get().isLoaded("excapextra");
	}

	public BattleArts(FMLJavaModLoadingContext context)
	{

		IEventBus modEventBus = context.getModEventBus();
		WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, BattleStyleCategories.class);
        registerStyles();
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		PARTICLES.register(modEventBus);
		BattleArtsProjectiles.ENTITIES.register(modEventBus);
		SoundRegistry.SOUNDS.register(modEventBus);
		CREATIVE_MODE_TABS.register(modEventBus);
		BattleArtsDataKeys.DATA_KEYS.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
		context.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
		context.registerExtensionPoint(EpicFightExtensions.class, () -> new EpicFightExtensions(CreativeTabRegistry.MAIN_ITEMS));
	}

    private void registerStyles()
    {
        registerStyle(DuelistStyles.class);
        registerStyle(FencerStyles.class);
        registerStyle(IronLotusStyles.class);
        registerStyle(JourneymanStyles.class);
        registerStyle(LancerStyles.class);
        registerStyle(MercenaryStyles.class);
        registerStyle(RecruitWieldStyles.class);
        registerStyle(RoninStyles.class);
        registerStyle(SquireWieldStyles.class);
        registerStyle(ThiefStyles.class);
    }

    private void registerStyle(Class<? extends ExtendableEnum> enumClass)
    {
        Style.ENUM_MANAGER.registerEnumCls(MOD_ID, enumClass);
    }


    @SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{

	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents
	{
		@SubscribeEvent
		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
		{
			event.registerLayerDefinition(ModelLayers.FLYING_SHOCKWAVE, FlyingShockwaveModel::createBodyLayer);
		}

		@SubscribeEvent
		public static void registerRenderersEvent(EntityRenderersEvent.RegisterRenderers event)
		{
			event.registerEntityRenderer(BattleArtsProjectiles.FIXED_ARROW.get(), FixedArrowRenderer::new);
			event.registerEntityRenderer(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(), FlyingShockwaveRenderer::new);
		}
	}
}
