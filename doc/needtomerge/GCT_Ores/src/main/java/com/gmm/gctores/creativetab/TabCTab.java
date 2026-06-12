
package com.gmm.gctores.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctores.item.ItemSkyAlloyIngot;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class TabCTab extends ElementsGctOresMod.ModElement
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
    
    public TabCTab(final ElementsGctOresMod instance) {
        super(instance, 208);
    }
    
    @Override
    public void initElements() {
    }
}
