package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockAzathothiumOreComplex;
import com.gmm.gctall.block.BlockNyralathotepiumOreComplex;
import com.gmm.gctall.block.BlockShubniggurathiumOreComplex;
import com.gmm.gctall.block.BlockYogsothothiumOreComplex;
import com.gmm.gctall.item.ItemSoulStealerScroll;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureSeekAltarOnBlockRightClicked extends GctAllElement {
  public ProcedureSeekAltarOnBlockRightClicked(GctAllContent instance) {
    super(instance, 73);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure SeekAltarOnBlockRightClicked!");
      return;
    } 
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure SeekAltarOnBlockRightClicked!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure SeekAltarOnBlockRightClicked!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure SeekAltarOnBlockRightClicked!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure SeekAltarOnBlockRightClicked!");
      return;
    } 
    Entity entity = (Entity)dependencies.get("entity");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if ((new Object() {
        public boolean getValue(BlockPos pos, String tag) {
          TileEntity tileEntity = world.getTileEntity(pos);
          if (tileEntity != null)
            return tileEntity.getTileData().getBoolean(tag); 
          return false;
        }
      }).getValue(new BlockPos(x, y, z), "active") == true && 
      
      !(new Object() {
        public boolean getValue(BlockPos pos, String tag) {
          TileEntity tileEntity = world.getTileEntity(pos);
          if (tileEntity != null)
            return tileEntity.getTileData().getBoolean(tag); 
          return false;
        }
      }).getValue(new BlockPos(x, y, z), "work"))
      if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == BlockAzathothiumOreComplex.block.getDefaultState()
        .getBlock()) {
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setString("recipeName", "azathothium_ore"); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      } else if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == BlockNyralathotepiumOreComplex.block
        .getDefaultState().getBlock()) {
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setString("recipeName", "nyarlathotepium_ore"); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      } else if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == BlockYogsothothiumOreComplex.block
        .getDefaultState().getBlock()) {
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setString("recipeName", "yogsothothium_ore"); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      } else if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == BlockShubniggurathiumOreComplex.block
        .getDefaultState().getBlock()) {
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setString("recipeName", "shubniggurathium_ore"); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      } else if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
        .getItem() == (new ItemStack(ItemSoulStealerScroll.block, 1)).getItem()) {
        if (entity instanceof EntityPlayer)
          ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(ItemSoulStealerScroll.block, 1)).getItem(), -1, 1, null); 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setString("recipeName", "zjarugoth_summon"); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      }  
  }
}

