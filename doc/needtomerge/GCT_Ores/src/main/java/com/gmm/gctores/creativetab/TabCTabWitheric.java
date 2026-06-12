
package com.gmm.gctores.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctores.item.ItemWithericCore;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class TabCTabWitheric extends ElementsGctOresMod.ModElement
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
    
    public TabCTabWitheric(final ElementsGctOresMod instance) {
        super(instance, 315);
    }
    
    @Override
    public void initElements() {
    }
}
