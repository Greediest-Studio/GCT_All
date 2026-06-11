
package com.gmm.gctall.procedure;

import net.minecraft.util.math.Vec3d;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;
public final class ProcedureSenterianSummonerSmallSummon
{
    private ProcedureSenterianSummonerSmallSummon() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure SenterianSummonerSmallSummon!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure SenterianSummonerSmallSummon!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure SenterianSummonerSmallSummon!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure SenterianSummonerSmallSummon!");
            return;
        }
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
        if (!world.isRemote && world.getMinecraftServer() != null) {
            world.getMinecraftServer().getCommandManager().executeCommand((ICommandSender)new ICommandSender() {
                public String getName() {
                    return "";
                }
                
                public boolean canUseCommand(final int permission, final String command) {
                    return true;
                }
                
                public World getEntityWorld() {
                    return world;
                }
                
                public MinecraftServer getServer() {
                    return world.getMinecraftServer();
                }
                
                public boolean sendCommandFeedback() {
                    return false;
                }
                
                public BlockPos getPosition() {
                    return new BlockPos(x, y, z);
                }
                
                public Vec3d getPositionVector() {
                    return new Vec3d((double)x, (double)y, (double)z);
                }
            }, "summon journey:guardianofdestruction ~ ~ ~");
        }
    }
}


