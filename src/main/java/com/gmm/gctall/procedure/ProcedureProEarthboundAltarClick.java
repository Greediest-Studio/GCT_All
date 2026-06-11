package com.gmm.gctall.procedure;

import java.util.Map;
import java.util.Random;
import com.gmm.gctall.block.BlockEarthboundCore;
import com.gmm.gctall.block.BlockEarthboundReceiver;
import com.gmm.gctall.item.ItemEarthIngot;
import com.gmm.gctall.item.ItemEarthOrb;
import com.gmm.gctall.item.ItemHolysteelIngot;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProEarthboundAltarClick {
  private ProcedureProEarthboundAltarClick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProEarthboundAltarClick", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x + 4, y - 1, z + 0)).getBlock() == BlockEarthboundReceiver.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 4, y - 1, z + 0)).getBlock() == BlockEarthboundReceiver.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 4)).getBlock() == BlockEarthboundReceiver.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z - 4))
      .getBlock() == BlockEarthboundReceiver.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 3, y - 1, z + 3)).getBlock() == BlockEarthboundCore.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 3, y - 1, z + 3)).getBlock() == BlockEarthboundCore.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 3, y - 1, z - 3)).getBlock() == BlockEarthboundCore.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 3, y - 1, z - 3))
      .getBlock() == BlockEarthboundCore.block.getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z - 1)).getBlock() == Blocks.GRASS.getDefaultState()
      .getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z + 1)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z + 1)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z - 1)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 1, y - 1, z + 0)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x - 1, y - 1, z + 0)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 1)).getBlock() == Blocks.GRASS
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y - 1, z + 1))
      .getBlock() == Blocks.GRASS.getDefaultState().getBlock() && (new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x + 4, y - 1, z + 0), 0)
      .getItem() == (new ItemStack(ItemEarthOrb.block, 1)).getItem() && (new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x - 4, y - 1, z + 0), 0)
      .getItem() == (new ItemStack(ItemEarthOrb.block, 1)).getItem() && (new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x + 0, y - 1, z + 4), 0)
      .getItem() == (new ItemStack(ItemEarthOrb.block, 1)).getItem() && (new Object() {
        public ItemStack getItemStack(BlockPos pos, int sltid) {
          TileEntity inv = world.getTileEntity(pos);
          if (inv instanceof TileEntityLockableLoot)
            return ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
          return ItemStack.EMPTY;
        }
      }).getItemStack(new BlockPos(x + 0, y - 1, z - 4), 0)
      .getItem() == (new ItemStack(ItemEarthOrb.block, 1))
      .getItem()) {
      if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
        .getItem() == (new ItemStack(ItemHolysteelIngot.block, 1)).getItem()) {
        if (entity instanceof EntityPlayer)
          ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(ItemHolysteelIngot.block, 1)).getItem(), -1, 1, null);
        if (entity instanceof EntityLivingBase)
          ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
        for (int index0 = 0; index0 < 10; index0++)
          world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, y, z, 0.0D, 1.0D, 0.0D, new int[0]);
        if (Math.random() < 0.5D) {
          if (!world.isRemote) {
            EntityItem entityToSpawn = new EntityItem(world, x, (y + 1), z, new ItemStack(ItemEarthIngot.block, 1));
            entityToSpawn.setPickupDelay(10);
            world.spawnEntity((Entity)entityToSpawn);
          }
        } else if (!world.isRemote) {
          EntityItem entityToSpawn = new EntityItem(world, x, (y + 1), z, new ItemStack(Blocks.DIRT, 1, 0));
          entityToSpawn.setPickupDelay(10);
          world.spawnEntity((Entity)entityToSpawn);
        }
        TileEntity inv = world.getTileEntity(new BlockPos(x + 0, y - 1, z - 4));
        if (inv != null && inv instanceof TileEntityLockableLoot) {
          ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(0);
          if (stack != null &&
            stack.attemptDamageItem(1, new Random(), null)) {
            stack.shrink(1);
            stack.setItemDamage(0);
          }
        }
        inv = world.getTileEntity(new BlockPos(x + 0, y - 1, z + 4));
        if (inv != null && inv instanceof TileEntityLockableLoot) {
          ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(0);
          if (stack != null &&
            stack.attemptDamageItem(1, new Random(), null)) {
            stack.shrink(1);
            stack.setItemDamage(0);
          }
        }
        inv = world.getTileEntity(new BlockPos(x + 4, y - 1, z - 0));
        if (inv != null && inv instanceof TileEntityLockableLoot) {
          ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(0);
          if (stack != null &&
            stack.attemptDamageItem(1, new Random(), null)) {
            stack.shrink(1);
            stack.setItemDamage(0);
          }
        }
        inv = world.getTileEntity(new BlockPos(x - 4, y - 1, z - 0));
        if (inv != null && inv instanceof TileEntityLockableLoot) {
          ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(0);
          if (stack != null &&
            stack.attemptDamageItem(1, new Random(), null)) {
            stack.shrink(1);
            stack.setItemDamage(0);
          }
        }
        ServerCommandHelper.run(world, x, y, z, "naaura drain 100000 1");
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("block.metal.break")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
      }
    } else {
      world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
          .getObject(new ResourceLocation("block.anvil.land")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }
  }
}


