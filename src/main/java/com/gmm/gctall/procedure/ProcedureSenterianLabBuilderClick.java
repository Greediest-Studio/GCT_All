
package com.gmm.gctall.procedure;

import com.gmm.gctall.world.structure.StructureGenerationHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;
public final class ProcedureSenterianLabBuilderClick
{
    private ProcedureSenterianLabBuilderClick() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure SenterianLabBuilderClick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure SenterianLabBuilderClick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure SenterianLabBuilderClick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure SenterianLabBuilderClick!");
            return;
        }
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (world.provider.getDimension() == 829 && y == 21) {
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
                }, "tellraw @p[r=32] [\"\",{\"text\":\"\u9ed1\u5ca9\u5b9e\u9a8c\u5ba4\u5df2\u7ecf\u751f\u6210\uff01\u53ef\u80fd\u4f1a\u9020\u6210\u4e00\u5b9a\u5361\u987f\uff0c\u8bf7\u77e5\u6089\"}] ");
            }
            if (!world.isRemote) {
                StructureGenerationHelper.placeTemplate(world, "senterian_lab", new BlockPos(x, y, z), Rotation.NONE, Mirror.NONE);
            }
        }
        else if (!world.isRemote && world.getMinecraftServer() != null) {
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
            }, "tellraw @p[r=32] [\"\",{\"text\":\"\u7ef4\u5ea6\u6216\u9ad8\u5ea6\u4e0d\u6b63\u786e\uff01\"}] ");
        }
    }
}



