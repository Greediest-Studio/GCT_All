
package com.gmm.gctall.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureWrenchBreak
{
    private ProcedureWrenchBreak() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure WrenchBreak!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure WrenchBreak!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure WrenchBreak!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure WrenchBreak!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure WrenchBreak!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
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
            }, "fill ~ ~ ~ ~ ~ ~ gct_all:senterian_lament 0 replace journey:lament 0");
        }
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
        }
    }
}


