package com.gmm.gctall.world.structure;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldAlfheim;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

@Tag
public class StructureReversedDungeon extends GctAllElement {
  public StructureReversedDungeon(GctAllContent instance) {
    super(instance, 304);
  }
  
  public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
    if (dimID != WorldAlfheim.DIMID)
      return; 
    if (random.nextInt(1000000) + 1 <= 5000) {
      int count = random.nextInt(1) + 1;
      for (int a = 0; a < count; a++) {
        int i = i2 + random.nextInt(16) + 8;
        int k = k2 + random.nextInt(16) + 8;
        int j = StructureGenerationHelper.findSurfaceY(world, i, k, false);
        Biome biome = world.getBiome(new BlockPos(i, j, k));
        if ((new ResourceLocation("gct_all:reversed_forest")).equals(Biome.REGISTRY.getNameForObject(biome)))
          StructureGenerationHelper.placeTemplate(world, new ResourceLocation("gct_all", "reversed_dungeon"), new BlockPos(i, j - 50, k), Rotation.NONE, Mirror.NONE); 
      } 
    } 
  }
}

