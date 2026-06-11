
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyShard extends Item {
    public static final Item block = new ItemStormyShard();

    public ItemStormyShard() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_shard");
        this.setRegistryName("stormy_shard");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
