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
public class ItemRemnantCookie extends GctAllElement {
  @ObjectHolder("gct_all:remnant_cookie")
  public static final Item block = null;
  
  public ItemRemnantCookie(GctAllContent instance) {
    super(instance, 111);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "remnant_cookie");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("remnant_cookie", 3, 0.1F, false);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
  }
}

