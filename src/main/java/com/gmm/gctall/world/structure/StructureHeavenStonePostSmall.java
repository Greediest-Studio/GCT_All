package com.gmm.gctall.world.structure;

import java.util.Random;
import com.gmm.gctall.world.dimension.WorldEverheaven;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class StructureHeavenStonePostSmall {
public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
    if (dimID != WorldEverheaven.DIMID)
      return;
    if (random.nextInt(1000000) + 1 <= 500000) {
      int count = random.nextInt(4) + 1;
      for (int a = 0; a < count; a++) {
        int i = i2 + random.nextInt(16) + 8;
        int k = k2 + random.nextInt(16) + 8;
        int j = StructureGenerationHelper.findSurfaceY(world, i, k, false);
        StructureGenerationHelper.placeTemplate(world, random, new ResourceLocation("gct_all", "small_stonepost1"), new BlockPos(i, j, k));
      }
    }
  }
}

