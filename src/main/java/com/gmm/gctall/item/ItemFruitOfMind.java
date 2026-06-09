package com.gmm.gctall.item;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemFruitOfMind extends GctAllElement {
  @ObjectHolder("gct_all:fruit_of_mind")
  public static final Item block = null;
  
  public ItemFruitOfMind(GctAllContent instance) {
    super(instance, 103);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "fruit_of_mind");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("fruit_of_mind", 4, 0.3F, false);
    }
  }
}

