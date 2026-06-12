package com.gmm.gctall.common.events;

import com.gmm.gctall.misc.registry.GctAllItems;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class ApocalypseDeath {
  private ApocalypseDeath() {
  }

  public static void run(World world, int x, int y, int z) {
    for (int index0 = 0; index0 < (new Random()).nextInt(16) + 10; index0++) {
      if (!world.isRemote) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(GctAllItems.APOCALYPSIUM_SCRAP, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      }
    }
  }
}

