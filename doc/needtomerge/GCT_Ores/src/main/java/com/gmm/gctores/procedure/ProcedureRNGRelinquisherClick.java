
package com.gmm.gctores.procedure;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.DimensionManager;
import com.gmm.gctores.world.WorldDIM101;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;
import net.minecraft.world.Teleporter;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureRNGRelinquisherClick extends ElementsGctOresMod.ModElement
{
    public ProcedureRNGRelinquisherClick(final ElementsGctOresMod instance) {
        super(instance, 369);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure RNGRelinquisherClick!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure RNGRelinquisherClick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure RNGRelinquisherClick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure RNGRelinquisherClick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure RNGRelinquisherClick!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        class ReturnTeleporterDirect extends Teleporter
        {
            public ReturnTeleporterDirect(final WorldServer worldserver) {
                super(worldserver);
            }
            
            public void placeInPortal(final Entity entity, final float yawrotation) {
            }
            
            public boolean placeInExistingPortal(final Entity entity, final float yawrotation) {
                return true;
            }
            
            public boolean makePortal(final Entity entity) {
                return true;
            }
        }
        if (entity.dimension == 1 && x == 0 && z == 0) {
            final Entity _ent = entity;
            if (!_ent.world.isRemote && !_ent.isRiding() && !_ent.isBeingRidden() && _ent instanceof EntityPlayerMP) {
                final int dimensionID = WorldDIM101.DIMID;
                final EntityPlayerMP _player = (EntityPlayerMP)_ent;
                class TargetTeleporterDirect extends Teleporter
                {
                    public TargetTeleporterDirect(final WorldServer worldserver) {
                        super(worldserver);
                    }
                    
                    public void placeInPortal(final Entity entity, final float yawrotation) {
                    }
                    
                    public boolean placeInExistingPortal(final Entity entity, final float yawrotation) {
                        return true;
                    }
                    
                    public boolean makePortal(final Entity entity) {
                        return true;
                    }
                }
                _player.server.getPlayerList().transferPlayerToDimension(_player, dimensionID, (Teleporter)new TargetTeleporterDirect(_player.getServerWorld()));
                _player.connection.setPlayerLocation((double)DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(), (double)(DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1), (double)DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
            }
        }
        else if (entity.dimension == WorldDIM101.DIMID) {
            final Entity _ent = entity;
            if (!_ent.world.isRemote && !_ent.isRiding() && !_ent.isBeingRidden() && _ent instanceof EntityPlayerMP) {
                final int dimensionID = 1;
                final EntityPlayerMP _player = (EntityPlayerMP)_ent;
                _player.server.getPlayerList().transferPlayerToDimension(_player, dimensionID, (Teleporter)new ReturnTeleporterDirect(_player.getServerWorld()));
                _player.connection.setPlayerLocation((double)DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(), (double)(DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1), (double)DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
            }
        }
        else if (entity.dimension != 1 && entity.dimension != WorldDIM101.DIMID) {
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
                }, "tellraw @p[r=32] [\"\",{\"text\":\"\u8c8c\u4f3c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u7ef4\u5ea6\u4f7f\u7528\u8fd9\u4e2a\u7269\u54c1\u2026\u2026\"}] ");
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
            }, "tellraw @p[r=32] [\"\",{\"text\":\"\u6216\u8bb8\u6211\u9700\u8981\u62b5\u8fbe\u672b\u8def\u4e4b\u5730\u7684\u539f\u70b9\uff1f\"}] ");
        }
    }
}
