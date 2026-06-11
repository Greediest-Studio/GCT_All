package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemApocalypsiumScrap extends Item {
  public static final Item block = new ItemApocalypsiumScrap();
    public ItemApocalypsiumScrap() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("apocalypsium_scrap");
      setRegistryName("apocalypsium_scrap");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
}


