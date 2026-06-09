package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureZjarugothEntityIsHurt extends GctAllElement {
  public ProcedureZjarugothEntityIsHurt(GctAllContent instance) {
    super(instance, 79);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ZjarugothEntityIsHurt!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ZjarugothEntityIsHurt!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ZjarugothEntityIsHurt!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ZjarugothEntityIsHurt!");
      return;
    } 
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if (Math.random() < 0.02D && 
      !world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "effect @a[r=128] gct_all:stop 3 0 false"); 
  }
}

