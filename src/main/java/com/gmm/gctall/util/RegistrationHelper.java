package com.gmm.gctall.util;

import com.gmm.gctall.Tags;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class RegistrationHelper {
  private RegistrationHelper() {}

  public static Item itemBlock(Block block) {
    return new ItemBlock(block).setRegistryName(block.getRegistryName());
  }

  @SideOnly(Side.CLIENT)
  public static void registerBlockItemModel(Block block, String modelName) {
    registerItemModel(Item.getItemFromBlock(block), modelName);
  }

  @SideOnly(Side.CLIENT)
  public static void registerItemModel(Item item, String modelName) {
    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Tags.MOD_ID + ":" + modelName, "inventory"));
  }
}
