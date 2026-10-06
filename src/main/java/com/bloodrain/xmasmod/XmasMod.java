package com.bloodrain.xmasmod;

import com.bloodrain.xmasmod.blocks.XMBlocks;
import com.bloodrain.xmasmod.effect.XMEffects;
import com.bloodrain.xmasmod.item.XMItems;
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
        XMBlocks.BLOCKS.register(modEventBus);
        XMItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        XMEffects.MOB_EFFECTS.register(modEventBus);

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
