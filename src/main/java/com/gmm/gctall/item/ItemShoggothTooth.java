package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemShoggothTooth extends Item {
  public static final Item block = new ItemShoggothTooth();
    public ItemShoggothTooth() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("shoggothtooth");
      setRegistryName("shoggothtooth");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


