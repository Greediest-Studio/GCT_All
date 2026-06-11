package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShoggothSlimeball extends Item {
  public static final Item block = new ItemShoggothSlimeball();
    public ItemShoggothSlimeball() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("shoggoth_slimeball");
      setRegistryName("shoggoth_slimeball");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7f\u54D5\uFF0C\u771F\u6076\u5FC3\u3002");
    }
  }


