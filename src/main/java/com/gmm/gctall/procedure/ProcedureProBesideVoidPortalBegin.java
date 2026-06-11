package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockArcaneVisReceiver;
import com.gmm.gctall.block.BlockBesideVoidPortal1;
import com.gmm.gctall.block.BlockBesideVoidPortal2;
import com.gmm.gctall.block.BlockBesideVoidPortal3;
import com.gmm.gctall.block.BlockPrimordialPortalHolder2;
import com.gmm.gctall.block.BlockPrimordialStone;
import com.gmm.gctall.block.BlockPrimordialVisReceiver;
import com.gmm.gctall.block.BlockRuinHolder;
import com.gmm.gctall.block.BlockVoidSeedContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProBesideVoidPortalBegin {
  private ProcedureProBesideVoidPortalBegin() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidPortalBegin", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    ItemStack pickaxe = ItemStack.EMPTY;
    boolean LaunchStatus = false;
    double EnchtSize = 0.0D;
    double i = 0.0D;
    double j = 0.0D;
    double k = 0.0D;
    double RandomZ = 0.0D;
    double RandomX = 0.0D;
    double Y = 0.0D;
    if (world.getBlockState(new BlockPos(x + 0, y - 1, z + 0)).getBlock() == BlockPrimordialVisReceiver.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z + 0)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 2, y - 1, z + 0)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 3, y - 1, z + 0))
      .getBlock() == BlockArcaneVisReceiver.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z + 0)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 2, y - 1, z + 0)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 3, y - 1, z + 0))
      .getBlock() == BlockArcaneVisReceiver.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 1))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 2)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 3))
      .getBlock() == BlockArcaneVisReceiver.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z - 1)).getBlock() == BlockPrimordialStone.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z - 2))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z - 3))
      .getBlock() == BlockArcaneVisReceiver.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 3, y + 0, z + 0))
      .getBlock() == BlockRuinHolder.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 3, y + 0, z + 0))
      .getBlock() == BlockRuinHolder.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 0, z + 3))
      .getBlock() == BlockRuinHolder.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 0, z - 3)).getBlock() == BlockRuinHolder.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 3, y + 1, z + 0))
      .getBlock() == BlockVoidSeedContainer.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 3, y + 1, z + 0))
      .getBlock() == BlockVoidSeedContainer.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 1, z + 3))
      .getBlock() == BlockVoidSeedContainer.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 1, z - 3))
      .getBlock() == BlockVoidSeedContainer.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z + 1))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z - 1))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z + 1))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z - 1))
      .getBlock() == BlockPrimordialStone.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 4, z + 0))
      .getBlock() == BlockPrimordialPortalHolder2.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 3, z + 0)).getBlock() == Blocks.AIR
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 2, z + 0)).getBlock() == Blocks.AIR
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 1, z + 0)).getBlock() == Blocks.AIR
      .getDefaultState().getBlock()) {
      world.setBlockState(new BlockPos(x, y + 3, z), BlockBesideVoidPortal1.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x, y + 2, z), BlockBesideVoidPortal2.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x, y + 1, z), BlockBesideVoidPortal3.block.getDefaultState(), 3);
    }
  }
}

