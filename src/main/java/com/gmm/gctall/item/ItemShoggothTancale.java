package com.gmm.gctall.item;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemShoggothTancale extends GctAllElement {
  @ObjectHolder("gct_all:shoggothtancale")
  public static final Item block = null;
  
  public ItemShoggothTancale(GctAllContent instance) {
    super(instance, 20);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "shoggothtancale");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("shoggothtancale", 3, 0.1F, false);
    }
  }
}

