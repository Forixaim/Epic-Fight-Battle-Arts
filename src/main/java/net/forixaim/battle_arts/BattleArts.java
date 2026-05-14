package net.forixaim.battle_arts;


import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.animations.BattleAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import net.forixaim.battle_arts.core_assets.client.overrides.OverrideHelper;
import net.forixaim.battle_arts.core_assets.client.renderer.FixedArrowRenderer;
import net.forixaim.battle_arts.core_assets.events.CommonModBusEvent;
import net.forixaim.battle_arts.initialization.registry.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.client.model.FlyingShockwaveModel;
import net.forixaim.battle_arts.core_assets.client.renderer.FlyingShockwaveRenderer;
import net.forixaim.battle_arts.core_assets.world.ModelLayers;
import net.forixaim.battle_arts.initialization.BattleArtsInit;
import net.forixaim.battle_arts.initialization.registry.BattleArtsCreativeTabs;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.utils.ExtensibleEnum;
import yesman.epicfight.main.EpicFightExtensions;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

@Mod(BattleArts.MOD_ID)
public class BattleArts
{

	public static final String MOD_ID = "battle_arts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation identifier(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(BattleArts.MOD_ID, name);
    }

	public BattleArts(IEventBus bus, ModContainer container)
	{
		WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, BattleStyleCategories.class);
        registerStyles();
        BattleArtsInit.REGISTERS.forEach( deferredRegister -> deferredRegister.register(bus));
        bus.addListener(BattleAnimations::Listen);
        bus.addListener(this::onCommonSetup);
		NeoForge.EVENT_BUS.register(this);
		container.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
		container.registerExtensionPoint(EpicFightExtensions.class, new EpicFightExtensions(BattleArtsCreativeTabs.MAIN_ITEMS));
	}

    private void registerStyles()
    {
        registerStyle(DuelistStyles.class);
        registerStyle(FencerStyles.class);
        registerStyle(IronLotusStyles.class);
        registerStyle(JourmeymanStyles.class);
        registerStyle(LancerStyles.class);
        registerStyle(MercenaryStyles.class);
        registerStyle(RecruitWieldStyles.class);
        registerStyle(RoninStyles.class);
        registerStyle(SquireWieldStyles.class);
        registerStyle(ThiefStyles.class);
    }

    private void onCommonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(this::registerCapabilities);
    }

    private void registerCapabilities()
    {
        EpicFightEventHooks.Registry.ENTITY_PATCH.registerEvent(CommonModBusEvent::registerEntityPatch, 1);
    }

    private void registerStyle(Class<? extends ExtensibleEnum> enumClass)
    {
        Style.ENUM_MANAGER.registerEnumCls(MOD_ID, enumClass);
    }


    @SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{

	}

	@EventBusSubscriber(modid = MOD_ID)
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
            event.enqueueWork(OverrideHelper::registerUchigatanaSayaOverrides);
		}

		@SubscribeEvent
		public static void registerRenderersEvent(EntityRenderersEvent.RegisterRenderers event)
		{
			event.registerEntityRenderer(BattleArtsProjectiles.FIXED_ARROW.get(), FixedArrowRenderer::new);
			event.registerEntityRenderer(BattleArtsProjectiles.FLYING_SHOCKWAVE.get(), FlyingShockwaveRenderer::new);
		}
	}
}
