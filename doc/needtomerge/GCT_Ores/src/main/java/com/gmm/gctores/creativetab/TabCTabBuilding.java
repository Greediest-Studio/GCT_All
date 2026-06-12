
package com.gmm.gctores.creativetab;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctores.block.BlockGlowstoneStair;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class TabCTabBuilding extends ElementsGctOresMod.ModElement
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
    
    public TabCTabBuilding(final ElementsGctOresMod instance) {
        super(instance, 428);
    }
    
    @Override
    public void initElements() {
    }
}
