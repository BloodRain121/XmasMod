package com.bloodrain.xmasmod.client;

import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.item.SantaArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SantaArmorRenderer extends GeoArmorRenderer<SantaArmorItem> {
    public <I extends SantaArmorItem> SantaArmorRenderer() {
        super(new GeoModel<SantaArmorItem>() {
            @Override
            public ResourceLocation getModelResource(SantaArmorItem animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "geo/santa_armor.geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(SantaArmorItem animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "textures/armor/santa_armor.png");
            }

            @Override
            public ResourceLocation getAnimationResource(SantaArmorItem animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "animations/armor/santa_armor.animation.json");
            }
        });
    }
}
