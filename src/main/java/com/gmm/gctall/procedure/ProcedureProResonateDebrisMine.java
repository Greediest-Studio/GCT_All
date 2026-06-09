package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockResonateDebris;
import com.gmm.gctall.item.ItemResonatedScrap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Tag
public class ProcedureProResonateDebrisMine extends GctAllElement {
  public ProcedureProResonateDebrisMine(GctAllContent instance) {
    super(instance, 360);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProResonateDebrisMine", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
      .canHarvestBlock(BlockResonateDebris.block.getDefaultState())) {
      if (!world.isRemote)
        for (int i = 0; i < 2; i++) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemResonatedScrap.block, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      }
      if (!world.isRemote)
        world.spawnEntity((Entity)new EntityXPOrb(world, x, y, z, 30 + world.rand.nextInt(15))); 
    } 
  }
}

