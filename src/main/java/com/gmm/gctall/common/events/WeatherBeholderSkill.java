package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class WeatherBeholderSkill {
  private WeatherBeholderSkill() {
  }

  public static void run(World world, int x, int y, int z) {
    if (world.rand.nextDouble() < 0.008D) {
      ServerCommandHelper.run(world, x, y, z, "summon gct_all:weather_water_rod ~ ~ ~");
      ServerCommandHelper.run(world, x, y, z, "summon gct_all:weather_water_rod ~ ~ ~");
    }
    Potion frosty = Potion.REGISTRY.getObject(new ResourceLocation("twilightforest", "frosty"));
    if (world.rand.nextDouble() < 0.005D)
      EffectHelper.addEffect(EffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 32.0D), frosty, 60, 6, false, true);
    if (world.rand.nextDouble() < 0.005D)
      EffectHelper.addEffect(EffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 32.0D), frosty, 400, 0, false, true);
  }
}

