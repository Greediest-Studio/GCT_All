package com.gmm.gctall.common.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ServerCommands {
  private ServerCommands() {}

  public static void run(World world, int x, int y, int z, String command) {
    ServerCommandHelper.run(world, new BlockPos(x, y, z), command);
  }
}
