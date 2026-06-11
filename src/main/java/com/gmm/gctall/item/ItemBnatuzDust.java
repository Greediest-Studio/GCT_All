package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBnatuzDust extends Item {
  public static final Item block = new ItemBnatuzDust();
    public ItemBnatuzDust() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("bnatuz_dust");
      setRegistryName("bnatuz_dust");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


