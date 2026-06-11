package com.gmm.gctall.world.structure;

import com.gmm.gctall.Tags;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class StructureSeekAltarStructure {
private static final int CHANCE_DENOMINATOR = 1_000_000;
  private static final String TEMPLATE_NAME = "seek_altar";
  private static final int DIMENSION_ID = WorldWarpedRuin.DIMID;
  private static final int GENERATION_CHANCE = 3000;
  public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimId, IChunkGenerator generator,
      IChunkProvider provider) {
    if (dimId != DIMENSION_ID || GENERATION_CHANCE <= 0
        || random.nextInt(CHANCE_DENOMINATOR) + 1 > GENERATION_CHANCE) {
      return;
    }

    int x = chunkX + random.nextInt(16) + 8;
    int z = chunkZ + random.nextInt(16) + 8;
    int y = StructureGenerationHelper.findSurfaceY(world, x, z, false);
    StructureGenerationHelper.placeTemplate(world, random, new ResourceLocation(Tags.MOD_ID, TEMPLATE_NAME), new BlockPos(x, y, z));
  }
}