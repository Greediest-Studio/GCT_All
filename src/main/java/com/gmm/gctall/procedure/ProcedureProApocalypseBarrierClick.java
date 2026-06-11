package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.item.ItemApocalypseRuin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProApocalypseBarrierClick {
  private ProcedureProApocalypseBarrierClick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseBarrierClick", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
      .getItem() == (new ItemStack(ItemApocalypseRuin.block, 1)).getItem())
      world.setBlockToAir(new BlockPos(x, y, z));
  }
}

