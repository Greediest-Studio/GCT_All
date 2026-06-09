package com.gmm.gctall.world.structure;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldEverheaven;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

@Tag
public class StructureHeavenStonePostSmall2 extends GctAllElement {
  public StructureHeavenStonePostSmall2(GctAllContent instance) {
    super(instance, 220);
  }
  
  public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
    if (dimID != WorldEverheaven.DIMID)
      return; 
    if (random.nextInt(1000000) + 1 <= 500000) {
      int count = random.nextInt(4) + 1;
      for (int a = 0; a < count; a++) {
        int i = i2 + random.nextInt(16) + 8;
        int k = k2 + random.nextInt(16) + 8;
        int j = StructureGenerationHelper.findSurfaceY(world, i, k, false);
        StructureGenerationHelper.placeTemplate(world, random, new ResourceLocation("gct_all", "small_stonepost2"), new BlockPos(i, j, k));
      } 
    } 
  }
}

