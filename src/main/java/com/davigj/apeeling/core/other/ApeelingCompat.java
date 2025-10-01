package com.davigj.apeeling.core.other;

import com.davigj.apeeling.common.dispenser.BananaPeelDispenseBehavior;
import com.davigj.apeeling.core.registry.ApeelingItems;
import net.minecraft.world.level.block.DispenserBlock;

public class ApeelingCompat {

    public static void registerCompat() {
        registerDispenserBehaviors();
    }

    private static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ApeelingItems.BANANA_PEEL.get(), new BananaPeelDispenseBehavior());
    }
}
