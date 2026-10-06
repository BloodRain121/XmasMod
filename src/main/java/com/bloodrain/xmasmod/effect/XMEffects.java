package com.bloodrain.xmasmod.effect;

import com.bloodrain.xmasmod.XmasMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class XMEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, XmasMod.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> WARMTH = MOB_EFFECTS.register("warmth", () -> new WarmthEffect());
}
