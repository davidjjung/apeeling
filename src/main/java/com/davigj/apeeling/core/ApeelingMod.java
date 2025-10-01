package com.davigj.apeeling.core;

import com.davigj.apeeling.core.other.ApeelingClientCompat;
import com.davigj.apeeling.core.other.ApeelingCompat;
import com.davigj.apeeling.core.registry.ApeelingItems;
import com.davigj.apeeling.core.registry.ApeelingSoundEvents;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(ApeelingMod.MOD_ID)
public class ApeelingMod {
    public static final String MOD_ID = "apeeling";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public ApeelingMod(IEventBus bus, ModContainer container) {
        ApeelingItems.ITEMS.register(bus);
        ApeelingSoundEvents.SOUNDS.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);

        container.registerConfig(ModConfig.Type.COMMON, ApeelingConfig.COMMON_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            event.enqueueWork(ApeelingCompat::registerCompat);
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            event.enqueueWork(ApeelingClientCompat::register);
        });
    }

    private void dataSetup(GatherDataEvent event) {

    }
}