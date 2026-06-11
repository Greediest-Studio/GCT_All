package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemKeyOfWarped extends Item {
  public static final Item block = new ItemKeyOfWarped();
    public ItemKeyOfWarped() {
      setMaxDamage(0);
      this.maxStackSize = 1;
      setTranslationKey("key_of_warped");
      setRegistryName("key_of_warped");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("§2似乎不能正常使用");
    }
  }


