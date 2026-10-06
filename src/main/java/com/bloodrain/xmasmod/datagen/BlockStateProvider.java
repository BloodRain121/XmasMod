package com.bloodrain.xmasmod.datagen;

import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
        blockItem(ModBlocks.SNOW_BRICK_STAIRS);
        blockItem(ModBlocks.SNOW_BRICK_SLAB);
        stairsBlock(ModBlocks.SNOW_BRICK_STAIRS.get(), blockTexture(ModBlocks.SNOW_BRICKS.get()));
        slabBlock(ModBlocks.SNOW_BRICK_SLAB.get(), blockTexture(ModBlocks.SNOW_BRICKS.get()), blockTexture(ModBlocks.SNOW_BRICKS.get()));
        cakeBlock(ModBlocks.BAKED_BIG_GINGERBREAD.get(), "baked_big_gingerbread");

        vineBlock(ModBlocks.STRING_LIGHTS.get(), "string_lights");
        vineBlock(ModBlocks.STRING_LIGHTS_RAINBOW.get(), "string_lights_rainbow");
        vineBlock(ModBlocks.STRING_LIGHTS_RED.get(), "string_lights_red");
        vineBlock(ModBlocks.STRING_LIGHTS_ORANGE.get(), "string_lights_orange");
        vineBlock(ModBlocks.STRING_LIGHTS_YELLOW.get(), "string_lights_yellow");
        vineBlock(ModBlocks.STRING_LIGHTS_LIME.get(), "string_lights_lime");
        vineBlock(ModBlocks.STRING_LIGHTS_GREEN.get(), "string_lights_green");
        vineBlock(ModBlocks.STRING_LIGHTS_CYAN.get(), "string_lights_cyan");
        vineBlock(ModBlocks.STRING_LIGHTS_LIGHT_BLUE.get(), "string_lights_light_blue");
        vineBlock(ModBlocks.STRING_LIGHTS_BLUE.get(), "string_lights_blue");
        vineBlock(ModBlocks.STRING_LIGHTS_PURPLE.get(), "string_lights_purple");
        vineBlock(ModBlocks.STRING_LIGHTS_MAGENTA.get(), "string_lights_magenta");
        vineBlock(ModBlocks.STRING_LIGHTS_PINK.get(), "string_lights_pink");
        vineBlock(ModBlocks.STRING_LIGHTS_WHITE.get(), "string_lights_white");

        logBlock(ModBlocks.CANDY_CANE_BLOCK.get());
        blockItem(ModBlocks.CANDY_CANE_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("xmasmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("xmasmod:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void vineBlock(Block block, String baseName) {
        var b = getMultipartBuilder(block);
        var model = models().withExistingParent("block/" + baseName, "block/vine")
                .texture("vine", modLoc("block/" + baseName))
                .texture("particle", modLoc("block/" + baseName))
                .renderType("cutout");
        b.part().modelFile(model).uvLock(true).addModel().condition(
                BlockStateProperties.NORTH, true
        ).end();
        b.part().modelFile(model).uvLock(true).rotationY(90).addModel().condition(
                BlockStateProperties.EAST, true
        ).end();
        b.part().modelFile(model).uvLock(true).rotationY(180).addModel().condition(
                BlockStateProperties.SOUTH, true
        ).end();
        b.part().modelFile(model).uvLock(true).rotationY(270).addModel().condition(
                BlockStateProperties.WEST, true
        ).end();
    }

    private void cakeBlock(Block cakeBlock, String baseName) {
        getVariantBuilder(cakeBlock).forAllStates(state -> {
            int bites = state.getValue(CakeBlock.BITES);
            String modelName = bites == 0 ? baseName : baseName + "_slice_" + bites;

            String vanillaModelName = bites == 0 ? "cake" : "cake_slice" + bites;
            ResourceLocation vanillaParent = ResourceLocation.withDefaultNamespace("block/" + vanillaModelName);
            String currentModelPath = "block/" + baseName + (bites == 0 ? "" : "_slice" + bites);

            var customModel = models().withExistingParent(currentModelPath, vanillaParent)
                    .texture("top", modLoc("block/" + baseName + "_top"))
                    .texture("bottom", modLoc("block/" + baseName +"_bottom"))
                    .texture("side", modLoc("block/"  + baseName +"_side"))
                    .texture("inside", modLoc("block/" + baseName + "_inner"));

            return ConfiguredModel.builder()
                    .modelFile(customModel)
                    .build();
        });
    }
}
