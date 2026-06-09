package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemElementiumFusionplate;
import com.gmm.gctall.item.ItemElfPasses;
import com.gmm.gctall.item.ItemKabalahRingAur;
import com.gmm.gctall.item.ItemOrichalcosFusionplate;
import com.gmm.gctall.item.ItemRuneActive1;
import com.gmm.gctall.item.ItemRuneActive10;
import com.gmm.gctall.item.ItemRuneActive2;
import com.gmm.gctall.item.ItemRuneActive3;
import com.gmm.gctall.item.ItemRuneActive4;
import com.gmm.gctall.item.ItemRuneActive5;
import com.gmm.gctall.item.ItemRuneActive6;
import com.gmm.gctall.item.ItemRuneActive7;
import com.gmm.gctall.item.ItemRuneActive8;
import com.gmm.gctall.item.ItemRuneActive9;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureProKabalahBuilderRecipe extends GctAllElement {
  public ProcedureProKabalahBuilderRecipe(GctAllContent instance) {
    super(instance, 267);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProKabalahBuilderRecipe", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
    if (!(tile instanceof TileEntityLockableLoot))
      return;
    TileEntityLockableLoot inventory = (TileEntityLockableLoot)tile;
    if (matchesRuneRecipe(inventory)) {
      ItemStack stack = new ItemStack(ItemKabalahRingAur.block, 1);
      stack.setCount(1);
      inventory.setInventorySlotContents(13, stack);
    } else if (matchesElfPassRecipe(inventory)) {
      ItemStack stack = new ItemStack(ItemElfPasses.block, 1);
      stack.setCount(2);
      inventory.setInventorySlotContents(13, stack);
    }
  }

  private static boolean matchesRuneRecipe(TileEntityLockableLoot inventory) {
    return slotMatches(inventory, 0, new ItemStack(ItemRuneActive1.block, 1)) &&
        slotMatches(inventory, 2, new ItemStack(ItemRuneActive2.block, 1)) &&
        slotMatches(inventory, 1, new ItemStack(ItemRuneActive3.block, 1)) &&
        slotMatches(inventory, 4, new ItemStack(ItemRuneActive4.block, 1)) &&
        slotMatches(inventory, 3, new ItemStack(ItemRuneActive5.block, 1)) &&
        slotMatches(inventory, 5, new ItemStack(ItemRuneActive6.block, 1)) &&
        slotMatches(inventory, 6, new ItemStack(ItemRuneActive7.block, 1)) &&
        slotMatches(inventory, 7, new ItemStack(ItemRuneActive8.block, 1)) &&
        slotMatches(inventory, 8, new ItemStack(ItemRuneActive9.block, 1)) &&
        slotMatches(inventory, 9, new ItemStack(ItemRuneActive10.block, 1));
  }

  private static boolean matchesElfPassRecipe(TileEntityLockableLoot inventory) {
    return slotMatches(inventory, 0, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 2, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 1, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 4, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 3, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 5, new ItemStack(ItemOrichalcosFusionplate.block, 1)) &&
        slotMatches(inventory, 6, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 7, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 8, new ItemStack(ItemElementiumFusionplate.block, 1)) &&
        slotMatches(inventory, 9, new ItemStack(Blocks.AIR, 1)) &&
        slotMatches(inventory, 10, new ItemStack(ItemKabalahRingAur.block, 1));
  }

  private static boolean slotMatches(TileEntityLockableLoot inventory, int slot, ItemStack expected) {
    return inventory.getStackInSlot(slot).getItem() == expected.getItem();
  }
}

