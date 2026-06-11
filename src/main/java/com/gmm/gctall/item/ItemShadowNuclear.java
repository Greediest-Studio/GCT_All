package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShadowNuclear extends Item {
  public static final Item block = new ItemShadowNuclear();
    public ItemShadowNuclear() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("shadownuclear");
      setRegistryName("shadownuclear");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("§4似乎是阴影怪物产生的源泉？");
    }
  }


