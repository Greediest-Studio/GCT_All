package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBligtzRod extends Item {
  public static final Item block = new ItemBligtzRod();
    public ItemBligtzRod() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("bligtz_rod");
      setRegistryName("bligtz_rod");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


