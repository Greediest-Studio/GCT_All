
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemRainboquartz extends Item {
    public static final Item block = new ItemRainboquartz();

    public ItemRainboquartz() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("rainboquartz");
        this.setRegistryName("rainboquartz");
        this.setCreativeTab(TabCTab.tab);

    }
}
