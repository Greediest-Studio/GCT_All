package com.gmm.gctall.item;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemMuddyFlesh extends GctAllElement {
  @ObjectHolder("gct_all:muddy_flesh")
  public static final Item block = null;
  
  public ItemMuddyFlesh(GctAllContent instance) {
    super(instance, 115);
  }
  
  public void initElements() {
    registerItem(ItemFoodCustom::new, "muddy_flesh");
  }
  
  
  public static class ItemFoodCustom extends GctAllFoodItem {
    public ItemFoodCustom() {
      super("muddy_flesh", 3, 0.1F, true);
    }
  }
}

