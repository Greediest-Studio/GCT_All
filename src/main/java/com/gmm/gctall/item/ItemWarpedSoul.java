package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWarpedSoul extends Item {
  public static final Item block = new ItemWarpedSoul();
    public ItemWarpedSoul() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("warped_soul");
      setRegistryName("warped_soul");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("§f扭曲遗址内不屈的冤魂");
    }
  }


