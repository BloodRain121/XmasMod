package com.bloodrain.xmasmod.datagen;


import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.item.ModItems;
import net.minecraft.data.PackOutput;
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
        basicItem(ModItems.BAKED_GINGERBREAD_DOUGH.get());
        basicItem(ModItems.BAKED_GINGERBREAD_MAN.get());
        basicItem(ModItems.BAKED_GINGERBREAD_STAR.get());
        basicItem(ModItems.GINGERBREAD_HELMET.get());
        basicItem(ModItems.GINGERBREAD_CHESTPLATE.get());
        basicItem(ModItems.GINGERBREAD_LEGGINGS.get());
        basicItem(ModItems.GINGERBREAD_BOOTS.get());
        basicItem(ModItems.SUGAR_GLAZE.get());
        handheldItem(ModItems.CANDY_CANE.get());
        basicItem(ModItems.SANTA_HAT.get());
//        basicItem(ModItems.SANTA_CHESTPLATE.get());
        basicItem(ModItems.SANTA_PANTS.get());
        basicItem(ModItems.SANTA_BOOTS.get());
        basicItem(ModItems.BIG_GINGERBREAD.get());
        basicItem(ModItems.BAKED_BIG_GINGERBREAD.get());
        basicItem(ModItems.MULLET_WINE.get());
    }
}
