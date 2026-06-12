package com.gmm.gctall.common.events;

import com.gmm.gctall.common.entity.EntityAncientShoggoth;
import com.gmm.gctall.misc.registry.GctAllItems;
import com.gmm.gctall.common.util.ServerCommands;
import com.gmm.gctall.common.world.dimension.WorldDarkerRealm;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class SanityAltarNeighbourBlockChanges {
  private SanityAltarNeighbourBlockChanges() {
  }

  public static void run(World world, int x, int y, int z) {
    BlockPos altarPos = new BlockPos(x, y, z);
    if (getStack(world, altarPos, 0).getItem() != GctAllItems.ANCIENT_MUD) {
      tell(world, x, y, z, "祭坛没有被远古污泥填充！");
      return;
    }

    if (world.provider.getDimension() != WorldDarkerRealm.DIMID) {
      tell(world, x, y, z, "你应该在深暗领域召唤远古修格斯！");
      return;
    }

    if (world.getBlockState(altarPos.up()).getBlock() != Blocks.OBSIDIAN) {
      tell(world, x, y, z, "祭坛上方应该放置一块黑曜石！");
      return;
    }

    if (y > 90) {
      tell(world, x, y, z, "祭坛的高度应该在90层以下！");
      return;
    }

    ServerCommands.run(world, x, y, z, "fill ~15 ~30 ~15 ~-15 ~1 ~-15 air");
    TileEntity inv = world.getTileEntity(altarPos);
    if (inv instanceof TileEntityLockableLoot) {
      ((TileEntityLockableLoot) inv).decrStackSize(0, 1);
    }

    if (!world.isRemote) {
      EntityAncientShoggoth.AncientShoggothEntity shoggoth = new EntityAncientShoggoth.AncientShoggothEntity(world);
      shoggoth.setLocationAndAngles(x, y + 5, z, world.rand.nextFloat() * 360.0F, 0.0F);
      world.spawnEntity(shoggoth);
    }
    tell(world, x, y, z, "你打扰了远古的野兽……");
  }

  private static ItemStack getStack(World world, BlockPos pos, int slot) {
    TileEntity inv = world.getTileEntity(pos);
    return inv instanceof TileEntityLockableLoot ? ((TileEntityLockableLoot) inv).getStackInSlot(slot) : ItemStack.EMPTY;
  }

  private static void tell(World world, int x, int y, int z, String message) {
    ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"" + message + "\"}]");
  }
}

