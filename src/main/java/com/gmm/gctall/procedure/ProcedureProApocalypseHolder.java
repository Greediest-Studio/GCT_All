package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockApocalypseAltar;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProApocalypseHolder {
  private ProcedureProApocalypseHolder() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseHolder", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    entity.world.removeEntity(entity);
    world.setBlockState(new BlockPos(x, y, z), BlockApocalypseAltar.block.getDefaultState(), 3);
  }
}

