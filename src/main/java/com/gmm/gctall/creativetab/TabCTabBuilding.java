
package com.gmm.gctall.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctall.block.BlockGlowstoneStair;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
public class TabCTabBuilding
{
    public static final CreativeTabs tab = new CreativeTabs("tabc_tab_building") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(BlockGlowstoneStair.block, 1);
        }
        
        @SideOnly(Side.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
    
    private TabCTabBuilding() {
    }
}

