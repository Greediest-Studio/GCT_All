
package com.gmm.gctall.procedure;

import net.minecraft.util.math.Vec3d;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import com.gmm.gctall.block.BlockSenterianLament;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;
public final class ProcedureSenterianSummonerSummon
{
    private ProcedureSenterianSummonerSummon() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure SenterianSummonerSummon!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure SenterianSummonerSummon!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure SenterianSummonerSummon!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure SenterianSummonerSummon!");
            return;
        }
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (world.getBlockState(new BlockPos(x + 12, y + 0, z + 0)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 0, y + 0, z + 12)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 12, y + 0, z + 0)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 0, y + 0, z - 12)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 10, y + 0, z + 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 10, y + 0, z + 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 10, y + 0, z - 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 10, y + 0, z - 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock()) {
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
                }, "fill ~5 ~-1 ~5 ~-5 ~17 ~-5 air");
            }
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
                }, "summon journey:sentryheart ~ ~ ~");
            }
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
                }, "tellraw @a[r=32] [\"\",{\"text\":\"\u54e8\u5175\u4e4b\u5fc3 \u5df2\u82cf\u9192\uff01\"}] ");
            }
        }
    }
}


