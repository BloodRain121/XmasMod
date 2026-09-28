package com.bloodrain.xmasmod.datagen;

import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, XmasMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SNOW_BRICKS);
        stairsBlock(ModBlocks.SNOW_BRICK_STAIRS.get(), blockTexture(ModBlocks.SNOW_BRICKS.get()));
        makeCakeBlock(ModBlocks.BAKED_BIG_GINGERBREAD.get(), "baked_big_gingerbread");
        //blockItem(ModBlocks.SNOW_BRICK_STAIRS);
    }

//    private void blockItem(DeferredBlock<?> deferredBlock) {
//        simpleBlockWithItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("xmasmod:block/" + deferredBlock.getId().getPath()));
//    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void makeCakeBlock(Block cakeBlock, String baseName) {
        getVariantBuilder(cakeBlock).forAllStates(state -> {
            int bites = state.getValue(CakeBlock.BITES);
            String modelName = bites == 0 ? baseName : baseName + "_slice_" + bites;

            String vanillaModelName = bites == 0 ? "cake" : "cake_slice" + bites;
            ResourceLocation vanillaParent = ResourceLocation.withDefaultNamespace("block/" + vanillaModelName);
            String currentModelPath = "block/" + baseName + (bites == 0 ? "" : "_slice" + bites);

            var customModel = models().withExistingParent(currentModelPath, vanillaParent)
                    // Текстура верха торта (assets/modid/textures/block/my_cake_top.png)
                    .texture("top", modLoc("block/" + baseName + "_top"))
                    // Текстура низа торта
                    .texture("bottom", modLoc("block/" + baseName +"_bottom"))
                    // Текстура боковых сторон торта
                    .texture("side", modLoc("block/"  + baseName +"_side"))
                    // Текстура внутренней части (срез торта), нужна для стадий slice1-slice6
                    .texture("inside", modLoc("block/" + baseName + "_inner"));

            return ConfiguredModel.builder()
                    .modelFile(customModel)
                    .build();
        });
    }
}
