package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import com.gmm.gctall.procedure.ProcedureProEarthboundAltarClick;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
public class BlockEarthboundAltar extends GctAllElement {
  @ObjectHolder("gct_all:earthbound_altar")
  public static final Block block = null;
  
  public BlockEarthboundAltar(GctAllContent instance) {
    super(instance, 369);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("earthbound_altar"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.registerTileEntity(TileEntityCustom.class, "gct_all:tileentityearthbound_altar");
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "earthbound_altar");
  }
  
  public static class BlockCustom extends Block implements ITileEntityProvider {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("earthbound_altar");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 5);
      setHardness(10.0F);
      setResistance(10.0F);
      setLightLevel(0.0F);
      setLightOpacity(0);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
    }
    
    public boolean isFullCube(IBlockState state) {
      return false;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
      return (new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D)).union(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.7D, 1.0D));
    }
    
    public boolean isOpaqueCube(IBlockState state) {
      return false;
    }
    
    public TileEntity createNewTileEntity(World worldIn, int meta) {
      return (TileEntity)new BlockEarthboundAltar.TileEntityCustom();
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
      if (tileentity instanceof BlockEarthboundAltar.TileEntityCustom)
        InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity); 
      world.removeTileEntity(pos);
      super.breakBlock(world, pos, state);
    }
    
    public boolean hasComparatorInputOverride(IBlockState state) {
      return true;
    }
    
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof BlockEarthboundAltar.TileEntityCustom)
        return Container.calcRedstoneFromInventory((IInventory)tileentity); 
      return 0;
    }
    
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction, float hitX, float hitY, float hitZ) {
      super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("entity", entity);
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", world);
      ProcedureProEarthboundAltarClick.executeProcedure($_dependencies);
      return true;
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
      return "container.earthbound_altar";
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
      return "gct_all:earthbound_altar";
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

