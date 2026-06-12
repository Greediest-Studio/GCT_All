package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionBluefire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class BlueFireEntityCollidesInTheBlock {
  private BlueFireEntityCollidesInTheBlock() {
  }

  public static void run(World world, int x, int y, int z) {
    EntityPlayer player = EffectHelper.nearestPlayer(world, new BlockPos(x, y, z), 1.0D);
    if (player != null)
      EffectHelper.addEffect(player, PotionBluefire.potion, 100, 0, false, false);
  }
}

