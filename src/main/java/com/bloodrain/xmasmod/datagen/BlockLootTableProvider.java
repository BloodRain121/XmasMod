package com.bloodrain.xmasmod.datagen;

import com.bloodrain.xmasmod.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {
    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SNOW_BRICKS.get());
        dropSelf(ModBlocks.SNOW_BRICK_STAIRS.get());
        dropSelf(ModBlocks.SNOW_BRICK_SLAB.get());
        dropSelf(ModBlocks.BAKED_BIG_GINGERBREAD.get());
        dropSelf(ModBlocks.STRING_LIGHTS_RAINBOW.get());
        dropSelf(ModBlocks.STRING_LIGHTS.get());
        dropSelf(ModBlocks.STRING_LIGHTS_RED.get());
        dropSelf(ModBlocks.STRING_LIGHTS_ORANGE.get());
        dropSelf(ModBlocks.STRING_LIGHTS_YELLOW.get());
        dropSelf(ModBlocks.STRING_LIGHTS_GREEN.get());
        dropSelf(ModBlocks.STRING_LIGHTS_LIME.get());
        dropSelf(ModBlocks.STRING_LIGHTS_CYAN.get());
        dropSelf(ModBlocks.STRING_LIGHTS_LIGHT_BLUE.get());
        dropSelf(ModBlocks.STRING_LIGHTS_BLUE.get());
        dropSelf(ModBlocks.STRING_LIGHTS_PURPLE.get());
        dropSelf(ModBlocks.STRING_LIGHTS_MAGENTA.get());
        dropSelf(ModBlocks.STRING_LIGHTS_PINK.get());
        dropSelf(ModBlocks.STRING_LIGHTS_WHITE.get());
        dropSelf(ModBlocks.CANDY_CANE_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
