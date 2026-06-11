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

public class ItemElfPasses extends Item {
  public static final Item block = new ItemElfPasses();
    public ItemElfPasses() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("elf_passes");
      setRegistryName("elf_passes");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }

    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u53F3\u952E\u7CBE\u7075\u53EF\u4EE5\u5F97\u5230\u81EA\u7136\u7ED3\u6676\u788E\u7247");
    }
  }


