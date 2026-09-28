package com.bloodrain.xmasmod;

import com.bloodrain.xmasmod.blocks.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.bloodrain.xmasmod.item.ModItems.*;

@Mod(XmasMod.MODID)
public class XmasMod {
    public static final String MODID = "xmasmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public XmasMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        //modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> XMAS_TAB = CREATIVE_MODE_TABS.register("xmasmod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.xmasmod"))
            .withTabsBefore(CreativeModeTabs.FOOD_AND_DRINKS)
            .icon(() -> GINGERBREAD_MAN.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(GINGERBREAD_DOUGH.get());
                output.accept(GINGERBREAD_MAN.get());
                output.accept(GINGERBREAD_STAR.get());
                output.accept(BIG_GINGERBREAD.get());
                output.accept(SUGAR_GLAZE.get());
                output.accept(CANDY_CANE.get());
                output.accept(BAKED_GINGERBREAD_DOUGH.get());
                output.accept(BAKED_GINGERBREAD_MAN.get());
                output.accept(BAKED_GINGERBREAD_STAR.get());
                output.accept(GINGERBREAD_HELMET.get());
                output.accept(GINGERBREAD_CHESTPLATE.get());
                output.accept(GINGERBREAD_LEGGINGS.get());
                output.accept(GINGERBREAD_BOOTS.get());
                output.accept(SANTA_HAT.get());
                output.accept(SANTA_JACKET.get());
                output.accept(SANTA_PANTS.get());
                output.accept(SANTA_BOOTS.get());
                output.accept(ModBlocks.SNOW_BRICKS.get());
                output.accept(ModBlocks.SNOW_BRICK_STAIRS.get());
            }).build());

//    public void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(EXAMPLE_BLOCK_ITEM);
//        }
//    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
