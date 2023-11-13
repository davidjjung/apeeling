package com.davigj.apeeling.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ApeelingConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> bunchesDontPeel;
        public final ForgeConfigSpec.ConfigValue<Boolean> leftoverPeels;

        Common (ForgeConfigSpec.Builder builder) {
            builder.push("Banana bunch tweaks");
            bunchesDontPeel = builder.comment("Banana bunches no longer create banana peels").define("Bunches don't create peels", true);
            leftoverPeels = builder.comment("Eating bananas adds peels to the player's inventory").define("Leftover peels", true);
            builder.pop();
        }
    }

    static final ForgeConfigSpec COMMON_SPEC;
    public static final ApeelingConfig.Common COMMON;


    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ApeelingConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
