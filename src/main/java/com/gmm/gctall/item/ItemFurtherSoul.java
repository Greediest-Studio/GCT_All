package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFurtherSoul extends Item {
  public static final Item block = new ItemFurtherSoul();
    public ItemFurtherSoul() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("further_soul");
      setRegistryName("further_soul");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }

    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7b\u6765\u81EA\u9065\u8FDC\u7684\u8BB0\u5FC6\u3002");
    }
  }


