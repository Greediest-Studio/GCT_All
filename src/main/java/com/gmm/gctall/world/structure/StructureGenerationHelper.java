package com.gmm.gctall.world.structure;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public final class StructureGenerationHelper {
  private static final Rotation[] ROTATIONS = { Rotation.NONE, Rotation.CLOCKWISE_90, Rotation.CLOCKWISE_180 };
  private static final Mirror[] MIRRORS = { Mirror.NONE, Mirror.LEFT_RIGHT };

  private StructureGenerationHelper() {}

  static int findSurfaceY(World world, int x, int z, boolean netherStyle) {
    if (netherStyle) {
      return findNetherSurfaceY(world, x, z);
    }

    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, 255, z);
    while (pos.getY() > 0 && !isSolid(world, pos)) {
      pos.setY(pos.getY() - 1);
    }
    return pos.getY() - 1;
  }

  public static boolean placeTemplate(World world, Random random, ResourceLocation templateId, BlockPos origin) {
    return placeTemplate(world, templateId, origin, randomRotation(random), randomMirror(random));
  }

  public static boolean placeTemplate(World world, ResourceLocation templateId, BlockPos origin, Rotation rotation, Mirror mirror) {
    if (world.isRemote || !(world instanceof WorldServer) || world.getMinecraftServer() == null) {
      return false;
    }
    Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), templateId);
    if (template == null) {
      return false;
    }

    IBlockState oldState = world.getBlockState(origin);
    world.notifyBlockUpdate(origin, oldState, oldState, 3);
    PlacementSettings settings = new PlacementSettings()
        .setRotation(rotation)
        .setMirror(mirror)
        .setChunk((ChunkPos)null)
        .setReplacedBlock((Block)null)
        .setIgnoreStructureBlock(false)
        .setIgnoreEntities(false);
    template.addBlocksToWorldChunk(world, origin, settings);
    return true;
  }

  private static int findNetherSurfaceY(World world, int x, int z) {
    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, 255, z);
    boolean foundAirPocket = false;
    while (pos.getY() > 0) {
      if (!foundAirPocket && !isSolid(world, pos)) {
        foundAirPocket = true;
      } else if (foundAirPocket && isSolid(world, pos)) {
        break;
      }
      pos.setY(pos.getY() - 1);
    }
    return pos.getY() - 1;
  }

  private static boolean isSolid(World world, BlockPos pos) {
    IBlockState state = world.getBlockState(pos);
    return !world.isAirBlock(pos) && state.getBlock().getMaterial(state).blocksMovement();
  }

  private static Rotation randomRotation(Random random) {
    return ROTATIONS[random.nextInt(ROTATIONS.length)];
  }

  private static Mirror randomMirror(Random random) {
    return MIRRORS[random.nextInt(MIRRORS.length)];
  }
}
