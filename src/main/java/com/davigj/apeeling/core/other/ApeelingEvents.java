package com.davigj.apeeling.core.other;

import com.davigj.apeeling.core.ApeelingConfig;
import com.davigj.apeeling.core.ApeelingMod;
import com.davigj.apeeling.core.registry.ApeelingItems;
import com.teamabnormals.neapolitan.common.entity.projectile.BananaPeel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ApeelingMod.MOD_ID)
public class ApeelingEvents {
    @SubscribeEvent
    public static void onEntityDamage(AttackEntityEvent event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();

        if (target instanceof BananaPeel bananaPeel && !player.getAbilities().instabuild) {
            ItemEntity itemEntity = new ItemEntity(player.level, bananaPeel.getX(), bananaPeel.getY(), bananaPeel.getZ(), new ItemStack(ApeelingItems.BANANA_PEEL.get()));
            player.level.addFreshEntity(itemEntity);
        }
    }

    @SubscribeEvent
    public static void onBananaEat(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().getDescriptionId().equals("item.neapolitan.banana")) {
            ItemStack stack = event.getResultStack();
            LivingEntity entity = event.getEntity();
            boolean playerAction = entity instanceof Player;
            if (playerAction && !((Player)entity).getAbilities().instabuild && stack.isEmpty()) {
                if (stack.isEmpty()) {
                    ((Player)entity).getCooldowns().addCooldown(ApeelingItems.BANANA_PEEL.get(), 10);
                }
            }
            if (ApeelingConfig.COMMON.leftoverPeels.get()) {
                if (stack.isEmpty()) {
                    event.setResultStack(new ItemStack((ItemLike) ApeelingItems.BANANA_PEEL.get(), 1));
                } else {
                    ItemStack itemstack = new ItemStack((ItemLike) ApeelingItems.BANANA_PEEL.get(), 1);
                    if (playerAction) {
                        if (!((Player)entity).getAbilities().instabuild) {
                            if (!((Player)entity).getInventory().add(itemstack)) {
                                ((Player)entity).drop(itemstack, false);
                            }
                        }
                    }
                }
            }
        }
    }
}