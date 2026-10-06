package com.bloodrain.xmasmod;

import com.bloodrain.xmasmod.blocks.XMBlocks;
import com.bloodrain.xmasmod.item.XMItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.bloodrain.xmasmod.XmasMod.MODID;
import static com.bloodrain.xmasmod.item.XMItems.*;
import static com.bloodrain.xmasmod.item.XMItems.SANTA_BOOTS;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> XMAS_TAB = CREATIVE_MODE_TABS.register("xmasmod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.xmasmod"))
            .icon(() -> SANTA_HAT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(GINGERBREAD_DOUGH.get());
                output.accept(GINGERBREAD_MAN.get());
                output.accept(GINGERBREAD_STAR.get());
                output.accept(GINGERBREAD_TREE.get());
                output.accept(BIG_GINGERBREAD.get());
                output.accept(BAKING_PAN_STAR.get());
                output.accept(BAKING_PAN_TREE.get());
                output.accept(BAKING_PAN_MAN.get());
                output.accept(SUGAR_GLAZE.get());
                output.accept(CANDY_CANE.get());
                output.accept(XMBlocks.CANDY_CANE_BLOCK.get());
                output.accept(XMItems.CANDY_SWORD.get());
                output.accept(MULLET_WINE.get());
                output.accept(BAKED_GINGERBREAD_DOUGH.get());
                output.accept(BAKED_GINGERBREAD_MAN.get());
                output.accept(BAKED_GINGERBREAD_STAR.get());
                output.accept(BAKED_GINGERBREAD_TREE.get());
                output.accept(XMBlocks.BAKED_BIG_GINGERBREAD.get());
                output.accept(GINGERBREAD_HELMET.get());
                output.accept(GINGERBREAD_CHESTPLATE.get());
                output.accept(GINGERBREAD_LEGGINGS.get());
                output.accept(GINGERBREAD_BOOTS.get());
                output.accept(SANTA_HAT.get());
                output.accept(SANTA_JACKET.get());
                output.accept(SANTA_PANTS.get());
                output.accept(SANTA_BOOTS.get());
                output.accept(XMBlocks.SNOW_BRICKS.get());
                output.accept(XMBlocks.SNOW_BRICK_STAIRS.get());
                output.accept(XMBlocks.SNOW_BRICK_SLAB.get());
                output.accept(XMBlocks.STRING_LIGHTS.get());
                output.accept(XMBlocks.STRING_LIGHTS_RAINBOW.get());
                output.accept(XMBlocks.STRING_LIGHTS_WHITE.get());
                output.accept(XMBlocks.STRING_LIGHTS_RED.get());
                output.accept(XMBlocks.STRING_LIGHTS_ORANGE.get());
                output.accept(XMBlocks.STRING_LIGHTS_YELLOW.get());
                output.accept(XMBlocks.STRING_LIGHTS_LIME.get());
                output.accept(XMBlocks.STRING_LIGHTS_GREEN.get());
                output.accept(XMBlocks.STRING_LIGHTS_CYAN.get());
                output.accept(XMBlocks.STRING_LIGHTS_LIGHT_BLUE.get());
                output.accept(XMBlocks.STRING_LIGHTS_BLUE.get());
                output.accept(XMBlocks.STRING_LIGHTS_PURPLE.get());
                output.accept(XMBlocks.STRING_LIGHTS_MAGENTA.get());
                output.accept(XMBlocks.STRING_LIGHTS_PINK.get());
            }).build());
}
