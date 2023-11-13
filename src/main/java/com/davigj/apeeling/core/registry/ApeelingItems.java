package com.davigj.apeeling.core.registry;

import com.davigj.apeeling.common.item.BananaPeelItem;
import com.davigj.apeeling.core.ApeelingMod;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ApeelingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ApeelingItems {
    public static final ItemSubRegistryHelper HELPER = ApeelingMod.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BANANA_PEEL = HELPER.createItem("banana_peel", () ->
            new BananaPeelItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
