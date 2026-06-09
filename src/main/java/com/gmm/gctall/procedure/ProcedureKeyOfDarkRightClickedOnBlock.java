package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.world.structure.PortalTemplateHelper;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureKeyOfDarkRightClickedOnBlock extends GctAllElement {
  public ProcedureKeyOfDarkRightClickedOnBlock(GctAllContent instance) {
    super(instance, 32);
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

