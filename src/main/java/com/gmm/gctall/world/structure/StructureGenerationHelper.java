package com.gmm.gctall.world.structure;

import java.util.Random;
import javax.annotation.Nullable;
import com.gmm.gctall.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.BlockRotationProcessor;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

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

  public static boolean placeTemplate(World world, String templateName, BlockPos origin, Rotation rotation, Mirror mirror) {
    return placeTemplate(world, new ResourceLocation(Tags.MOD_ID, templateName), origin, rotation, mirror);
  }

  public static boolean placeTemplate(World world, ResourceLocation templateId, BlockPos origin, Rotation rotation, Mirror mirror) {
    if (world.isRemote || !(world instanceof WorldServer) || world.getMinecraftServer() == null) {
      return false;
    }
    Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), templateId);
    if (template == null) {
      return false;
    }

    PlacementSettings settings = new PlacementSettings()
        .setRotation(rotation)
        .setMirror(mirror)
        .setChunk((ChunkPos)null)
        .setReplacedBlock((Block)null)
        .setIgnoreStructureBlock(false)
        .setIgnoreEntities(false);
    addTemplateBlocks(world, template, origin, settings);
    return true;
  }

  private static void addTemplateBlocks(World world, Template template, BlockPos origin, PlacementSettings settings) {
    IBlockState oldState = world.getBlockState(origin);
    world.notifyBlockUpdate(origin, oldState, oldState, 3);
    template.addBlocksToWorld(world, origin, new OptionalExternalBlockProcessor(origin, settings), settings, 2);
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

  private static final class OptionalExternalBlockProcessor implements ITemplateProcessor {
    private final BlockRotationProcessor rotationProcessor;

    private OptionalExternalBlockProcessor(BlockPos origin, PlacementSettings settings) {
      this.rotationProcessor = new BlockRotationProcessor(origin, settings);
    }

    @Nullable
    public Template.BlockInfo processBlock(World world, BlockPos pos, Template.BlockInfo blockInfo) {
      Template.BlockInfo rotated = this.rotationProcessor.processBlock(world, pos, blockInfo);
      if (rotated == null || shouldPlace(rotated.blockState.getBlock())) {
        return rotated;
      }
      return new Template.BlockInfo(rotated.pos, Blocks.AIR.getDefaultState(), null);
    }

    private boolean shouldPlace(Block block) {
      ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);
      if (id == null) {
        return true;
      }
      String namespace = id.getNamespace();
      return "minecraft".equals(namespace) || Tags.MOD_ID.equals(namespace) || Loader.isModLoaded(namespace);
    }
  }
}
