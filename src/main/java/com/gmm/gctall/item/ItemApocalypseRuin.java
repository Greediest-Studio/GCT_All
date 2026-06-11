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

public class ItemApocalypseRuin extends Item {
  public static final Item block = new ItemApocalypseRuin();
    public ItemApocalypseRuin() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("apocalypse_ruin");
      setRegistryName("apocalypse_ruin");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }

    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u53F3\u952E\u5929\u542F\u796D\u575B\u4EE5\u53EC\u5524\u5929\u542F\u9A91\u58EB");
    }
  }


