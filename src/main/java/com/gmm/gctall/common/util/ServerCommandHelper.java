package com.gmm.gctall.common.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ServerCommandHelper {
  private ServerCommandHelper() {}

  public static void run(World world, BlockPos pos, String command) {
    if (world.isRemote || world.getMinecraftServer() == null) {
      return;
    }
    world.getMinecraftServer().getCommandManager().executeCommand(new SilentCommandSender(world, pos), command);
  }

  public static void run(World world, int x, int y, int z, String command) {
    run(world, new BlockPos(x, y, z), command);
  }
}
