package com.bloodrain.xmasmod.mixin;

import com.bloodrain.xmasmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public abstract class HidePlayerBodyPartsMixin extends HumanoidModel<LivingEntity> {
    public HidePlayerBodyPartsMixin(ModelPart modelPart) {
        super(modelPart);
    }

    @Shadow
    @Final
    public ModelPart leftSleeve;

    @Shadow
    @Final
    public ModelPart rightSleeve;

    @Shadow
    @Final
    public ModelPart jacket;

    @Shadow
    @Final
    public ModelPart leftPants;

    @Shadow
    @Final
    public ModelPart rightPants;

    @Inject(at = @At(value = "TAIL"), method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V")
    private void modifyVisibility(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (entity.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.SANTA_JACKET)) {
                this.body.visible = false;
                this.rightArm.visible = false;
                this.leftArm.visible = false;

                this.jacket.visible = false;
                this.rightSleeve.visible = false;
                this.leftSleeve.visible = false;
        }
        if (entity.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.SANTA_PANTS)) {
            this.rightPants.visible = false;
            this.leftPants.visible = false;
        }
        if (entity.getItemBySlot(EquipmentSlot.FEET).is(ModItems.SANTA_BOOTS)) {
            this.rightPants.visible = false;
            this.leftPants.visible = false;
        }
    }
}
