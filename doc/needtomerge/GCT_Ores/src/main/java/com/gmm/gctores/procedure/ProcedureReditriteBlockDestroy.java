
package com.gmm.gctores.procedure;

import com.gmm.gctores.block.BlockReditriteCobblestone;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockReditriteBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureReditriteBlockDestroy extends ElementsGctOresMod.ModElement
{
    public ProcedureReditriteBlockDestroy(final ElementsGctOresMod instance) {
        super(instance, 222);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure ReditriteBlockDestroy!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure ReditriteBlockDestroy!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure ReditriteBlockDestroy!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure ReditriteBlockDestroy!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure ReditriteBlockDestroy!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (Math.random() < 0.25) {
            if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).capabilities.isCreativeMode) {
                if (!world.isRemote) {
                    final EntityItem entityToSpawn = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(BlockReditriteBlock.block, 1));
                    entityToSpawn.setPickupDelay(10);
                    world.spawnEntity((Entity)entityToSpawn);
                }
            }
        }
        else {
            world.setBlockState(new BlockPos(x, y, z), BlockReditriteCobblestone.block.getDefaultState(), 3);
        }
    }
}
