package com.gmm.gctall.procedure;

import java.util.Map;
import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemApocalypsiumScrap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Tag
public class ProcedureProApocalypseDeath extends GctAllElement {
  public ProcedureProApocalypseDeath(GctAllContent instance) {
    super(instance, 108);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseDeath", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    for (int index0 = 0; index0 < (new Random()).nextInt(16) + 10; index0++) {
      if (!world.isRemote) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemApocalypsiumScrap.block, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      } 
    } 
  }
}

