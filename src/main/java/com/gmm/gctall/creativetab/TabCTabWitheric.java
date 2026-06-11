
package com.gmm.gctall.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctall.item.ItemWithericCore;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
public class TabCTabWitheric
{
    public static final CreativeTabs tab = new CreativeTabs("tabc_tab_witheric") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ItemWithericCore.block, 1);
        }
        
        @SideOnly(Side.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
    
    private TabCTabWitheric() {
    }
}

