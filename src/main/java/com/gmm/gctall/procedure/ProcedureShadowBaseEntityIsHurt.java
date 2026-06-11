package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureShadowBaseEntityIsHurt {
  private ProcedureShadowBaseEntityIsHurt() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ShadowBaseEntityIsHurt!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ShadowBaseEntityIsHurt!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ShadowBaseEntityIsHurt!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ShadowBaseEntityIsHurt!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
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

