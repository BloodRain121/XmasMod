package com.bloodrain.xmasmod.datagen;


import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.blocks.ModBlocks;
import com.bloodrain.xmasmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, XmasMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GINGERBREAD_DOUGH.get());
        basicItem(ModItems.GINGERBREAD_MAN.get());
        basicItem(ModItems.GINGERBREAD_STAR.get());
        basicItem(ModItems.GINGERBREAD_TREE.get());
        basicItem(ModItems.BAKED_GINGERBREAD_DOUGH.get());
        basicItem(ModItems.BAKED_GINGERBREAD_MAN.get());
        basicItem(ModItems.BAKED_GINGERBREAD_STAR.get());
        basicItem(ModItems.BAKED_GINGERBREAD_TREE.get());
        basicItem(ModItems.GINGERBREAD_HELMET.get());
        basicItem(ModItems.GINGERBREAD_CHESTPLATE.get());
        basicItem(ModItems.GINGERBREAD_LEGGINGS.get());
        basicItem(ModItems.GINGERBREAD_BOOTS.get());
        basicItem(ModItems.SUGAR_GLAZE.get());
        handheldItem(ModItems.CANDY_CANE.get());
        basicItem(ModItems.SANTA_HAT.get());
        basicItem(ModItems.SANTA_JACKET.get());
        basicItem(ModItems.SANTA_PANTS.get());
        basicItem(ModItems.SANTA_BOOTS.get());
        basicItem(ModItems.BIG_GINGERBREAD.get());
        basicItem(Item.byBlock(ModBlocks.BAKED_BIG_GINGERBREAD.get()));
        basicItem(ModItems.MULLET_WINE.get());
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_RAINBOW.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_RED.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_ORANGE.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_YELLOW.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_LIME.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_GREEN.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_CYAN.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_LIGHT_BLUE.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_BLUE.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_PURPLE.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_MAGENTA.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_PINK.get()));
        basicItem(Item.byBlock(ModBlocks.STRING_LIGHTS_WHITE.get()));
        basicItem(ModItems.TULSKIY_PRYANIK.get());
        basicItem(ModItems.BAKING_PAN_STAR.get());
        basicItem(ModItems.BAKING_PAN_TREE.get());
        basicItem(ModItems.BAKING_PAN_MAN.get());
        handheldItem(ModItems.CANDY_SWORD.get());
    }
}
