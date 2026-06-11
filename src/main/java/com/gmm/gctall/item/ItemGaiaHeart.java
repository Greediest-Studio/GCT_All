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

public class ItemGaiaHeart extends Item {
  public static final Item block = new ItemGaiaHeart();
    public ItemGaiaHeart() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("gaia_heart");
      setRegistryName("gaia_heart");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }

    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7b\u57282000\u96BE\u5EA6\u4EE5\u4E0A\u51FB\u6740\u76D6\u4E9A\u5B88\u62A4\u8005III\u6389\u843D");
    }
  }


