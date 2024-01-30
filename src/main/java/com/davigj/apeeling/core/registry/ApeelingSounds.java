package com.davigj.apeeling.core.registry;

import com.davigj.apeeling.core.ApeelingMod;
import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ApeelingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ApeelingSounds {
    public static final SoundSubRegistryHelper HELPER = ApeelingMod.REGISTRY_HELPER.getSoundSubHelper();

    public static final RegistryObject<SoundEvent> SLIP = HELPER.createSoundEvent("entity.banana_peel.slip");
}
