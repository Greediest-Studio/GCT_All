package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHolysteelIngot extends Item {
  public static final Item block = new ItemHolysteelIngot();
    public ItemHolysteelIngot() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("holysteel_ingot");
      setRegistryName("holysteel_ingot");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


