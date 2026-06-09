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
public class ItemSaniteSiphon extends GctAllElement {
  @ObjectHolder("gct_all:sanite_siphon")
  public static final Item block = null;
  
  public ItemSaniteSiphon(GctAllContent instance) {
    super(instance, 99);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "sanite_siphon");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(100);
      this.maxStackSize = 1;
      setTranslationKey("sanite_siphon");
      setRegistryName("sanite_siphon");
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
      list.add("\u00A7c\u7528\u4E8E\u91C7\u96C6\u4FEE\u683C\u65AF\u8F6F\u6CE5");
    }
  }
}

