package com.bloodrain.xmasmod.client;

import com.bloodrain.xmasmod.XmasMod;
import com.bloodrain.xmasmod.item.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderArmEvent;

@EventBusSubscriber(modid = XmasMod.MODID, value = Dist.CLIENT)
public class SantaArmorArmRenderHandler {

    private static final SantaArmorArmAnimatable animatable = new SantaArmorArmAnimatable();
    private static SantaArmorArmRenderer renderer;

    @SubscribeEvent
    public static void onRenderArm(RenderArmEvent event) {
        AbstractClientPlayer player = event.getPlayer();
        if (player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.SANTA_JACKET))
        {
            if (renderer == null) {
                renderer = new SantaArmorArmRenderer();
            }

            HumanoidArm arm = event.getArm();
            PoseStack poseStack = event.getPoseStack();
            float partialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(false);

            event.setCanceled(true);

            poseStack.pushPose();

            if (arm == HumanoidArm.LEFT) {
                poseStack.scale(1.0F, 1.0F, 1.0F);
                poseStack.translate(0.0f, -0.65f, -0.6f);
            } else {
                poseStack.scale(-1.0f, 1.0f, 1.0f);
                poseStack.translate(0.0f, -0.65f, -0.6f);
            }

            net.minecraft.client.renderer.RenderType renderType = renderer.getRenderType(
                    animatable,
                    renderer.getTextureLocation(animatable),
                    event.getMultiBufferSource(),
                    partialTick
            );

            com.mojang.blaze3d.vertex.VertexConsumer vertexConsumer = event.getMultiBufferSource().getBuffer(renderType);

            renderer.render(
                    poseStack,
                    animatable,
                    event.getMultiBufferSource(),
                    renderType,
                    vertexConsumer,
                    event.getPackedLight(),
                    partialTick
            );

            poseStack.popPose();
        }
    }
}

