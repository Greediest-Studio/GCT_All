package com.gmm.gctall.common.events;

import com.gmm.gctall.misc.registry.GctAllItems;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class ApocalypseAltarClick {
  private ApocalypseAltarClick() {
  }

  public static void run(Entity entity, World world, int x, int y, int z) {
    if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
      .getItem() == (new ItemStack(GctAllItems.APOCALYPSE_RUIN, 1)).getItem()) {
      if (entity instanceof EntityPlayer)
        ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(GctAllItems.APOCALYPSE_RUIN, 1)).getItem(), -1, 1, null);
      ServerCommandHelper.run(world, x, y, z, "summon gct_all:apocalypse_cube ~ ~4 ~ {Passengers:[{id:\"gct_all:apocalypse_knight\"}]}");
    }
  }
}

