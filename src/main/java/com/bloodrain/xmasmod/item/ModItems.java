package com.bloodrain.xmasmod.item;

import com.bloodrain.xmasmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.bloodrain.xmasmod.XmasMod.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredItem<BlockItem> SNOW_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("snow_bricks", ModBlocks.SNOW_BRICKS);
    public static final DeferredItem<BlockItem> SNOW_BRICK_STAIRS_ITEM = ITEMS.registerSimpleBlockItem("snow_brick_stairs", ModBlocks.SNOW_BRICK_STAIRS);
    public static final DeferredItem<BlockItem> BAKED_BIG_GINGERBREAD = ITEMS.registerSimpleBlockItem("baked_big_gingerbread", ModBlocks.BAKED_BIG_GINGERBREAD, new Item.Properties().stacksTo(1));

    public static final DeferredItem<Item> GINGERBREAD_MAN = ITEMS.register("gingerbread_man", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_MAN = ITEMS.register("baked_gingerbread_man", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> GINGERBREAD_DOUGH = ITEMS.register("gingerbread_dough", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_DOUGH = ITEMS.register("baked_gingerbread_dough", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> GINGERBREAD_HELMET = ITEMS.register("gingerbread_helmet", () -> new ArmorItem(ArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GINGERBREAD_CHESTPLATE = ITEMS.register("gingerbread_chestplate", () -> new ArmorItem(ArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GINGERBREAD_LEGGINGS = ITEMS.register("gingerbread_leggings", () -> new ArmorItem(ArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GINGERBREAD_BOOTS = ITEMS.register("gingerbread_boots", () -> new ArmorItem(ArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SUGAR_GLAZE = ITEMS.register("sugar_glaze", () -> new Item(new Item.Properties().craftRemainder(net.minecraft.world.item.Items.BOWL)));
    public static final DeferredItem<Item> CANDY_CANE = ITEMS.register("candy_cane", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build()).stacksTo(16)));
    public static final DeferredItem<Item> GINGERBREAD_STAR = ITEMS.register("gingerbread_star", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_STAR = ITEMS.register("baked_gingerbread_star", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> SANTA_HAT = ITEMS.register("santa_hat", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_JACKET = ITEMS.register("santa_jacket", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_PANTS = ITEMS.register("santa_pants", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_BOOTS = ITEMS.register("santa_boots", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BIG_GINGERBREAD = ITEMS.register("big_gingerbread", () -> new Item(new Item.Properties().stacksTo(1)));
}
