package com.gmm.gctall.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class ServerCommandHelper {
  private ServerCommandHelper() {}

  public static void run(World world, BlockPos pos, String command) {
    if (world.isRemote || world.getMinecraftServer() == null) {
      return;
    }
    world.getMinecraftServer().getCommandManager().executeCommand(new SilentCommandSender(world, pos), command);
  }

  public static void run(World world, int x, int y, int z, String command) {
    run(world, new BlockPos(x, y, z), command);
  }

  private static final class SilentCommandSender implements ICommandSender {
    private final World world;
    private final BlockPos position;

    private SilentCommandSender(World world, BlockPos position) {
      this.world = world;
      this.position = position;
    }

    public String getName() {
      return "GCT_Mobs";
    }

    public boolean canUseCommand(int permission, String command) {
      return true;
    }

    public World getEntityWorld() {
      return this.world;
    }

    public MinecraftServer getServer() {
      return this.world.getMinecraftServer();
    }

    public boolean sendCommandFeedback() {
      return false;
    }

    public BlockPos getPosition() {
      return this.position;
    }

    public Vec3d getPositionVector() {
      return new Vec3d(this.position.getX(), this.position.getY(), this.position.getZ());
    }
  }
}
