package com.davigj.apeeling.common.dispenser;

import com.teamabnormals.neapolitan.core.registry.NeapolitanEntityTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public class BananaPeelDispenseBehavior extends OptionalDispenseItemBehavior {

    public @NotNull ItemStack execute(BlockSource source, @NotNull ItemStack stack) {
        Direction direction = source.state().getValue(DispenserBlock.FACING);
        EntityType<?> entitytype = (EntityType<?>) NeapolitanEntityTypes.BANANA_PEEL.get();
        entitytype.spawn(source.level(), stack, null, source.pos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
        stack.shrink(1);
        return stack;
    }
}
