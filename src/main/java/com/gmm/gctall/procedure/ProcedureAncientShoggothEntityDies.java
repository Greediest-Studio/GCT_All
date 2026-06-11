package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockSaniteOre;
import com.gmm.gctall.item.ItemEssenceOfDarkerrealm;
import com.gmm.gctall.item.ItemShoggothTancale;
import com.gmm.gctall.item.ItemShoggothTooth;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class ProcedureAncientShoggothEntityDies {
  private ProcedureAncientShoggothEntityDies() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure AncientShoggothEntityDies!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure AncientShoggothEntityDies!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure AncientShoggothEntityDies!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure AncientShoggothEntityDies!");
      return;
    }
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    for (int index0 = 0; index0 < (int)(5L + Math.round(Math.random() * 7.0D)); index0++) {
      if (!world.isRemote) {
        EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockSaniteOre.block, 1));
        entityToSpawn.setPickupDelay(10);
        world.spawnEntity((Entity)entityToSpawn);
      }
    }
    if (!world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemEssenceOfDarkerrealm.block, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
    if (!world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemShoggothTooth.block, 1));
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

