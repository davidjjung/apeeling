package com.davigj.apeeling.core.registry;

import com.davigj.apeeling.common.item.BananaPeelItem;
import com.davigj.apeeling.core.ApeelingMod;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.minecraft.world.item.crafting.Ingredient.of;

public class ApeelingItems {
    public static final ItemSubRegistryHelper ITEMS = ApeelingMod.REGISTRY_HELPER.getItemSubHelper();

    public static final DeferredItem<BananaPeelItem> BANANA_PEEL = ITEMS.createItem("banana_peel", () ->
            new BananaPeelItem(new Item.Properties()));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(ApeelingMod.MOD_ID)
                .tab(CreativeModeTabs.INGREDIENTS)
                .addItemsAfter(of(Items.HONEYCOMB), BANANA_PEEL);
    }
}
