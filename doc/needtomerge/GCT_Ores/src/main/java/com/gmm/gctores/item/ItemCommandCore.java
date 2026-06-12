
package com.gmm.gctores.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
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
public class ItemCommandCore extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:command_core")
    public static final Item block;
    
    public ItemCommandCore(final ElementsGctOresMod instance) {
        super(instance, 113);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemCommandCore.block, 0, new ModelResourceLocation("gct_ores:command_core", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 64;
            this.setTranslationKey("command_core");
            this.setRegistryName("command_core");
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
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u592a\u68d2\u4e86\uff0c\u8fd9\u4e2a\u4e1c\u897f\u6709\u7740\u81f3\u9ad8\u65e0\u4e0a\u7684\u547d\u4ee4\u6743\u9650\uff01");
            list.add("\u7528\u4e8e\u5408\u6210\u547d\u4ee4\u65b9\u5757");
        }
    }
}
