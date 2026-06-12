
package com.gmm.gctores.procedure;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureTonitruiumPush extends ElementsGctOresMod.ModElement
{
    public ProcedureTonitruiumPush(final ElementsGctOresMod instance) {
        super(instance, 318);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure TonitruiumPush!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure TonitruiumPush!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final World world = (World)dependencies.get("world");
        if (entity.getDisplayName().getUnformattedText().equals("bthdz") || entity.getDisplayName().getUnformattedText().equals("\u96f7\u7535\u4eba")) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 1, false, false));
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
                    return new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ);
                }
                
                public Vec3d getPositionVector() {
                    return new Vec3d(entity.posX, entity.posY, entity.posZ);
                }
            }, "effect @p gct_mobs:channeling 6 0");
        }
    }
}
