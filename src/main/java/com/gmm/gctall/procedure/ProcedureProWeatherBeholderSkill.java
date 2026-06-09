package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.world.World;

@Tag
public class ProcedureProWeatherBeholderSkill extends GctAllElement {
  public ProcedureProWeatherBeholderSkill(GctAllContent instance) {
    super(instance, 198);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProWeatherBeholderSkill", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.rand.nextDouble() < 0.008D) {
      ServerCommandHelper.run(world, x, y, z, "summon gct_all:weather_water_rod ~ ~ ~");
      ServerCommandHelper.run(world, x, y, z, "summon gct_all:weather_water_rod ~ ~ ~");
    } 
    if (world.rand.nextDouble() < 0.005D)
      ServerCommandHelper.run(world, x, y, z, "effect @p[r=32] twilightforest:frosty 3 6"); 
    if (world.rand.nextDouble() < 0.005D)
      ServerCommandHelper.run(world, x, y, z, "effect @p[r=32] twilightforest:frosty 20 0"); 
  }
}

