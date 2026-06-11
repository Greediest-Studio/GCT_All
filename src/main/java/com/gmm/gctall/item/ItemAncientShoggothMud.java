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

public class ItemAncientShoggothMud extends Item {
  public static final Item block = new ItemAncientShoggothMud();
    public ItemAncientShoggothMud() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("ancient_shoggoth_mud");
      setRegistryName("ancient_shoggoth_mud");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }

    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("§f在一只§c血红修格斯融合体§f面前击杀一只§c远古修格斯§f获得");
    }
  }


