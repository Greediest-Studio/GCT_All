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
public class ItemShoggySlime extends GctAllElement {
  @ObjectHolder("gct_all:shoggy_slime")
  public static final Item block = null;
  
  public ItemShoggySlime(GctAllContent instance) {
    super(instance, 117);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "shoggy_slime");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("shoggy_slime");
      setRegistryName("shoggy_slime");
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

