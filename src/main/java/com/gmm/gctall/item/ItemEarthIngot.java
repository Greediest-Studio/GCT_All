package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEarthIngot extends Item {
  public static final Item block = new ItemEarthIngot();
    public ItemEarthIngot() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("earth_ingot");
      setRegistryName("earth_ingot");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


