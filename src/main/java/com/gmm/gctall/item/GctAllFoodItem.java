package com.gmm.gctall.item;

import com.gmm.gctall.Tags;
import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GctAllFoodItem extends ItemFood {
    public GctAllFoodItem(String registryName, int amount, float saturation, boolean wolfFood) {
        this(registryName, amount, saturation, wolfFood, true);
    }

    public GctAllFoodItem(String registryName, int amount, float saturation, boolean wolfFood, boolean alwaysEdible) {
        super(amount, saturation, wolfFood);
        setTranslationKey(registryName);
        setRegistryName(new ResourceLocation(Tags.MOD_ID, registryName));
        setCreativeTab(GctAllCreativeTab.TAB);
        setMaxStackSize(64);
        if (alwaysEdible) {
            setAlwaysEdible();
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }
}
