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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class ItemAncientShoggothMud extends GctAllElement {
  @ObjectHolder("gct_all:ancient_shoggoth_mud")
  public static final Item block = null;
  
  public ItemAncientShoggothMud(GctAllContent instance) {
    super(instance, 120);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "ancient_shoggoth_mud");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("ancient_shoggoth_mud");
      setRegistryName("ancient_shoggoth_mud");
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
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7f\u5728\u4E00\u53EA\u00A7c\u8840\u7EA2\u4FEE\u683C\u65AF\u878D\u5408\u4F53\u00A7f\u9762\u524D\u51FB\u6740\u4E00\u53EA\u00A7c\u8FDC\u53E4\u4FEE\u683C\u65AF\u00A7f\u83B7\u5F97");
    }
  }
}

