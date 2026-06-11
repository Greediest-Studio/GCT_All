package com.gmm.gctall.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public final class GctBasesBlocks {
  private static final Block[] ORES = {};

  private GctBasesBlocks() {}

  public static void registerBlocks(IForgeRegistry<Block> registry) {
  }

  public static void registerItems(IForgeRegistry<Item> registry) {
  }

  public static Block[] getOres() {
    return ORES.clone();
  }
}
