package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureAbyssPlagueOnEntityTickUpdate extends GctAllElement {
  public ProcedureAbyssPlagueOnEntityTickUpdate(GctAllContent instance) {
    super(instance, 9);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    } 
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    double timer = 0.0D;
    boolean power = false;
    if (Math.random() < 0.004D && 
      !world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "effect @p[r=32] gct_all:abyssplague 10 0"); 
    if (Math.random() < 0.005D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=10] [\"\",{\"text\":\"\u545C\u554A\u554A\uFF01\"}] "); 
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "effect @p[r=10] instant_damage 1 3"); 
    } 
  }
}

