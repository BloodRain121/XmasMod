package com.bloodrain.xmasmod.client;

import com.bloodrain.xmasmod.XmasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoObjectRenderer;

public class SantaArmorArmRenderer extends GeoObjectRenderer<SantaArmorArmAnimatable> {
    public SantaArmorArmRenderer() {
        super(new GeoModel<SantaArmorArmAnimatable>() {
            @Override
            public ResourceLocation getModelResource(SantaArmorArmAnimatable animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "geo/santa_armor_arm.geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(SantaArmorArmAnimatable animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "textures/armor/santa_armor.png");
            }

            @Override
            public ResourceLocation getAnimationResource(SantaArmorArmAnimatable animatable) {
                return ResourceLocation.fromNamespaceAndPath(XmasMod.MODID, "animations/armor/santa_armor_arm.animation.json");
            }
        });
    }
}
