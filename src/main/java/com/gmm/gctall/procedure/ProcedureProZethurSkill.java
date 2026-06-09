package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.world.World;

@Tag
public class ProcedureProZethurSkill extends GctAllElement {
  public ProcedureProZethurSkill(GctAllContent instance) {
    super(instance, 192);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProZethurSkill", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    ServerCommandHelper.run(world, x, y, z, "weather thunder");
    ServerCommandHelper.run(world, x, y, z, "effect @e[type=aether_legacy:zephyr, r=64] resistance 15 2");
    ServerCommandHelper.run(world, x, y, z, "effect @e[type=aether_legacy:zephyr, r=64] regeneration 15 0");
    if (world.rand.nextDouble() < 0.003D)
      ServerCommandHelper.run(world, x, y, z, "tp @a[r=16] ~ ~12 ~"); 
    if (world.rand.nextDouble() < 0.02D)
      ServerCommandHelper.run(world, x, y, z, "tp @a[r=4] ~ -32 ~"); 
    if (world.rand.nextDouble() < 0.001D)
      ServerCommandHelper.run(world, x, y, z, "effect @a[r=64] gct_all:channeling 10 0"); 
    if (world.rand.nextDouble() < 5.0E-4D) {
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~ ~-3 ~");
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~5 ~ ~");
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~-5 ~ ~");
    }
  }
}

