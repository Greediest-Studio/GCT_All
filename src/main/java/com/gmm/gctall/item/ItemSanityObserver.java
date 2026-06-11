package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSanityObserver extends Item {
  public static final Item block = new ItemSanityObserver();
    public ItemSanityObserver() {
      setMaxDamage(0);
      this.maxStackSize = 1;
      setTranslationKey("sanity_observer");
      setRegistryName("sanity_observer");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u63A2\u6D4B\u5F53\u524DSan\u503C");
    }
  }


