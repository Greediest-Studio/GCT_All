package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemShoggothTancale;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Tag
public class ProcedureDarkerLesserShoggothEntityDies extends GctAllElement {
  public ProcedureDarkerLesserShoggothEntityDies(GctAllContent instance) {
    super(instance, 24);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure DarkerLesserShoggothEntityDies!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure DarkerLesserShoggothEntityDies!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure DarkerLesserShoggothEntityDies!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure DarkerLesserShoggothEntityDies!");
      return;
    } 
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    if (Math.random() < 0.5D && 
      !world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemShoggothTancale.block, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    } 
  }
}

