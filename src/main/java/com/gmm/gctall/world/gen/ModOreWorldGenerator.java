package com.gmm.gctall.world.gen;

import com.google.common.base.Predicate;
import com.gmm.gctall.registry.GctBasesBlocks;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public final class ModOreWorldGenerator implements IWorldGenerator {
  private static final OreGenConfig[] ORES = {
      new OreGenConfig(GctBasesBlocks.NETHER_CHROMIUM_ORE, Blocks.NETHERRACK, -1, 2, 4, 127),
      new OreGenConfig(GctBasesBlocks.END_CHROMIUM_ORE, Blocks.END_STONE, 1, 2, 4, 127),
      new OreGenConfig(GctBasesBlocks.END_MANGANESE_ORE, Blocks.END_STONE, 1, 4, 3, 128),
      new OreGenConfig(GctBasesBlocks.NETHER_MANGANESE_ORE, Blocks.NETHERRACK, -1, 4, 3, 128)
  };

  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    int dimension = world.provider.getDimension();
    int blockX = chunkX * 16;
    int blockZ = chunkZ * 16;

    for (OreGenConfig ore : ORES) {
      if (ore.dimension == dimension) {
        ore.generate(world, random, blockX, blockZ);
      }
    }
  }

  private static final class OreGenConfig {
    private final Block ore;
    private final int dimension;
    private final int attemptsPerChunk;
    private final int veinSize;
    private final int maxYExclusive;
    private final Predicate<IBlockState> replaceableBlock;

    private OreGenConfig(Block ore, Block baseBlock, int dimension, int attemptsPerChunk, int veinSize, int maxYExclusive) {
      this.ore = ore;
      this.dimension = dimension;
      this.attemptsPerChunk = attemptsPerChunk;
      this.veinSize = veinSize;
      this.maxYExclusive = maxYExclusive;
      this.replaceableBlock = state -> state != null && state.getBlock() == baseBlock;
    }

    private void generate(World world, Random random, int chunkX, int chunkZ) {
      WorldGenMinable generator = new WorldGenMinable(ore.getDefaultState(), veinSize, replaceableBlock);

      for (int i = 0; i < attemptsPerChunk; i++) {
        int x = chunkX + random.nextInt(16);
        int y = random.nextInt(maxYExclusive);
        int z = chunkZ + random.nextInt(16);
        generator.generate(world, random, new BlockPos(x, y, z));
      }
    }
  }
}
