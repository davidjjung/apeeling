package com.davigj.apeeling.core.registry;

import com.davigj.apeeling.common.item.BananaPeelItem;
import com.davigj.apeeling.core.ApeelingMod;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = ApeelingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ApeelingItems {
    public static final ItemSubRegistryHelper HELPER = ApeelingMod.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BANANA_PEEL = HELPER.createItem("banana_peel", () ->
            new BananaPeelItem(new Item.Properties()));


    public static void buildCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(ApeelingMod.MOD_ID)
                .tab(CreativeModeTabs.FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.MELON_SLICE), BANANA_PEEL);
    }
}
