package com.gmm.gctall.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class ServerCommands {
  private ServerCommands() {}

  public static void run(final World world, final int x, final int y, final int z, String command) {
    if (world.isRemote || world.getMinecraftServer() == null) {
      return;
    }
    world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
      @Override
      public String getName() {
        return "";
      }

      @Override
      public boolean canUseCommand(int permission, String command) {
        return true;
      }

      @Override
      public World getEntityWorld() {
        return world;
      }

      @Override
      public MinecraftServer getServer() {
        return world.getMinecraftServer();
      }

      @Override
      public boolean sendCommandFeedback() {
        return false;
      }

      @Override
      public BlockPos getPosition() {
        return new BlockPos(x, y, z);
      }

      @Override
      public Vec3d getPositionVector() {
        return new Vec3d(x, y, z);
      }
    }, command);
  }
}
