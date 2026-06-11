package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.gmm.gctall.procedure.ProcedureProApocalypseBomb;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

  public class BlockApocalypseBomb extends Block {
  public static final Block block = new BlockApocalypseBomb();

  public BlockApocalypseBomb() {
    super(Material.ROCK);
    setTranslationKey("apocalypse_bomb");
    setSoundType(SoundType.STONE);
    setHarvestLevel("pickaxe", 1);
    setHardness(100.0F);
    setResistance(10.0F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAllCreativeTab.TAB);
    setBlockUnbreakable();
  }

  public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
    super.onBlockAdded(world, pos, state);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
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
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
  }

  @SideOnly(Side.CLIENT)
  public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
    super.randomDisplayTick(state, world, pos, random);
    EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).player;
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    int i = x;
    int j = y;
    int k = z;
    for (int l = 0; l < 1; l++) {
      double d0 = i + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
      double d1 = j + 0.7D + (random.nextFloat() - 0.5D) * 0.5D + 0.5D;
      double d2 = k + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
      world.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    }
  }

  public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
    super.onExplosionDestroy(world, pos, e);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    Map<String, Object> $_dependencies = new HashMap<>();
    $_dependencies.put("x", Integer.valueOf(x));
    $_dependencies.put("y", Integer.valueOf(y));
    $_dependencies.put("z", Integer.valueOf(z));
    $_dependencies.put("world", world);
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
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
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
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
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
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
    ProcedureProApocalypseBomb.executeProcedure($_dependencies);
  }
}
