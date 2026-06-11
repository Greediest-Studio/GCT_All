package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNaturallineScrap extends Item {
  public static final Item block = new ItemNaturallineScrap();
    public ItemNaturallineScrap() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("naturalline_scrap");
      setRegistryName("naturalline_scrap");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
  }


