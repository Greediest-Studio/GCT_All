package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBthdzRod extends Item {
  public static final Item block = new ItemBthdzRod();
    public ItemBthdzRod() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("bthdz_rod");
      setRegistryName("bthdz_rod");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


