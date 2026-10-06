package com.bloodrain.xmasmod;

import com.bloodrain.xmasmod.blocks.ModBlocks;
import com.bloodrain.xmasmod.effect.ModEffects;
import com.bloodrain.xmasmod.item.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(XmasMod.MODID)
public class XmasMod {
    public static final String MODID = "xmasmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public XmasMod(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        //modEventBus.addListener(this::addCreative);
    }

//    public void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(EXAMPLE_BLOCK_ITEM);
//        }
//    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
