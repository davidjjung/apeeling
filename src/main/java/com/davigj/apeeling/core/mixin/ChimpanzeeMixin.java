package com.davigj.apeeling.core.mixin;

import com.davigj.apeeling.common.item.BananaPeelItem;
import com.davigj.apeeling.core.registry.ApeelingItems;
import com.teamabnormals.neapolitan.common.entity.animal.Chimpanzee;
import com.teamabnormals.neapolitan.common.entity.projectile.BananaPeel;
import com.teamabnormals.neapolitan.core.registry.NeapolitanEntityTypes;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chimpanzee.class)
public class ChimpanzeeMixin {

    @Inject(method = "throwHeldItem", at = @At("HEAD"), remap = false, cancellable = true)
    public void modifyThrowHeldItem(InteractionHand hand, CallbackInfo ci) {
        Chimpanzee chimp = (Chimpanzee) (Object) this;
        ItemStack stack = chimp.getItemInHand(hand);
        Level level = chimp.level();
        if (!stack.isEmpty() && !level.isClientSide) {
            if (stack.getItem() instanceof BananaPeelItem) {
                BananaPeel peel = NeapolitanEntityTypes.BANANA_PEEL.get().create(level);
                if (peel != null) {
                    peel.setPos(chimp.getX(), chimp.getEyeY() - 0.1, chimp.getZ());
                    Vec3 vector3d = new Vec3(chimp.getLookAngle().x * 0.15, 0.1, chimp.getLookAngle().z * 0.15);
                    peel.setDeltaMovement(vector3d);
                    level.addFreshEntity(peel);
                    chimp.setItemInHand(hand, ItemStack.EMPTY);
                    chimp.swingArms();
                    level.broadcastEntityEvent(chimp, (byte) 4);
                    ci.cancel();
                }
            }
        }
    }

    @Inject(method = "eatSnack", at = @At("HEAD"), remap = false, cancellable = true)
    public void modifyEatSnack(CallbackInfo ci) {
        Chimpanzee chimp = (Chimpanzee) (Object) this;
        if (!chimp.getSnack().isEmpty() && chimp.getSnack().getItem() == NeapolitanItems.BANANA.get()) {
            chimp.heal((float) ((Item) NeapolitanItems.BANANA.get()).getFoodProperties().getNutrition());
            chimp.getSnack().finishUsingItem(chimp.level(), chimp);
            chimp.setItemInHand(chimp.getSnackHand(), new ItemStack(ApeelingItems.BANANA_PEEL.get()));
            chimp.setHunger(0);
            ci.cancel();
        }
    }

}
