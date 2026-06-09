package com.gmm.gctall.registry;

import com.gmm.gctall.Tags;

import com.gmm.gctall.common.GctAllCreativeTab;
import com.gmm.gctall.block.BlockBaseOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public final class GctBasesBlocks {
  public static final BlockBaseOre NETHER_CHROMIUM_ORE = createOre(
      "nether_chromium_ore",
      3.5F,
      15.0F,
      GctAllCreativeTab.TAB
  );

  public static final BlockBaseOre END_CHROMIUM_ORE = createOre(
      "end_chromium_ore",
      3.5F,
      15.0F,
      GctAllCreativeTab.TAB
  );

  public static final BlockBaseOre END_MANGANESE_ORE = createOre(
      "end_manganese_ore",
      4.5F,
      200.0F,
      GctAllCreativeTab.TAB
  );

  public static final BlockBaseOre NETHER_MANGANESE_ORE = createOre(
      "nether_manganese_ore",
      4.5F,
      200.0F,
      GctAllCreativeTab.TAB
  );

  private static final BlockBaseOre[] ORES = {
      NETHER_CHROMIUM_ORE,
      END_CHROMIUM_ORE,
      END_MANGANESE_ORE,
      NETHER_MANGANESE_ORE
  };

  private GctBasesBlocks() {}

  public static void registerBlocks(IForgeRegistry<Block> registry) {
    registry.registerAll(ORES);
  }

  public static void registerItems(IForgeRegistry<Item> registry) {
    for (BlockBaseOre ore : ORES) {
      registry.register(createItemBlock(ore));
    }
  }

  private static BlockBaseOre createOre(String name, float hardness, float resistance, net.minecraft.creativetab.CreativeTabs tab) {
    ResourceLocation registryName = new ResourceLocation(Tags.MOD_ID, name);
    BlockBaseOre ore = new BlockBaseOre(hardness, resistance, tab);
    ore.setRegistryName(registryName);
    ore.setTranslationKey(name);
    return ore;
  }

  private static ItemBlock createItemBlock(Block block) {
    return (ItemBlock) new ItemBlock(block)
        .setRegistryName(block.getRegistryName());
  }

  public static BlockBaseOre[] getOres() {
    return ORES.clone();
  }
}
