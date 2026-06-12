
package com.gmm.gctores.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.creativetab.TabCTab;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ItemSenterianKey extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:senterian_key")
    public static final Item block;
    
    public ItemSenterianKey(final ElementsGctOresMod instance) {
        super(instance, 458);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemSenterianKey.block, 0, new ModelResourceLocation("gct_ores:senterian_key", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 64;
            this.setTranslationKey("senterian_key");
            this.setRegistryName("senterian_key");
            this.setCreativeTab(TabCTab.tab);
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
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u7528\u4e8e\u6253\u5f00\u9ed1\u5ca9\u4e4b\u9501");
        }
    }
}
