package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockBesideVoidPortal1;
import com.gmm.gctall.block.BlockBesideVoidPortal2;
import com.gmm.gctall.block.BlockBesideVoidPortal3;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureProBesideVoidPortalDestroy2 extends GctAllElement {
  public ProcedureProBesideVoidPortalDestroy2(GctAllContent instance) {
    super(instance, 156);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidPortalDestroy2", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x + 0, y + 3, z + 0)).getBlock() == BlockBesideVoidPortal1.block
      .getDefaultState().getBlock() || world
      .getBlockState(new BlockPos(x + 0, y + 2, z + 0)).getBlock() == BlockBesideVoidPortal2.block
      .getDefaultState().getBlock() || world
      .getBlockState(new BlockPos(x + 0, y + 1, z + 0)).getBlock() == BlockBesideVoidPortal3.block
      .getDefaultState().getBlock()) {
      world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x, y + 3, z), Blocks.AIR.getDefaultState(), 3);
      if (!world.isRemote)
        world.createExplosion(null, x, y, z, 4.0F, true); 
      for (int i = 0; i < 4; i++)
        ServerCommandHelper.run(world, x, y, z, "summon thaumcraft:cultistcleric ~ ~1 ~"); 
    } 
  }
}

