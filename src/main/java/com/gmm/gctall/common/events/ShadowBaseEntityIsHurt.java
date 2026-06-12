package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ShadowBaseEntityIsHurt {
  private ShadowBaseEntityIsHurt() {
  }

  public static void run(World world, int x, int y, int z) {
    if (Math.random() < 0.7D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "summon abyssalcraft:shadowcreature ~ ~1 ~");
    } else if (Math.random() < 0.7D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "summon abyssalcraft:shadowmonster ~ ~1 ~");
    } else if (!world.isRemote && world.getMinecraftServer() != null) {
      ServerCommands.run(world, x, y, z, "summon abyssalcraft:shadowbeast ~ ~1 ~");
    }
  }
}

