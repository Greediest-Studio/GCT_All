package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommands;
import com.gmm.gctall.block.BlockAzathothiumOre;
import com.gmm.gctall.block.BlockAzathothiumOreComplex;
import com.gmm.gctall.block.BlockNyarlathotepiumOre;
import com.gmm.gctall.block.BlockNyralathotepiumOreComplex;
import com.gmm.gctall.block.BlockSeekFinder;
import com.gmm.gctall.block.BlockShubniggurathiumOre;
import com.gmm.gctall.block.BlockShubniggurathiumOreComplex;
import com.gmm.gctall.block.BlockSolidPotEnergy;
import com.gmm.gctall.block.BlockYogsothothiumOre;
import com.gmm.gctall.block.BlockYogsothothiumOreComplex;
import com.gmm.gctall.entity.EntityZjarugoth;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

@Tag
public class ProcedureSeekAltarUpdateTick extends GctAllElement {
  public ProcedureSeekAltarUpdateTick(GctAllContent instance) {
    super(instance, 72);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure SeekAltarUpdateTick!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure SeekAltarUpdateTick!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure SeekAltarUpdateTick!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure SeekAltarUpdateTick!");
      return;
    } 
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if (world.getBlockState(new BlockPos(x + 3, y + 6, z + 0)).getBlock() == BlockSeekFinder.block.getDefaultState()
      .getBlock() && world
      .getBlockState(new BlockPos(x - 3, y + 6, z + 0)).getBlock() == BlockSeekFinder.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 6, z + 3)).getBlock() == BlockSeekFinder.block
      .getDefaultState().getBlock() && world
      .getBlockState(new BlockPos(x + 0, y + 6, z - 3)).getBlock() == BlockSeekFinder.block
      .getDefaultState().getBlock()) {
      if (!world.isRemote) {
        BlockPos _bp = new BlockPos(x, y, z);
        TileEntity _tileEntity = world.getTileEntity(_bp);
        IBlockState _bs = world.getBlockState(_bp);
        if (_tileEntity != null)
          _tileEntity.getTileData().setBoolean("active", true); 
        world.notifyBlockUpdate(_bp, _bs, _bs, 3);
      } 
      if (world instanceof WorldServer)
        ((WorldServer)world).spawnParticle(EnumParticleTypes.SPELL_WITCH, x, (y + 2), z, 40, 1.0D, 1.0D, 1.0D, 0.1D, new int[0]); 
      if (world instanceof WorldServer)
        ((WorldServer)world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (x + 3), (y + 4), (z + 0), 10, 1.0D, 2.0D, 1.0D, 0.1D, new int[0]); 
      if (world instanceof WorldServer)
        ((WorldServer)world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (x - 3), (y + 4), (z + 0), 10, 1.0D, 2.0D, 1.0D, 0.1D, new int[0]); 
      if (world instanceof WorldServer)
        ((WorldServer)world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (x + 0), (y + 4), (z + 3), 10, 1.0D, 2.0D, 1.0D, 0.1D, new int[0]); 
      if (world instanceof WorldServer)
        ((WorldServer)world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (x + 0), (y + 4), (z - 3), 10, 1.0D, 2.0D, 1.0D, 0.1D, new int[0]); 
      if ((new Object() {
          public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null)
              return tileEntity.getTileData().getString(tag); 
            return "";
          }
        }).getValue(new BlockPos(x, y, z), "recipeName").equals("azathothium_ore")) {
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("gct_all:chant_abyss")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setBoolean("work", true); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", (new Object() {
                  public double getValue(BlockPos pos, String tag) {
                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity != null)
                      return tileEntity.getTileData().getDouble(tag); 
                    return -1.0D;
                  }
                }).getValue(new BlockPos(x, y, z), "timer") + 1.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (world instanceof WorldServer)
          ((WorldServer)world).spawnParticle(EnumParticleTypes.LAVA, (x + 0), y + 11.0D - (new Object() {
                public double getValue(BlockPos pos, String tag) {
                  TileEntity tileEntity = world.getTileEntity(pos);
                  if (tileEntity != null)
                    return tileEntity.getTileData().getDouble(tag); 
                  return -1.0D;
                }
              }).getValue(new BlockPos(x, y, z), "timer") / 4.0D, (z - 0), 30, 0.0D, 0.0D, 0.0D, 0.8D, new int[0]); 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") > 40.0D && 
          !world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", 0.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") == 40.0D)
          if (world.getBlockState(new BlockPos(x + 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
            .getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x - 3, y + 5, z + 0))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z + 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z - 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 1, z + 0))
            .getBlock() == BlockAzathothiumOreComplex.block.getDefaultState().getBlock()) {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.setBlockState(new BlockPos(x, y + 1, z), BlockAzathothiumOre.block.getDefaultState(), 3);
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          } else {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.destroyBlock(new BlockPos(x, y + 1, z), false);
            world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "effect @a[r=16] gct_all:abyssplague 15 0 false"); 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          }  
      } else if ((new Object() {
          public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null)
              return tileEntity.getTileData().getString(tag); 
            return "";
          }
        }).getValue(new BlockPos(x, y, z), "recipeName").equals("nyarlathotepium_ore")) {
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("gct_all:chant_abyss")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setBoolean("work", true); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", (new Object() {
                  public double getValue(BlockPos pos, String tag) {
                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity != null)
                      return tileEntity.getTileData().getDouble(tag); 
                    return -1.0D;
                  }
                }).getValue(new BlockPos(x, y, z), "timer") + 1.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (world instanceof WorldServer)
          ((WorldServer)world).spawnParticle(EnumParticleTypes.LAVA, (x + 0), y + 11.0D - (new Object() {
                public double getValue(BlockPos pos, String tag) {
                  TileEntity tileEntity = world.getTileEntity(pos);
                  if (tileEntity != null)
                    return tileEntity.getTileData().getDouble(tag); 
                  return -1.0D;
                }
              }).getValue(new BlockPos(x, y, z), "timer") / 4.0D, (z - 0), 30, 0.0D, 0.0D, 0.0D, 0.8D, new int[0]); 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") > 40.0D && 
          !world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", 0.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") == 40.0D)
          if (world.getBlockState(new BlockPos(x + 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
            .getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x - 3, y + 5, z + 0))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z + 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z - 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 1, z + 0))
            .getBlock() == BlockNyralathotepiumOreComplex.block.getDefaultState().getBlock()) {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.setBlockState(new BlockPos(x, y + 1, z), BlockNyarlathotepiumOre.block.getDefaultState(), 3);
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          } else {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.destroyBlock(new BlockPos(x, y + 1, z), false);
            world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "effect @a[r=16] gct_all:abyssplague 15 0 false"); 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          }  
      } else if ((new Object() {
          public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null)
              return tileEntity.getTileData().getString(tag); 
            return "";
          }
        }).getValue(new BlockPos(x, y, z), "recipeName").equals("yogsothothium_ore")) {
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("gct_all:chant_abyss")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setBoolean("work", true); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", (new Object() {
                  public double getValue(BlockPos pos, String tag) {
                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity != null)
                      return tileEntity.getTileData().getDouble(tag); 
                    return -1.0D;
                  }
                }).getValue(new BlockPos(x, y, z), "timer") + 1.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (world instanceof WorldServer)
          ((WorldServer)world).spawnParticle(EnumParticleTypes.LAVA, (x + 0), y + 11.0D - (new Object() {
                public double getValue(BlockPos pos, String tag) {
                  TileEntity tileEntity = world.getTileEntity(pos);
                  if (tileEntity != null)
                    return tileEntity.getTileData().getDouble(tag); 
                  return -1.0D;
                }
              }).getValue(new BlockPos(x, y, z), "timer") / 4.0D, (z - 0), 30, 0.0D, 0.0D, 0.0D, 0.8D, new int[0]); 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") > 40.0D && 
          !world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", 0.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") == 40.0D)
          if (world.getBlockState(new BlockPos(x + 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
            .getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x - 3, y + 5, z + 0))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z + 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z - 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 1, z + 0))
            .getBlock() == BlockYogsothothiumOreComplex.block.getDefaultState().getBlock()) {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.setBlockState(new BlockPos(x, y + 1, z), BlockYogsothothiumOre.block.getDefaultState(), 3);
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          } else {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.destroyBlock(new BlockPos(x, y + 1, z), false);
            world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "effect @a[r=16] gct_all:abyssplague 15 0 false"); 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          }  
      } else if ((new Object() {
          public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null)
              return tileEntity.getTileData().getString(tag); 
            return "";
          }
        }).getValue(new BlockPos(x, y, z), "recipeName").equals("shubniggurathium_ore")) {
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("gct_all:chant_abyss")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setBoolean("work", true); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", (new Object() {
                  public double getValue(BlockPos pos, String tag) {
                    TileEntity tileEntity = world.getTileEntity(pos);
                    if (tileEntity != null)
                      return tileEntity.getTileData().getDouble(tag); 
                    return -1.0D;
                  }
                }).getValue(new BlockPos(x, y, z), "timer") + 1.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (world instanceof WorldServer)
          ((WorldServer)world).spawnParticle(EnumParticleTypes.LAVA, (x + 0), y + 11.0D - (new Object() {
                public double getValue(BlockPos pos, String tag) {
                  TileEntity tileEntity = world.getTileEntity(pos);
                  if (tileEntity != null)
                    return tileEntity.getTileData().getDouble(tag); 
                  return -1.0D;
                }
              }).getValue(new BlockPos(x, y, z), "timer") / 4.0D, (z - 0), 30, 0.0D, 0.0D, 0.0D, 0.8D, new int[0]); 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") > 40.0D && 
          !world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", 0.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if ((new Object() {
            public double getValue(BlockPos pos, String tag) {
              TileEntity tileEntity = world.getTileEntity(pos);
              if (tileEntity != null)
                return tileEntity.getTileData().getDouble(tag); 
              return -1.0D;
            }
          }).getValue(new BlockPos(x, y, z), "timer") == 40.0D)
          if (world.getBlockState(new BlockPos(x + 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
            .getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x - 3, y + 5, z + 0))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z + 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 5, z - 3))
            .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock() && world
            .getBlockState(new BlockPos(x + 0, y + 1, z + 0))
            .getBlock() == BlockShubniggurathiumOreComplex.block.getDefaultState().getBlock()) {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.setBlockState(new BlockPos(x, y + 1, z), BlockShubniggurathiumOre.block.getDefaultState(), 3);
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          } else {
            world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
            world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
            world.destroyBlock(new BlockPos(x, y + 1, z), false);
            world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
            if (!world.isRemote && world.getMinecraftServer() != null)
              ServerCommands.run(world, x, y, z, "effect @a[r=16] gct_all:abyssplague 15 0 false"); 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setString("recipeName", ""); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setBoolean("work", false); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
            if (!world.isRemote) {
              BlockPos _bp = new BlockPos(x, y, z);
              TileEntity _tileEntity = world.getTileEntity(_bp);
              IBlockState _bs = world.getBlockState(_bp);
              if (_tileEntity != null)
                _tileEntity.getTileData().setDouble("timer", 0.0D); 
              world.notifyBlockUpdate(_bp, _bs, _bs, 3);
            } 
          }  
      } else if ((new Object() {
          public String getValue(BlockPos pos, String tag) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity != null)
              return tileEntity.getTileData().getString(tag); 
            return "";
          }
        }).getValue(new BlockPos(x, y, z), "recipeName").equals("zjarugoth_summon")) {
        if (world.getBlockState(new BlockPos(x + 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
          .getDefaultState().getBlock() && world
          .getBlockState(new BlockPos(x - 3, y + 5, z + 0)).getBlock() == BlockSolidPotEnergy.block
          .getDefaultState().getBlock() && world
          .getBlockState(new BlockPos(x + 0, y + 5, z + 3)).getBlock() == BlockSolidPotEnergy.block
          .getDefaultState().getBlock() && world
          .getBlockState(new BlockPos(x + 0, y + 5, z - 3))
          .getBlock() == BlockSolidPotEnergy.block.getDefaultState().getBlock()) {
          world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
          world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
          world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
          world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
          if (!world.isRemote && world.getMinecraftServer() != null)
            ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Ahf' ymg' ah ah geb? llll epgoka ehye!\"}]"); 
          if (!world.isRemote) {
            EntityZjarugoth.EntityCustom entityCustom = new EntityZjarugoth.EntityCustom(world);
            if (entityCustom != null) {
              entityCustom.setLocationAndAngles(x, (y + 16), z, world.rand.nextFloat() * 360.0F, 0.0F);
              world.spawnEntity((Entity)entityCustom);
            } 
          } 
          if (!world.isRemote) {
            BlockPos _bp = new BlockPos(x, y, z);
            TileEntity _tileEntity = world.getTileEntity(_bp);
            IBlockState _bs = world.getBlockState(_bp);
            if (_tileEntity != null)
              _tileEntity.getTileData().setString("recipeName", ""); 
            world.notifyBlockUpdate(_bp, _bs, _bs, 3);
          } 
        } else {
          world.destroyBlock(new BlockPos(x + 3, y + 5, z + 0), false);
          world.destroyBlock(new BlockPos(x - 3, y + 5, z + 0), false);
          world.destroyBlock(new BlockPos(x + 0, y + 5, z + 3), false);
          world.destroyBlock(new BlockPos(x + 0, y + 5, z - 3), false);
          world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
          if (!world.isRemote && world.getMinecraftServer() != null)
            ServerCommands.run(world, x, y, z, "effect @a[r=16] gct_all:abyssplague 15 0 false"); 
          if (!world.isRemote) {
            BlockPos _bp = new BlockPos(x, y, z);
            TileEntity _tileEntity = world.getTileEntity(_bp);
            IBlockState _bs = world.getBlockState(_bp);
            if (_tileEntity != null)
              _tileEntity.getTileData().setString("recipeName", ""); 
            world.notifyBlockUpdate(_bp, _bs, _bs, 3);
          } 
        } 
      } else {
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setBoolean("work", false); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
        if (!world.isRemote) {
          BlockPos _bp = new BlockPos(x, y, z);
          TileEntity _tileEntity = world.getTileEntity(_bp);
          IBlockState _bs = world.getBlockState(_bp);
          if (_tileEntity != null)
            _tileEntity.getTileData().setDouble("timer", 0.0D); 
          world.notifyBlockUpdate(_bp, _bs, _bs, 3);
        } 
      } 
    } else {
      if (!world.isRemote) {
        BlockPos _bp = new BlockPos(x, y, z);
        TileEntity _tileEntity = world.getTileEntity(_bp);
        IBlockState _bs = world.getBlockState(_bp);
        if (_tileEntity != null)
          _tileEntity.getTileData().setBoolean("work", false); 
        world.notifyBlockUpdate(_bp, _bs, _bs, 3);
      } 
      if (!world.isRemote) {
        BlockPos _bp = new BlockPos(x, y, z);
        TileEntity _tileEntity = world.getTileEntity(_bp);
        IBlockState _bs = world.getBlockState(_bp);
        if (_tileEntity != null)
          _tileEntity.getTileData().setDouble("timer", 0.0D); 
        world.notifyBlockUpdate(_bp, _bs, _bs, 3);
      } 
    } 
  }
}

