package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

@Tag
public class ProcedureNyralathotepiumOreComplexBlockDestroyedByPlayer extends GctAllElement {
  public ProcedureNyralathotepiumOreComplexBlockDestroyedByPlayer(GctAllContent instance) {
    super(instance, 41);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure NyralathotepiumOreComplexBlockDestroyedByPlayer!");
      return;
    } 
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure NyralathotepiumOreComplexBlockDestroyedByPlayer!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure NyralathotepiumOreComplexBlockDestroyedByPlayer!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure NyralathotepiumOreComplexBlockDestroyedByPlayer!");
      return;
    } 
    Entity entity = (Entity)dependencies.get("entity");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    if (Math.random() < 0.6D && 
      entity instanceof EntityPlayer)
      ((EntityPlayer)entity).setSpawnPoint(new BlockPos((int)((x - 3) + 6.0D * Math.random()), (int)((y - 3) + 6.0D * Math.random()), 
            (int)((z - 3) + 6.0D * Math.random())), true); 
  }
}

