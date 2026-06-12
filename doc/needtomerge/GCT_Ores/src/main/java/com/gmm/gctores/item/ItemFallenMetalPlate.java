
package com.gmm.gctores.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.creativetab.TabCTabWitheric;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ItemFallenMetalPlate extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:fallen_metal_plate")
    public static final Item block;
    
    public ItemFallenMetalPlate(final ElementsGctOresMod instance) {
        super(instance, 141);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemFallenMetalPlate.block, 0, new ModelResourceLocation("gct_ores:fallen_metal_plate", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 64;
            this.setTranslationKey("fallen_metal_plate");
            this.setRegistryName("fallen_metal_plate");
            this.setCreativeTab(TabCTabWitheric.tab);
        }
        
        public int getItemEnchantability() {
            return 0;
        }
        
        public int getMaxItemUseDuration(final ItemStack itemstack) {
            return 0;
        }
        
        public float getDestroySpeed(final ItemStack par1ItemStack, final IBlockState par2Block) {
            return 1.0f;
        }
    }
}
