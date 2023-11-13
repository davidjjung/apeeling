package com.davigj.apeeling.core.other;

import com.davigj.apeeling.common.dispenser.BananaPeelDispenseBehavior;
import com.davigj.apeeling.core.registry.ApeelingItems;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.level.block.DispenserBlock;

public class ApeelingCompat {

    public static void registerCompat() {
        registerCompostables();
        registerDispenserBehaviors();
    }

    private static void registerCompostables() {
        DataUtil.registerCompostable(ApeelingItems.BANANA_PEEL.get(), 0.55F);
    }

    private static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ApeelingItems.BANANA_PEEL.get(), new BananaPeelDispenseBehavior());
    }
}
