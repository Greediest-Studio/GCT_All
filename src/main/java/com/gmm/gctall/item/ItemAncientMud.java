package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemAncientMud extends GctAllElement {
  @ObjectHolder("gct_all:ancientmud")
  public static final Item block = null;
  
  public ItemAncientMud(GctAllContent instance) {
    super(instance, 19);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "ancientmud");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("ancientmud");
      setRegistryName("ancientmud");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public int getItemEnchantability() {
      return 0;
    }
    
    public int getMaxItemUseDuration(ItemStack itemstack) {
      return 0;
    }
    
    public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
      return 1.0F;
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u5728\u7075\u795E\u53F0\u5EA7\u4E0A\u53F3\u51FB\u4EE5\u53EC\u5524\u8FDC\u53E4\u4FEE\u683C\u65AF");
    }
  }
}

