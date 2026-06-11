
package com.gmm.gctall.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctall.item.ItemSkyAlloyIngot;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
public class TabCTab
{
    public static final CreativeTabs tab = new CreativeTabs("tabc_tab") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ItemSkyAlloyIngot.block, 1);
        }
        
        @SideOnly(Side.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
    
    private TabCTab() {
    }
}

