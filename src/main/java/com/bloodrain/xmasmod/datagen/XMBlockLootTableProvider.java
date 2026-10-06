package com.bloodrain.xmasmod.datagen;

import com.bloodrain.xmasmod.blocks.XMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class XMBlockLootTableProvider extends BlockLootSubProvider {
    protected XMBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(XMBlocks.SNOW_BRICKS.get());
        dropSelf(XMBlocks.SNOW_BRICK_STAIRS.get());
        dropSelf(XMBlocks.SNOW_BRICK_SLAB.get());
        dropSelf(XMBlocks.BAKED_BIG_GINGERBREAD.get());
        dropSelf(XMBlocks.STRING_LIGHTS_RAINBOW.get());
        dropSelf(XMBlocks.STRING_LIGHTS.get());
        dropSelf(XMBlocks.STRING_LIGHTS_RED.get());
        dropSelf(XMBlocks.STRING_LIGHTS_ORANGE.get());
        dropSelf(XMBlocks.STRING_LIGHTS_YELLOW.get());
        dropSelf(XMBlocks.STRING_LIGHTS_GREEN.get());
        dropSelf(XMBlocks.STRING_LIGHTS_LIME.get());
        dropSelf(XMBlocks.STRING_LIGHTS_CYAN.get());
        dropSelf(XMBlocks.STRING_LIGHTS_LIGHT_BLUE.get());
        dropSelf(XMBlocks.STRING_LIGHTS_BLUE.get());
        dropSelf(XMBlocks.STRING_LIGHTS_PURPLE.get());
        dropSelf(XMBlocks.STRING_LIGHTS_MAGENTA.get());
        dropSelf(XMBlocks.STRING_LIGHTS_PINK.get());
        dropSelf(XMBlocks.STRING_LIGHTS_WHITE.get());
        dropSelf(XMBlocks.CANDY_CANE_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return XMBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
