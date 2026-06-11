package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBligtzDust extends Item {
  public static final Item block = new ItemBligtzDust();
    public ItemBligtzDust() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("bligtz_dust");
      setRegistryName("bligtz_dust");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


