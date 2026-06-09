package com.gmm.gctall.world.structure;

import com.gmm.gctall.Tags;

import java.util.Random;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public abstract class TemplateStructureElement extends GctAllElement {
  private static final int CHANCE_DENOMINATOR = 1_000_000;

  private final String templateName;
  private final int dimensionId;
  private final int chance;
  private final boolean netherPlacement;
  private final boolean randomTransform;

  protected TemplateStructureElement(GctAllContent elements, int sortId, String templateName, int dimensionId,
      int chance, boolean netherPlacement, boolean randomTransform) {
    super(elements, sortId);
    this.templateName = templateName;
    this.dimensionId = dimensionId;
    this.chance = chance;
    this.netherPlacement = netherPlacement;
    this.randomTransform = randomTransform;
  }

  @Override
  public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimId, IChunkGenerator generator,
      IChunkProvider provider) {
    if (dimId != dimensionId || random.nextInt(CHANCE_DENOMINATOR) + 1 > chance) {
      return;
    }

    int count = random.nextInt(1) + 1;
    for (int attempt = 0; attempt < count; attempt++) {
      int x = chunkX + random.nextInt(16) + 8;
      int z = chunkZ + random.nextInt(16) + 8;
      int y = findSurfaceY(world, x, z, netherPlacement) - 1;
      if (world.isRemote || !(world instanceof WorldServer)) {
        return;
      }

      WorldServer serverWorld = (WorldServer) world;
      Template template = serverWorld.getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
          new ResourceLocation(Tags.MOD_ID, templateName));
      if (template == null) {
        return;
      }

      Rotation rotation = randomTransform ? Rotation.values()[random.nextInt(3)] : Rotation.NONE;
      Mirror mirror = randomTransform ? Mirror.values()[random.nextInt(2)] : Mirror.NONE;
      BlockPos pos = new BlockPos(x, y, z);
      IBlockState state = world.getBlockState(pos);
      world.notifyBlockUpdate(pos, state, state, 3);
      template.addBlocksToWorldChunk(world, pos, new PlacementSettings()
          .setRotation(rotation)
          .setMirror(mirror)
          .setChunk((ChunkPos) null)
          .setReplacedBlock((Block) null)
          .setIgnoreStructureBlock(false)
          .setIgnoreEntities(false));
    }
  }

  private static int findSurfaceY(World world, int x, int z, boolean netherPlacement) {
    int y = world.getActualHeight() - 1;
    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);
    if (netherPlacement) {
      boolean foundAir = false;
      while (y > 0) {
        pos.setPos(x, y, z);
        boolean solid = world.getBlockState(pos).getMaterial().blocksMovement();
        if (!foundAir && !solid) {
          foundAir = true;
        } else if (foundAir && solid) {
          break;
        }
        y--;
      }
      return y;
    }

    while (y > 0) {
      pos.setPos(x, y, z);
      if (world.getBlockState(pos).getMaterial().blocksMovement()) {
        break;
      }
      y--;
    }
    return y;
  }
}

