package com.gmm.gctall.registry;

import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.Tags;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public final class GctAllFoodDiagnostics {
    private static final String[] FOOD_ITEMS = {
            "fruit_of_mind",
            "fruit_of_mind_enchanted",
            "remnant_cookie",
            "shoggothtancale",
            "shoggoth_tancale_soup",
            "muddy_flesh"
    };

    private GctAllFoodDiagnostics() {
    }

    public static void logFoodRegistrations() {
        for (String name : FOOD_ITEMS) {
            ResourceLocation id = new ResourceLocation(Tags.MOD_ID, name);
            Item item = ForgeRegistries.ITEMS.getValue(id);
            if (item == null) {
                GctAllMod.LOGGER.error("Food diagnostics: {} is not registered", id);
                continue;
            }

            ItemStack stack = new ItemStack(item);
            EnumAction useAction = item.getItemUseAction(stack);
            GctAllMod.LOGGER.info(
                    "Food diagnostics: {} -> class={}, itemFood={}, useAction={}, useDuration={}",
                    id,
                    item.getClass().getName(),
                    item instanceof ItemFood,
                    useAction,
                    item.getMaxItemUseDuration(stack)
            );
        }
    }
}
