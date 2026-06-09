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
public class ItemFruitOfMindEnchanted extends GctAllElement {
  @ObjectHolder("gct_all:fruit_of_mind_enchanted")
  public static final Item block = null;
  
  public ItemFruitOfMindEnchanted(GctAllContent instance) {
    super(instance, 112);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "fruit_of_mind_enchanted");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("fruit_of_mind_enchanted", 4, 0.8F, false);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
  }
}

