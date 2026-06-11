package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulStealerScroll extends Item {
  public static final Item block = new ItemSoulStealerScroll();
    public ItemSoulStealerScroll() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("soul_stealer_scroll");
      setRegistryName("soul_stealer_scroll");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7c\u4F3C\u4E4E\u662F\u67D0\u4F4D\u795E\u660E\u7559\u4E0B\u7684\u9057\u7269\uFF1F");
    }
  }


