package com.gmm.gctall.common.events;

import com.gmm.gctall.common.items.ItemShoggothTancale;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class DarkerLesserShoggothEntityDies {
  private DarkerLesserShoggothEntityDies() {
  }

  public static void run(World world, int x, int y, int z) {
    if (Math.random() < 0.5D &&
      !world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemShoggothTancale.block, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
  }
}

