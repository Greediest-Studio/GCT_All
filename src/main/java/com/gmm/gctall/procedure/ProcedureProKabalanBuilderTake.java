package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureProKabalanBuilderTake extends GctAllElement {
  public ProcedureProKabalanBuilderTake(GctAllContent instance) {
    super(instance, 268);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
  }
}

