
package com.gmm.gctores.procedure;

import net.minecraft.util.math.Vec3d;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;

@ModElement.Tag
public class ProcedureCommandDismantlerClick extends ElementsGctOresMod.ModElement
{
    public ProcedureCommandDismantlerClick(final ElementsGctOresMod instance) {
        super(instance, 348);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure CommandDismantlerClick!");
            return;
        }
        if (dependencies.get("itemstack") == null) {
            System.err.println("Failed to load dependency itemstack for procedure CommandDismantlerClick!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure CommandDismantlerClick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure CommandDismantlerClick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure CommandDismantlerClick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure CommandDismantlerClick!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final ItemStack itemstack = (ItemStack)dependencies.get("itemstack");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.REPEATING_COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.REPEATING_COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.CHAIN_COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.CHAIN_COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.STRUCTURE_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.STRUCTURE_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
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
            }, "say @p \uff0c\u8be5\u65b9\u5757\u65e0\u6cd5\u62c6\u9664\uff01");
        }
    }
}
