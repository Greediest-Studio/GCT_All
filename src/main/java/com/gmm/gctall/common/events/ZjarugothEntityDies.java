package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ZjarugothEntityDies {
  private ZjarugothEntityDies() {
  }

  public static void run(World world, int x, int y, int z) {
    if (!world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>不好意思，我似乎不是一个合格的旧日支配者。\"}]");
  }
}

