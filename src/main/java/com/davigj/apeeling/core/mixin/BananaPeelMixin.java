package com.davigj.apeeling.core.mixin;

import com.davigj.apeeling.core.registry.ApeelingItems;
import com.teamabnormals.neapolitan.common.entity.projectile.BananaPeel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BananaPeel.class)
public class BananaPeelMixin {

    @Inject(method = "getPickedResult", at = @At("HEAD"), cancellable = true, remap = false)
    private void modifyGetPickedResult(HitResult target, CallbackInfoReturnable<ItemStack> ci) {
        ci.setReturnValue(new ItemStack((ItemLike) ApeelingItems.BANANA_PEEL.get()));
    }
}
