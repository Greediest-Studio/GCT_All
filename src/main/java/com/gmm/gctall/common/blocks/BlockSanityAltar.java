package com.gmm.gctall.common.blocks;

import com.gmm.gctall.misc.GctAllCreativeTab;

import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.client.gui.GuiGUISanityAltar;
import com.gmm.gctall.common.events.SanityAltarNeighbourBlockChanges;
import com.gmm.gctall.common.tile.TileEntitySanityAltar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

  public class BlockSanityAltar extends Block implements ITileEntityProvider {
  public static final Block block = new BlockSanityAltar();
public BlockSanityAltar() {
    super(Material.ROCK);
    setTranslationKey("sanity_altar");
    setSoundType(SoundType.STONE);
    setHarvestLevel("pickaxe", 9);
    setHardness(5.0F);
    setResistance(4000.0F);
    setLightLevel(0.0F);
    setLightOpacity(0);
    setCreativeTab(GctAllCreativeTab.TAB);
  }

  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }

  public boolean isOpaqueCube(IBlockState state) {
    return false;
  }

  public TileEntity createNewTileEntity(World worldIn, int meta) {
    return new TileEntitySanityAltar();
  }

  public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
    super.eventReceived(state, worldIn, pos, eventID, eventParam);
    TileEntity tileentity = worldIn.getTileEntity(pos);
    return (tileentity == null) ? false : tileentity.receiveClientEvent(eventID, eventParam);
  }

  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }

  public void breakBlock(World world, BlockPos pos, IBlockState state) {
    TileEntity tileentity = world.getTileEntity(pos);
    if (tileentity instanceof TileEntitySanityAltar)
      InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity);
    world.removeTileEntity(pos);
    super.breakBlock(world, pos, state);
  }

  public boolean hasComparatorInputOverride(IBlockState state) {
    return true;
  }

  public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
    TileEntity tileentity = worldIn.getTileEntity(pos);
    if (tileentity instanceof TileEntitySanityAltar)
      return Container.calcRedstoneFromInventory((IInventory)tileentity);
    return 0;
  }

  public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
    super.neighborChanged(state, world, pos, neighborBlock, fromPos);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    if (world.getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) > 0) {
      SanityAltarNeighbourBlockChanges.run(world, x, y, z);
    }
  }

  public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction, float hitX, float hitY, float hitZ) {
    super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
    int x = pos.getX();
    int y = pos.getY();
    int z = pos.getZ();
    if (entity instanceof EntityPlayer)
      entity.openGui(GctAllMod.INSTANCE, GuiGUISanityAltar.GUIID, world, x, y, z);
    return true;
  }
}
