
package com.gmm.gctores.procedure;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureLumixeiumTick extends ElementsGctOresMod.ModElement
{
    public ProcedureLumixeiumTick(final ElementsGctOresMod instance) {
        super(instance, 311);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure LumixeiumTick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure LumixeiumTick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure LumixeiumTick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure LumixeiumTick!");
            return;
        }
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (world.getBlockState(new BlockPos(x + 1, y, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x + 1, y, z), false);
        }
        if (world.getBlockState(new BlockPos(x - 1, y, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x - 1, y, z), false);
        }
        if (world.getBlockState(new BlockPos(x, y, z + 1)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y, z + 1), false);
        }
        if (world.getBlockState(new BlockPos(x, y, z - 1)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y, z - 1), false);
        }
        if (world.getBlockState(new BlockPos(x, y - 1, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y - 1, z), false);
        }
    }
}
