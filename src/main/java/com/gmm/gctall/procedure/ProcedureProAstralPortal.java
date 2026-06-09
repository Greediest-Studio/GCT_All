package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockAstralPortalCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureProAstralPortal extends GctAllElement {
  public ProcedureProAstralPortal(GctAllContent instance) {
    super(instance, 315);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProAstralPortal", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    final World world = ProcedureContext.world(dependencies);
    if ((new Object() {
        public String getValue(BlockPos pos, String tag) {
          TileEntity tileEntity = world.getTileEntity(pos);
          if (tileEntity != null)
            return tileEntity.getTileData().getString(tag); 
          return "";
        }
      }).getValue(new BlockPos(x, y, z), "recipeLogic").equals("{}"))
      world.setBlockState(new BlockPos(x, y + 4, z), BlockAstralPortalCore.block.getDefaultState(), 3); 
  }
}

