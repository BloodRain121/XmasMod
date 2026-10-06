package com.bloodrain.xmasmod.blocks;

import com.bloodrain.xmasmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.bloodrain.xmasmod.XmasMod.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> SNOW_BRICKS = registerBlock("snow_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW)));
    public static final DeferredBlock<StairBlock> SNOW_BRICK_STAIRS = registerBlock("snow_brick_stairs", () -> new StairBlock(SNOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).requiresCorrectToolForDrops().strength(0.2f).sound(SoundType.SNOW)));
    public static final DeferredBlock<SlabBlock> SNOW_BRICK_SLAB = registerBlock("snow_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).requiresCorrectToolForDrops().strength(0.2f).sound(SoundType.SNOW)));
    public static final DeferredBlock<CakeBlock> BAKED_BIG_GINGERBREAD = registerBlock("baked_big_gingerbread", () -> new CakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS = registerBlock("string_lights", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_RAINBOW = registerBlock("string_lights_rainbow", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_WHITE = registerBlock("string_lights_white", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_RED = registerBlock("string_lights_red", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_ORANGE = registerBlock("string_lights_orange", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_YELLOW = registerBlock("string_lights_yellow", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_LIME = registerBlock("string_lights_lime", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_GREEN = registerBlock("string_lights_green", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_CYAN = registerBlock("string_lights_cyan", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_LIGHT_BLUE = registerBlock("string_lights_light_blue", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_BLUE = registerBlock("string_lights_blue", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_PURPLE = registerBlock("string_lights_purple", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_MAGENTA = registerBlock("string_lights_magenta", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRING_LIGHTS_PINK = registerBlock("string_lights_pink", () -> new StringLightsBlock(BlockBehaviour.Properties.of().emissiveRendering((blockState, blockGetter, blockPos) -> true).lightLevel(value -> 10).noCollission().instabreak().sound(SoundType.CHAIN).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<RotatedPillarBlock> CANDY_CANE_BLOCK = registerBlock("candy_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.CANDLE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
