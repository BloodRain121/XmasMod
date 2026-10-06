package com.bloodrain.xmasmod.datagen;


import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.blocks.XMBlocks;
import com.bloodrain.xmasmod.item.XMItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class XMItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public XMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, XmasMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(XMItems.GINGERBREAD_DOUGH.get());
        basicItem(XMItems.GINGERBREAD_MAN.get());
        basicItem(XMItems.GINGERBREAD_STAR.get());
        basicItem(XMItems.GINGERBREAD_TREE.get());
        basicItem(XMItems.BAKED_GINGERBREAD_DOUGH.get());
        basicItem(XMItems.BAKED_GINGERBREAD_MAN.get());
        basicItem(XMItems.BAKED_GINGERBREAD_STAR.get());
        basicItem(XMItems.BAKED_GINGERBREAD_TREE.get());
        basicItem(XMItems.GINGERBREAD_HELMET.get());
        basicItem(XMItems.GINGERBREAD_CHESTPLATE.get());
        basicItem(XMItems.GINGERBREAD_LEGGINGS.get());
        basicItem(XMItems.GINGERBREAD_BOOTS.get());
        basicItem(XMItems.SUGAR_GLAZE.get());
        handheldItem(XMItems.CANDY_CANE.get());
        basicItem(XMItems.SANTA_HAT.get());
        basicItem(XMItems.SANTA_JACKET.get());
        basicItem(XMItems.SANTA_PANTS.get());
        basicItem(XMItems.SANTA_BOOTS.get());
        basicItem(XMItems.BIG_GINGERBREAD.get());
        basicItem(XMBlocks.BAKED_BIG_GINGERBREAD.get().asItem());
        basicItem(XMItems.MULLET_WINE.get());
        basicItem(XMBlocks.STRING_LIGHTS.asItem());
        basicItem(XMBlocks.STRING_LIGHTS_RAINBOW.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_RED.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_ORANGE.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_YELLOW.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_LIME.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_GREEN.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_CYAN.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_LIGHT_BLUE.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_BLUE.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_PURPLE.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_MAGENTA.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_PINK.get().asItem());
        basicItem(XMBlocks.STRING_LIGHTS_WHITE.get().asItem());
        basicItem(XMItems.TULSKIY_PRYANIK.get());
        basicItem(XMItems.BAKING_PAN_STAR.get());
        basicItem(XMItems.BAKING_PAN_TREE.get());
        basicItem(XMItems.BAKING_PAN_MAN.get());
        handheldItem(XMItems.CANDY_SWORD.get());
    }
}
