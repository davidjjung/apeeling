package com.davigj.apeeling.core.registry;

import com.davigj.apeeling.core.ApeelingMod;
import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ApeelingSoundEvents {
    public static final SoundSubRegistryHelper SOUNDS = ApeelingMod.REGISTRY_HELPER.getSoundSubHelper();

    public static final DeferredHolder<SoundEvent, SoundEvent> SLIP = SOUNDS.createSoundEvent("entity.banana_peel.slip");
}
