package com.davigj.apeeling.core;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ApeelingConfig {
    public static class Common {
        public final ModConfigSpec.ConfigValue<Boolean> bunchesDontPeel;
        public final ModConfigSpec.ConfigValue<Boolean> leftoverPeels;
        public final ModConfigSpec.ConfigValue<Boolean> slipSound;

        Common (ModConfigSpec.Builder builder) {
            builder.push("Banana bunch tweaks");
            bunchesDontPeel = builder.comment("Banana bunches no longer create banana peels").define("Bunches don't create peels", true);
            leftoverPeels = builder.comment("Eating bananas adds peels to the player's inventory").define("Leftover peels", true);
            slipSound = builder.comment("Players stepping on banana peels generate an iconic sound effect").define("Leftover peels", true);
            builder.pop();
        }
    }

    public static final ModConfigSpec COMMON_SPEC;
    public static final ApeelingConfig.Common COMMON;

    static {
        final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ApeelingConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
