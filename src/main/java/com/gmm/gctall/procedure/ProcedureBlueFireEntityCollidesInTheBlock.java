package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionBluefire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureBlueFireEntityCollidesInTheBlock {
  private ProcedureBlueFireEntityCollidesInTheBlock() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure BlueFireEntityCollidesInTheBlock!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure BlueFireEntityCollidesInTheBlock!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure BlueFireEntityCollidesInTheBlock!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure BlueFireEntityCollidesInTheBlock!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    EntityPlayer player = ProcedureEffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 1.0D);
    if (player != null)
      ProcedureEffectHelper.addEffect(player, PotionBluefire.potion, 100, 0, false, false);
  }
}

