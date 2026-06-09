package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemEssenceOfWarpedRuin extends GctAllElement {
  @ObjectHolder("gct_all:essence_of_warped_ruin")
  public static final Item block = null;
  
  public ItemEssenceOfWarpedRuin(GctAllContent instance) {
    super(instance, 35);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "essence_of_warped_ruin");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("essence_of_warped_ruin");
      setRegistryName("essence_of_warped_ruin");
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
  }
}

