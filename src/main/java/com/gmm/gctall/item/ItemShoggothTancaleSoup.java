package com.gmm.gctall.item;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class ItemShoggothTancaleSoup extends GctAllElement {
  @ObjectHolder("gct_all:shoggoth_tancale_soup")
  public static final Item block = null;
  
  public ItemShoggothTancaleSoup(GctAllContent instance) {
    super(instance, 108);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "shoggoth_tancale_soup");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("shoggoth_tancale_soup", 12, 0.5F, false);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
  }
}

