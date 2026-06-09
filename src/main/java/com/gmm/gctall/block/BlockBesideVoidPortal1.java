package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import com.gmm.gctall.procedure.ProcedureProBesideVoidPortalUp;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockBesideVoidPortal1 extends GctAllElement {
  @ObjectHolder("gct_all:beside_void_portal_1")
  public static final Block block = null;
  
  public BlockBesideVoidPortal1(GctAllContent instance) {
    super(instance, 67);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("beside_void_portal_1"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.registerTileEntity(TileEntityCustom.class, "gct_all:tileentitybeside_void_portal_1");
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "beside_void_portal_1");
  }
  
  public static class BlockCustom extends Block implements ITileEntityProvider {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("beside_void_portal_1");
      setSoundType(SoundType.GLASS);
      setHardness(1.0F);
      setResistance(10.0F);
      setLightLevel(0.33333334F);
      setLightOpacity(0);
      setCreativeTab(GctAllCreativeTab.TAB);
      setBlockUnbreakable();
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
      return NULL_AABB;
    }
    
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
      return true;
    }
    
    public boolean isFullCube(IBlockState state) {
      return false;
    }
    
    public boolean isOpaqueCube(IBlockState state) {
      return false;
    }
    
    public TileEntity createNewTileEntity(World worldIn, int meta) {
      return (TileEntity)new BlockBesideVoidPortal1.TileEntityCustom();
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
      if (tileentity instanceof BlockBesideVoidPortal1.TileEntityCustom)
        InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity); 
      world.removeTileEntity(pos);
      super.breakBlock(world, pos, state);
    }
    
    public boolean hasComparatorInputOverride(IBlockState state) {
      return true;
    }
    
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof BlockBesideVoidPortal1.TileEntityCustom)
        return Container.calcRedstoneFromInventory((IInventory)tileentity); 
      return 0;
    }
    
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
      super.onBlockAdded(world, pos, state);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
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
      ProcedureProBesideVoidPortalUp.executeProcedure($_dependencies);
      world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
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
      for (int l = 0; l < 4; l++) {
        double d0 = i + 0.5D + (random.nextFloat() - 0.5D) * 0.5D * 20.0D;
        double d1 = j + 0.7D + (random.nextFloat() - 0.5D) * 0.5D + 0.5D;
        double d2 = k + 0.5D + (random.nextFloat() - 0.5D) * 0.5D * 20.0D;
        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
      } 
    }
  }
  
  public static class TileEntityCustom extends TileEntityLockableLoot {
    private NonNullList<ItemStack> stacks = NonNullList.withSize(9, ItemStack.EMPTY);
    
    public int getSizeInventory() {
      return 9;
    }
    
    public boolean isEmpty() {
      for (ItemStack itemstack : this.stacks) {
        if (!itemstack.isEmpty())
          return false; 
      } 
      return true;
    }
    
    public boolean isItemValidForSlot(int index, ItemStack stack) {
      return true;
    }
    
    public ItemStack getStackInSlot(int slot) {
      return (ItemStack)this.stacks.get(slot);
    }
    
    public String getName() {
      return "container.beside_void_portal_1";
    }
    
    public void readFromNBT(NBTTagCompound compound) {
      super.readFromNBT(compound);
      this.stacks = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
      if (!checkLootAndRead(compound))
        ItemStackHelper.loadAllItems(compound, this.stacks); 
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
      super.writeToNBT(compound);
      if (!checkLootAndWrite(compound))
        ItemStackHelper.saveAllItems(compound, this.stacks); 
      return compound;
    }
    
    public SPacketUpdateTileEntity getUpdatePacket() {
      return new SPacketUpdateTileEntity(this.pos, 0, getUpdateTag());
    }
    
    public NBTTagCompound getUpdateTag() {
      return writeToNBT(new NBTTagCompound());
    }
    
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
      readFromNBT(pkt.getNbtCompound());
    }
    
    public void handleUpdateTag(NBTTagCompound tag) {
      readFromNBT(tag);
    }
    
    public int getInventoryStackLimit() {
      return 64;
    }
    
    public String getGuiID() {
      return "gct_all:beside_void_portal_1";
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
      fillWithLoot(playerIn);
      return (Container)new ContainerChest((IInventory)playerInventory, (IInventory)this, playerIn);
    }
    
    protected NonNullList<ItemStack> getItems() {
      return this.stacks;
    }
  }
}

