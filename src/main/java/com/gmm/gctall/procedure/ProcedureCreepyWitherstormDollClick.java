
package com.gmm.gctall.procedure;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.item.ItemCreepyWitherstormDoll;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import com.gmm.gctall.world.WorldDIM100;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureCreepyWitherstormDollClick
{
    private ProcedureCreepyWitherstormDollClick() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure CreepyWitherstormDollClick!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure CreepyWitherstormDollClick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure CreepyWitherstormDollClick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure CreepyWitherstormDollClick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure CreepyWitherstormDollClick!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (entity.dimension == WorldDIM100.DIMID) {
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
                }, "say \u5c0f\u5fc3\uff0c\u5b83\u6765\u4e86\uff01");
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
                        return new BlockPos(x, y + 5, z);
                    }
                    
                    public Vec3d getPositionVector() {
                        return new Vec3d((double)x, (double)(y + 5), (double)z);
                    }
                }, "summon ageofminecraft:witherbosscommandblockhelpful");
            }
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).inventory.clearMatchingItems(new ItemStack(ItemCreepyWitherstormDoll.block, 1).getItem(), -1, 1, (NBTTagCompound)null);
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
            }, "tellraw @p[r=32] [\"\",{\"text\":\"\u6050\u6016\u7684\u98ce\u66b4\u51cb\u7075\u73a9\u5076\uff1a \u6211\u8c8c\u4f3c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u7ef4\u5ea6\u65bd\u5c55\u80fd\u529b\u2026\u2026\"}] ");
        }
    }
}


