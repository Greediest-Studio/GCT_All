package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAncientMud extends Item {
  public static final Item block = new ItemAncientMud();
    public ItemAncientMud() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("ancientmud");
      setRegistryName("ancientmud");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("§e在灵神台座上右击以召唤远古修格斯");
    }
  }


