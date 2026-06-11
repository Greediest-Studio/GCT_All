package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureZjarugothEntityDies {
  private ProcedureZjarugothEntityDies() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ZjarugothEntityDies!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ZjarugothEntityDies!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ZjarugothEntityDies!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ZjarugothEntityDies!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if (!world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>不好意思，我似乎不是一个合格的旧日支配者。\"}]");
  }
}

