
package com.gmm.gctores.procedure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.block.Block;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureDoorKeyOrderlandClick extends ElementsGctOresMod.ModElement
{
    public ProcedureDoorKeyOrderlandClick(final ElementsGctOresMod instance) {
        super(instance, 404);
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
            final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "order_portal"));
            if (template != null) {
                final BlockPos spawnTo = new BlockPos(x, y + 1, z - 1);
                final IBlockState iblockstate = world.getBlockState(spawnTo);
                world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
                template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
            }
        }
        if (entity.getHorizontalFacing() == EnumFacing.WEST && !world.isRemote) {
            final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "order_portal"));
            if (template != null) {
                final BlockPos spawnTo = new BlockPos(x, y + 1, z - 2);
                final IBlockState iblockstate = world.getBlockState(spawnTo);
                world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
                template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
            }
        }
        if (entity.getHorizontalFacing() == EnumFacing.NORTH && !world.isRemote) {
            final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "order_portal_2"));
            if (template != null) {
                final BlockPos spawnTo = new BlockPos(x - 1, y + 1, z);
                final IBlockState iblockstate = world.getBlockState(spawnTo);
                world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
                template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
            }
        }
        if (entity.getHorizontalFacing() == EnumFacing.SOUTH && !world.isRemote) {
            final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "order_portal_2"));
            if (template != null) {
                final BlockPos spawnTo = new BlockPos(x - 2, y + 1, z);
                final IBlockState iblockstate = world.getBlockState(spawnTo);
                world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
                template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
            }
        }
    }
}
