
package com.gmm.gctall.procedure;

import com.gmm.gctall.block.BlockFinalliumContainerActive;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import com.gmm.gctall.item.ItemOrderedCore;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureFinalliumContainerRightclick
{
    private ProcedureFinalliumContainerRightclick() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure FinalliumContainerRightclick!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure FinalliumContainerRightclick!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure FinalliumContainerRightclick!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure FinalliumContainerRightclick!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure FinalliumContainerRightclick!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == new ItemStack(ItemOrderedCore.block, 1).getItem()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).inventory.clearMatchingItems(new ItemStack(ItemOrderedCore.block, 1).getItem(), -1, 1, (NBTTagCompound)null);
            }
            world.setBlockState(new BlockPos(x, y, z), BlockFinalliumContainerActive.block.getDefaultState(), 3);
        }
    }
}


