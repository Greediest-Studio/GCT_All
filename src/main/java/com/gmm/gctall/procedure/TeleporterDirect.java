package com.gmm.gctall.procedure;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class TeleporterDirect extends Teleporter {
  public TeleporterDirect(WorldServer world) {
    super(world);
  }
  
  @Override
  public void placeInPortal(Entity entity, float rotationYaw) {}
  
  @Override
  public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
    return true;
  }
  
  @Override
  public boolean makePortal(Entity entity) {
    return true;
  }

  public static boolean transferToSpawn(EntityPlayerMP player, int dimension) {
    WorldServer targetWorld = player.server.getWorld(dimension);
    if (targetWorld == null) {
      DimensionManager.initDimension(dimension);
      targetWorld = DimensionManager.getWorld(dimension);
    }
    if (targetWorld == null) {
      return false;
    }
    BlockPos spawn = targetWorld.getSpawnPoint();
    player.changeDimension(dimension, new TeleporterDirect(targetWorld));
    if (player.dimension != dimension) {
      return false;
    }
    player.connection.setPlayerLocation(spawn.getX() + 0.5D, spawn.getY() + 1.0D, spawn.getZ() + 0.5D, player.rotationYaw, player.rotationPitch);
    player.timeUntilPortal = player.getPortalCooldown();
    return true;
  }
}
