package com.gmm.gctall.common.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SilentCommandSender implements ICommandSender {
    private final World world;
    private final BlockPos position;

    public SilentCommandSender(World world, BlockPos position) {
        this.world = world;
        this.position = position;
    }

    @Override
    public String getName() {
        return "GCT_All";
    }

    @Override
    public boolean canUseCommand(int permission, String command) {
        return true;
    }

    @Override
    public World getEntityWorld() {
        return this.world;
    }

    @Override
    public MinecraftServer getServer() {
        return this.world.getMinecraftServer();
    }

    @Override
    public boolean sendCommandFeedback() {
        return false;
    }

    @Override
    public BlockPos getPosition() {
        return this.position;
    }

    @Override
    public Vec3d getPositionVector() {
        return new Vec3d(this.position.getX(), this.position.getY(), this.position.getZ());
    }
}
