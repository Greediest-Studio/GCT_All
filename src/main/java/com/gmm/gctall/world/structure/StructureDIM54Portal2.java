package com.gmm.gctall.world.structure;

import com.gmm.gctall.Tags;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class StructureDIM54Portal2 {
private static final int CHANCE_DENOMINATOR = 1_000_000;
  private static final String TEMPLATE_NAME = "54portal_2";
  private static final int DIMENSION_ID = 0;
  private static final int GENERATION_CHANCE = 0;
  public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimId, IChunkGenerator generator,
      IChunkProvider provider) {
    if (dimId != DIMENSION_ID || GENERATION_CHANCE <= 0
        || random.nextInt(CHANCE_DENOMINATOR) + 1 > GENERATION_CHANCE) {
      return;
    }

    int x = chunkX + random.nextInt(16) + 8;
    int z = chunkZ + random.nextInt(16) + 8;
    int y = StructureGenerationHelper.findSurfaceY(world, x, z, false);
    StructureGenerationHelper.placeTemplate(world, new ResourceLocation(Tags.MOD_ID, TEMPLATE_NAME), new BlockPos(x, y, z), Rotation.NONE, Mirror.NONE);
  }
}