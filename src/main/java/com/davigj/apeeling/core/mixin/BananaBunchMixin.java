package com.davigj.apeeling.core.mixin;

import com.davigj.apeeling.core.ApeelingConfig;
import com.teamabnormals.neapolitan.common.item.BananaBunchItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BananaBunchItem.class)
public class BananaBunchMixin {

    @Inject(method = "placeBanana", at = @At("HEAD"), cancellable = true, remap = false)
    private void  modifyPlaceBanana(Level world, double posX, double posY, double posZ, float yaw, CallbackInfo ci) {
        if (ApeelingConfig.COMMON.bunchesDontPeel.get()) {
            ci.cancel();
        }
    }

    @Inject(method = "throwBanana", at = @At("HEAD"), cancellable = true, remap = false)
    private void modifyThrowBanana(Level world, Player player, float pitch, float yaw, CallbackInfo ci) {
        if (ApeelingConfig.COMMON.bunchesDontPeel.get()) {
            ci.cancel();
        }
    }
}
