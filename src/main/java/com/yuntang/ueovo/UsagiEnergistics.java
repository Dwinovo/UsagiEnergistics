package com.yuntang.ueovo;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import com.yuntang.ueovo.client.model.entity.UEModel;
import com.yuntang.ueovo.client.render.UERender;
import com.yuntang.ueovo.init.InitEntity;
import com.yuntang.ueovo.resource.UEModelMannager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(UsagiEnergistics.MODID)
public class UsagiEnergistics
{
    public static final String MODID = "ueovo";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UsagiEnergistics(IEventBus modEventBus, ModContainer modContainer)
    {
        initRegister(modEventBus);
        modEventBus.addListener(this::commonSetup);
        
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        UEModelMannager.initResource();
        LOGGER.info("HELLO FROM COMMON SETUP");

    }
    private static void initRegister(IEventBus eventBus) {
        InitEntity.ENTITY_TYPES.register(eventBus);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            
        }
        @SubscribeEvent
        public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers evt) {
            EntityRenderers.register(InitEntity.UEOVO.get(), UERender::new);
        }
    }
    
}
