package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.util.ServerCommands;
import com.gmm.gctall.entity.EntityAncientShoggoth;
import com.gmm.gctall.item.ItemAncientMud;
import com.gmm.gctall.world.dimension.WorldDIMDarkerRealm;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureSanityAltarNeighbourBlockChanges {
  private ProcedureSanityAltarNeighbourBlockChanges() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure SanityAltarNeighbourBlockChanges!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure SanityAltarNeighbourBlockChanges!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure SanityAltarNeighbourBlockChanges!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure SanityAltarNeighbourBlockChanges!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if ((new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x, y, z), 0).getItem() == (new ItemStack(ItemAncientMud.block, 1)).getItem()) {
      if (world.provider.getDimension() != WorldDIMDarkerRealm.DIMID) {
        if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.OBSIDIAN.getDefaultState()
          .getBlock()) {
          if (y <= 90) {
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "fill ~15 ~30 ~15 ~-15 ~1 ~-15 air");
            TileEntity inv = world.getTileEntity(new BlockPos(x, y, z));
            if (inv instanceof TileEntityLockableLoot)
              ((TileEntityLockableLoot)inv).decrStackSize(0, 1);
            if (!world.isRemote) {
              EntityAncientShoggoth.AncientShoggothEntity entityCustom = new EntityAncientShoggoth.AncientShoggothEntity(world);
              if (entityCustom != null) {
                entityCustom.setLocationAndAngles(x, (y + 5), z, world.rand.nextFloat() * 360.0F, 0.0F);
                world.spawnEntity((Entity)entityCustom);
              }
            }
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"你打扰了远古的野兽……\"}] ");
          } else if (!world.isRemote && world.getMinecraftServer() != null) {
            ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"祭坛的高度应该在90层以下！\"}] ");
          }
        } else if (!world.isRemote && world.getMinecraftServer() != null) {
          ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"祭坛上方应该放置一块黑曜石！\"}] ");
        }
      } else if (!world.isRemote && world.getMinecraftServer() != null) {
        ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"你应该在深暗领域召唤远古修格斯！\"}] ");
      }
    } else if (!world.isRemote && world.getMinecraftServer() != null) {
      ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"祭坛没有被远古污泥填充！\"}] ");
    }
  }
}

