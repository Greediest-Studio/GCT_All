
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyFragmentLarge extends Item {
    public static final Item block = new ItemStormyFragmentLarge();

    public ItemStormyFragmentLarge() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_fragment_large");
        this.setRegistryName("stormy_fragment_large");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
