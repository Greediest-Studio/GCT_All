package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommands;
import com.gmm.gctall.entity.EntityAncientShoggoth;
import com.gmm.gctall.item.ItemAncientMud;
import com.gmm.gctall.world.dimension.WorldDIMDarkerRealm;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureSanityAltarNeighbourBlockChanges extends GctAllElement {
  public ProcedureSanityAltarNeighbourBlockChanges(GctAllContent instance) {
    super(instance, 28);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure SanityAltarNeighbourBlockChanges!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure SanityAltarNeighbourBlockChanges!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure SanityAltarNeighbourBlockChanges!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure SanityAltarNeighbourBlockChanges!");
      return;
    } 
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if ((new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x, y, z), 0).getItem() == (new ItemStack(ItemAncientMud.block, 1)).getItem()) {
      if (world.provider.getDimension() != WorldDIMDarkerRealm.DIMID) {
        if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.OBSIDIAN.getDefaultState()
          .getBlock()) {
          if (y <= 90) {
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "fill ~15 ~30 ~15 ~-15 ~1 ~-15 air"); 
            TileEntity inv = world.getTileEntity(new BlockPos(x, y, z));
            if (inv instanceof TileEntityLockableLoot)
              ((TileEntityLockableLoot)inv).decrStackSize(0, 1); 
            if (!world.isRemote) {
              EntityAncientShoggoth.EntityCustom entityCustom = new EntityAncientShoggoth.EntityCustom(world);
              if (entityCustom != null) {
                entityCustom.setLocationAndAngles(x, (y + 5), z, world.rand.nextFloat() * 360.0F, 0.0F);
                world.spawnEntity((Entity)entityCustom);
              } 
            } 
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"\u4F60\u6253\u6270\u4E86\u8FDC\u53E4\u7684\u91CE\u517D\u2026\u2026\"}] "); 
          } else if (!world.isRemote && world.getMinecraftServer() != null) {
            ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"\u796D\u575B\u7684\u9AD8\u5EA6\u5E94\u8BE5\u572890\u5C42\u4EE5\u4E0B\uFF01\"}] ");
          } 
        } else if (!world.isRemote && world.getMinecraftServer() != null) {
          ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"\u796D\u575B\u4E0A\u65B9\u5E94\u8BE5\u653E\u7F6E\u4E00\u5757\u9ED1\u66DC\u77F3\uFF01\"}] ");
        } 
      } else if (!world.isRemote && world.getMinecraftServer() != null) {
        ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"\u4F60\u5E94\u8BE5\u5728\u6DF1\u6697\u9886\u57DF\u53EC\u5524\u8FDC\u53E4\u4FEE\u683C\u65AF\uFF01\"}] ");
      } 
    } else if (!world.isRemote && world.getMinecraftServer() != null) {
      ServerCommands.run(world, x, y, z, "tellraw @a[r=5] [\"\",{\"text\":\"\u796D\u575B\u6CA1\u6709\u88AB\u8FDC\u53E4\u6C61\u6CE5\u586B\u5145\uFF01\"}] ");
    } 
  }
}

