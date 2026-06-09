package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemEyeOfAbyss extends GctAllElement {
  @ObjectHolder("gct_all:eye_of_abyss")
  public static final Item block = null;
  
  public ItemEyeOfAbyss(GctAllContent instance) {
    super(instance, 101);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "eye_of_abyss");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 1;
      setTranslationKey("eye_of_abyss");
      setRegistryName("eye_of_abyss");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public int getItemEnchantability() {
      return 0;
    }
    
    public int getMaxItemUseDuration(ItemStack itemstack) {
      return 0;
    }
    
    public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
      return 1.0F;
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u5F53\u4F60\u5728\u51DD\u89C6\u6DF1\u6E0A\u7684\u65F6\u5019\uFF0C\u6DF1\u6E0A\u4E5F\u5728\u51DD\u89C6\u7740\u4F60\u3002");
    }
  }
}

