
package com.gmm.gctores.procedure;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import com.gmm.gctores.item.ItemSenterianKey;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureSenterianLockUnlock extends ElementsGctOresMod.ModElement
{
    public ProcedureSenterianLockUnlock(final ElementsGctOresMod instance) {
        super(instance, 459);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure SenterianLockUnlock!");
            return;
        }
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure SenterianLockUnlock!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure SenterianLockUnlock!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure SenterianLockUnlock!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure SenterianLockUnlock!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == new ItemStack(ItemSenterianKey.block, 1).getItem()) {
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).inventory.clearMatchingItems(new ItemStack(ItemSenterianKey.block, 1).getItem(), -1, 1, (NBTTagCompound)null);
            }
            world.setBlockToAir(new BlockPos(x, y, z));
            world.playSound((EntityPlayer)null, (double)x, (double)y, (double)z, (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation("block.fence_gate.open")), SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
    }
}
