package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.world.structure.PortalTemplateHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureKeyOfDarkRightClickedOnBlock {
  private ProcedureKeyOfDarkRightClickedOnBlock() {
  }

  public static boolean executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "KeyOfDarkRightClickedOnBlock", "entity", "x", "y", "z", "world"))
      return false;
    Entity entity = ProcedureContext.entity(dependencies);
    World world = ProcedureContext.world(dependencies);
    BlockPos pos = ProcedureContext.blockPos(dependencies);
    return PortalTemplateHelper.placeFacingPortal(world, entity, pos, "54portal_1", "54portal_2");
  }
}

