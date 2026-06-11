
package com.gmm.gctall.procedure;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.block.BlockReditriteCobblestone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureReditriteCobblestoneDestroy
{
    private ProcedureReditriteCobblestoneDestroy() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure ReditriteCobblestoneDestroy!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure ReditriteCobblestoneDestroy!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure ReditriteCobblestoneDestroy!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure ReditriteCobblestoneDestroy!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure ReditriteCobblestoneDestroy!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (Math.random() < 0.9) {
            if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).capabilities.isCreativeMode) {
                if (!world.isRemote) {
                    final EntityItem entityToSpawn = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(BlockReditriteCobblestone.block, 1));
                    entityToSpawn.setPickupDelay(10);
                    world.spawnEntity((Entity)entityToSpawn);
                }
            }
        }
        else if (Math.random() < 0.5) {
            if (!world.isRemote) {
                world.createExplosion((Entity)null, (double)x, (double)y, (double)z, 4.0f, true);
            }
        }
        else {
            world.setBlockState(new BlockPos(x, y, z), Blocks.LAVA.getDefaultState(), 3);
        }
    }
}


