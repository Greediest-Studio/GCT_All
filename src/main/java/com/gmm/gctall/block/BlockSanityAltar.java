package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.gui.GuiGUISanityAltar;
import com.gmm.gctall.procedure.ProcedureSanityAltarNeighbourBlockChanges;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockSanityAltar extends GctAllElement {
  @ObjectHolder("gct_all:sanity_altar")
  public static final Block block = null;
  
  public BlockSanityAltar(GctAllContent instance) {
    super(instance, 26);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "sanity_altar");
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.registerTileEntity(TileEntityCustom.class, "gct_all:tileentitysanity_altar");
  }
  
  
  public static class BlockCustom extends Block implements ITileEntityProvider {
    public BlockCustom() {
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
      return (TileEntity)new BlockSanityAltar.TileEntityCustom();
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
      if (tileentity instanceof BlockSanityAltar.TileEntityCustom)
        InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity); 
      world.removeTileEntity(pos);
      super.breakBlock(world, pos, state);
    }
    
    public boolean hasComparatorInputOverride(IBlockState state) {
      return true;
    }
    
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof BlockSanityAltar.TileEntityCustom)
        return Container.calcRedstoneFromInventory((IInventory)tileentity); 
      return 0;
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
      ProcedureSanityAltarNeighbourBlockChanges.executeProcedure($_dependencies);
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
  
  public static class TileEntityCustom extends TileEntityLockableLoot {
    private NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
    
    public int getSizeInventory() {
      return 1;
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
      return "container.sanity_altar";
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
      return 1;
    }
    
    public String getGuiID() {
      return "gct_all:sanity_altar";
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
      return (Container)new GuiGUISanityAltar.GuiContainerMod(getWorld(), getPos().getX(), getPos().getY(), getPos().getZ(), playerIn);
    }
    
    protected NonNullList<ItemStack> getItems() {
      return this.stacks;
    }
  }
}

