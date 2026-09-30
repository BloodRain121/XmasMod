package com.bloodrain.xmasmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WarmthEffect extends MobEffect {
    protected WarmthEffect() {
        super(MobEffectCategory.BENEFICIAL, 16755263);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.getTicksFrozen() > 0) {
            livingEntity.setTicksFrozen(0);
        }
        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
