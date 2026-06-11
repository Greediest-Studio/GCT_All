package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBninzDust extends Item {
  public static final Item block = new ItemBninzDust();
    public ItemBninzDust() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("bninz_dust");
      setRegistryName("bninz_dust");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


