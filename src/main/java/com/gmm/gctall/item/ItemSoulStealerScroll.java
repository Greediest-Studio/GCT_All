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
public class ItemSoulStealerScroll extends GctAllElement {
  @ObjectHolder("gct_all:soul_stealer_scroll")
  public static final Item block = null;
  
  public ItemSoulStealerScroll(GctAllContent instance) {
    super(instance, 71);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "soul_stealer_scroll");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("soul_stealer_scroll");
      setRegistryName("soul_stealer_scroll");
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
      list.add("\u00A7c\u4F3C\u4E4E\u662F\u67D0\u4F4D\u795E\u660E\u7559\u4E0B\u7684\u9057\u7269\uFF1F");
    }
  }
}

