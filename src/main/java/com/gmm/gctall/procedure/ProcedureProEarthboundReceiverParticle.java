package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemEarthOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureProEarthboundReceiverParticle extends GctAllElement {
  public ProcedureProEarthboundReceiverParticle(GctAllContent instance) {
    super(instance, 371);
  }
  
  public static boolean executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProEarthboundReceiverParticle", "x", "y", "z", "world"))
      return false;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    final World world = ProcedureContext.world(dependencies);
    if ((new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x, y, z), 0).getItem() == (new ItemStack(ItemEarthOrb.block, 1)).getItem())
      return true; 
    return false;
  }
}

