package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProWeatherBeholderSkill {
  private ProcedureProWeatherBeholderSkill() {
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
    Potion frosty = Potion.REGISTRY.getObject(new ResourceLocation("twilightforest", "frosty"));
    if (world.rand.nextDouble() < 0.005D)
      ProcedureEffectHelper.addEffect(ProcedureEffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 32.0D), frosty, 60, 6, false, true);
    if (world.rand.nextDouble() < 0.005D)
      ProcedureEffectHelper.addEffect(ProcedureEffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 32.0D), frosty, 400, 0, false, true);
  }
}

