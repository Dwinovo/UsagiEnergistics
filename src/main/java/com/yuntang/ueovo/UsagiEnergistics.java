package com.yuntang.ueovo;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import com.yuntang.ueovo.register.RegisterEntity;

import net.minecraft.client.Minecraft;
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
        LOGGER.info("HELLO FROM COMMON SETUP");

    }
    private static void initRegister(IEventBus eventBus) {
        RegisterEntity.ENTITY_TYPES.register(eventBus);

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
    }
    
}
