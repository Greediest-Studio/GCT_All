package com.gmm.gctall.block;

import com.gmm.gctall.item.ItemGravityScrap;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.gmm.gctall.procedure.ProcedureProGravityDebrisTick;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

  public class BlockGravityDebris extends Block {
  public static final Block block = new BlockGravityDebris();

  public BlockGravityDebris() {
    super(Material.ROCK);
    setTranslationKey("gravity_debris");
    setSoundType(SoundType.STONE);
    setHarvestLevel("pickaxe", 11);
    setHardness(100.0F);
    setResistance(30.0F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAllCreativeTab.TAB);
  }

  public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
    drops.add(new ItemStack(ItemGravityScrap.block, 2));
  }

  public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
    super.onBlockAdded(world, pos, state);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
  }

  public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
    super.neighborChanged(state, world, pos, neighborBlock, fromPos);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    if (world.getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) > 0);
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
  }

  public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
    super.updateTick(world, pos, state, random);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
    world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
  }

  public void onBlockClicked(World world, BlockPos pos, EntityPlayer entity) {
    super.onBlockClicked(world, pos, entity);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
  }

  public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
    super.onEntityCollision(world, pos, state, entity);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
  }

  public void onEntityWalk(World world, BlockPos pos, Entity entity) {
    super.onEntityWalk(world, pos, entity);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
  }

  public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction, float hitX, float hitY, float hitZ) {
    super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProGravityDebrisTick.executeProcedure($_dependencies);
    return true;
  }
}

