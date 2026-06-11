package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEssenceOfDarkerrealm extends Item {
  public static final Item block = new ItemEssenceOfDarkerrealm();
    public ItemEssenceOfDarkerrealm() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("essenceofdarkerrealm");
      setRegistryName("essenceofdarkerrealm");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


