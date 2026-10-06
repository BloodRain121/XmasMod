package com.bloodrain.xmasmod.item;

import com.bloodrain.xmasmod.effect.XMEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.bloodrain.xmasmod.XmasMod.MODID;

public class XMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> GINGERBREAD_MAN = ITEMS.register("gingerbread_man", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_MAN = ITEMS.register("baked_gingerbread_man", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> GINGERBREAD_DOUGH = ITEMS.register("gingerbread_dough", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_DOUGH = ITEMS.register("baked_gingerbread_dough", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> GINGERBREAD_HELMET = ITEMS.register("gingerbread_helmet", () -> new GingerbreadArmorItem(XMArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(100).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> GINGERBREAD_CHESTPLATE = ITEMS.register("gingerbread_chestplate", () -> new GingerbreadArmorItem(XMArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(100).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> GINGERBREAD_LEGGINGS = ITEMS.register("gingerbread_leggings", () -> new GingerbreadArmorItem(XMArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(100).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> GINGERBREAD_BOOTS = ITEMS.register("gingerbread_boots", () -> new GingerbreadArmorItem(XMArmorMaterials.GINGERBREAD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(100).food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.0F).build())));
    public static final DeferredItem<Item> SUGAR_GLAZE = ITEMS.register("sugar_glaze", () -> new Item(new Item.Properties().craftRemainder(net.minecraft.world.item.Items.BOWL)));
    public static final DeferredItem<Item> CANDY_CANE = ITEMS.register("candy_cane", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build()).stacksTo(16)));
    public static final DeferredItem<Item> CANDY_SWORD = ITEMS.register("candy_sword", () -> new CandySwordItem(new Item.Properties().attributes(CandySwordItem.createAttributes()).food(new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).build()).stacksTo(1).durability(100)));
    public static final DeferredItem<Item> GINGERBREAD_STAR = ITEMS.register("gingerbread_star", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_STAR = ITEMS.register("baked_gingerbread_star", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> GINGERBREAD_TREE = ITEMS.register("gingerbread_tree", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BAKED_GINGERBREAD_TREE = ITEMS.register("baked_gingerbread_tree", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).build())));
    public static final DeferredItem<Item> SANTA_HAT = ITEMS.register("santa_hat", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_JACKET = ITEMS.register("santa_jacket", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_PANTS = ITEMS.register("santa_pants", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SANTA_BOOTS = ITEMS.register("santa_boots", () -> new SantaArmorItem(net.minecraft.world.item.ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BIG_GINGERBREAD = ITEMS.register("big_gingerbread", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MULLET_WINE = ITEMS.register("mulled_wine", () -> new DrinkItem(new Item.Properties().stacksTo(1), new MobEffectInstance(XMEffects.WARMTH, 1200, 0)));

    public static final DeferredItem<Item> TULSKIY_PRYANIK = ITEMS.register("tulskiy_pryanik", () -> new Item(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().build())));

    public static final DeferredItem<Item> BAKING_PAN_STAR = ITEMS.register("baking_pan_star", () -> new ReusableCraftingItem(new Item.Properties().durability(10)));
    public static final DeferredItem<Item> BAKING_PAN_TREE = ITEMS.register("baking_pan_tree", () -> new ReusableCraftingItem(new Item.Properties().durability(10)));
    public static final DeferredItem<Item> BAKING_PAN_MAN = ITEMS.register("baking_pan_man", () -> new ReusableCraftingItem(new Item.Properties().durability(10)));
    public static final DeferredItem<Item> SLED = ITEMS.register("sled", () -> new BoatItem(false, Boat.Type.OAK,new Item.Properties()));

}
