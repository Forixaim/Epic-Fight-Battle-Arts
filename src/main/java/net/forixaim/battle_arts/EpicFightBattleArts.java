package net.forixaim.battle_arts;


import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.forixaim.battle_arts.core_assets.client.renderer.FixedArrowRenderer;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;

import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.client.model.FlyingShockwaveModel;
import net.forixaim.battle_arts.core_assets.client.renderer.FlyingShockwaveRenderer;
import net.forixaim.battle_arts.core_assets.world.ModelLayers;
import net.forixaim.battle_arts.initialization.registry.CreativeTabRegistry;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.forixaim.efm_ex.EpicFightEXCapability;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.main.EpicFightExtensions;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;


import java.nio.file.Path;

import static net.forixaim.battle_arts.initialization.registry.BlockRegistry.BLOCKS;
import static net.forixaim.battle_arts.initialization.registry.CreativeTabRegistry.CREATIVE_MODE_TABS;
import static net.forixaim.battle_arts.initialization.registry.ItemRegistry.ITEMS;
import static net.forixaim.battle_arts.initialization.registry.ParticleRegistry.PARTICLES;

@Mod(EpicFightBattleArts.MOD_ID)
public class EpicFightBattleArts
{

	public static final String MOD_ID = "battle_arts";


	public EpicFightBattleArts(FMLJavaModLoadingContext context)
	{
		IEventBus modEventBus = context.getModEventBus();
		WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, BattleStyleCategories.class);
		Style.ENUM_MANAGER.registerEnumCls(MOD_ID, RoninStyles.class);
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		PARTICLES.register(modEventBus);
		BattleArtsProjectiles.ENTITIES.register(modEventBus);
		SoundRegistry.SOUNDS.register(modEventBus);
		CREATIVE_MODE_TABS.register(modEventBus);
		BattleArtsDataKeys.DATA_KEYS.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
		context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
		context.registerExtensionPoint(EpicFightExtensions.class, () -> new EpicFightExtensions(CreativeTabRegistry.MAIN_ITEMS.get()));
	}

	public void onPackFind(AddPackFindersEvent event)
	{
		if (event.getPackType() == PackType.CLIENT_RESOURCES) {
			Path resourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource("packs/battle_arts_emissive_trails");
			PathPackResources pack = new PathPackResources(ModList.get().getModFileById(MOD_ID).getFile().getFileName() + ":" + resourcePath, resourcePath, false);
			Pack.ResourcesSupplier resourcesSupplier = (string) -> pack;
			Pack.Info info = Pack.readPackInfo("battle_arts_emissive_trails", resourcesSupplier);

			if (info != null) {
				event.addRepositorySource((source) ->
						source.accept(Pack.create("battle_arts_emissive_trails", Component.translatable("pack.battle_arts.emissive_trails.title"), false, resourcesSupplier, info, PackType.CLIENT_RESOURCES, Pack.Position.TOP, false, PackSource.BUILT_IN)));
			}
			else
			{
				LogUtils.getLogger().error("Unable to find pack. {}", Component.translatable("pack.battle_arts.emissive_trails.title"));
			}
		}
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
		public static void onClientSetup(FMLClientSetupEvent event)
		{
			event.enqueueWork(OverrideHelper::registerUchigatanaOverrides);
		}

		@SubscribeEvent
		public static void registerRenderersEvent(EntityRenderersEvent.RegisterRenderers event)
		{
			event.registerEntityRenderer(BattleArtsProjectiles.FIXED_ARROW.get(), FixedArrowRenderer::new);
			event.registerEntityRenderer(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(), FlyingShockwaveRenderer::new);
		}
	}
}
