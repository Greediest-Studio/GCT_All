
package com.gmm.gctall.procedure;

import com.gmm.gctall.world.structure.StructureGenerationHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureDoorKeyOrderlandClick
{
    private ProcedureDoorKeyOrderlandClick() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure DoorKeyOrderlandClick!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure DoorKeyOrderlandClick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure DoorKeyOrderlandClick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure DoorKeyOrderlandClick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure DoorKeyOrderlandClick!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (entity.getHorizontalFacing() == EnumFacing.EAST && !world.isRemote) {
            StructureGenerationHelper.placeTemplate(world, "order_portal", new BlockPos(x, y + 1, z - 1), Rotation.NONE, Mirror.NONE);
        }
        if (entity.getHorizontalFacing() == EnumFacing.WEST && !world.isRemote) {
            StructureGenerationHelper.placeTemplate(world, "order_portal", new BlockPos(x, y + 1, z - 2), Rotation.NONE, Mirror.NONE);
        }
        if (entity.getHorizontalFacing() == EnumFacing.NORTH && !world.isRemote) {
            StructureGenerationHelper.placeTemplate(world, "order_portal_2", new BlockPos(x - 1, y + 1, z), Rotation.NONE, Mirror.NONE);
        }
        if (entity.getHorizontalFacing() == EnumFacing.SOUTH && !world.isRemote) {
            StructureGenerationHelper.placeTemplate(world, "order_portal_2", new BlockPos(x - 2, y + 1, z), Rotation.NONE, Mirror.NONE);
        }
    }
}



