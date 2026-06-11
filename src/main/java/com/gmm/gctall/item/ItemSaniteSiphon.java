package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSaniteSiphon extends Item {
  public static final Item block = new ItemSaniteSiphon();
    public ItemSaniteSiphon() {
      setMaxDamage(100);
      this.maxStackSize = 1;
      setTranslationKey("sanite_siphon");
      setRegistryName("sanite_siphon");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7c\u7528\u4E8E\u91C7\u96C6\u4FEE\u683C\u65AF\u8F6F\u6CE5");
    }
  }


