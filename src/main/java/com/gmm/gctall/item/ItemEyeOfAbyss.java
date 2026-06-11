package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEyeOfAbyss extends Item {
  public static final Item block = new ItemEyeOfAbyss();
    public ItemEyeOfAbyss() {
      setMaxDamage(0);
      this.maxStackSize = 1;
      setTranslationKey("eye_of_abyss");
      setRegistryName("eye_of_abyss");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u5F53\u4F60\u5728\u51DD\u89C6\u6DF1\u6E0A\u7684\u65F6\u5019\uFF0C\u6DF1\u6E0A\u4E5F\u5728\u51DD\u89C6\u7740\u4F60\u3002");
    }
  }


