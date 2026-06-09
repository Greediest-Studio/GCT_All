package com.gmm.gctall.common;

import net.minecraft.creativetab.CreativeTabs;

import com.gmm.gctall.Tags;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public final class GctAllCreativeTab {
    public static final CreativeTabs TAB = new CreativeTabs(Tags.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.DIAMOND_BLOCK);
        }
    };

    private GctAllCreativeTab() {
    }
}
