package com.gmm.gctall.common.events;

import com.gmm.gctall.misc.registry.GctAllItems;

import com.gmm.gctall.common.blocks.BlockSaniteOre;
import com.gmm.gctall.common.items.ItemShoggothTancale;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class AncientShoggothEntityDies {
  private AncientShoggothEntityDies() {
  }

  public static void run(World world, int x, int y, int z) {
    for (int index0 = 0; index0 < (int)(5L + Math.round(Math.random() * 7.0D)); index0++) {
      if (!world.isRemote) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockSaniteOre.block, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      }
    }
    if (!world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(GctAllItems.ESSENCE_OF_DARKERREALM, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
    if (!world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(GctAllItems.SHOGGOTH_TOOTH, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
    for (int index1 = 0; index1 < (int)(2L + Math.round(Math.random() * 3.0D)); index1++) {
      if (!world.isRemote) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemShoggothTancale.block, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      }
    }
  }
}

