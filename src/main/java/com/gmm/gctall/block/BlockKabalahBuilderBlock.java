package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import com.gmm.gctall.gui.GuiKabalahBuilder;
import com.gmm.gctall.procedure.ProcedureProKabalahBuilderRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockKabalahBuilderBlock extends GctAllElement {
  @ObjectHolder("gct_all:kabalah_builder_block")
  public static final Block block = null;
  
  public BlockKabalahBuilderBlock(GctAllContent instance) {
    super(instance, 267);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("kabalah_builder_block"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.registerTileEntity(TileEntityCustom.class, "gct_all:tileentitykabalah_builder_block");
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "kabalah_builder_block");
  }
  
  public static class BlockCustom extends Block implements ITileEntityProvider {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("kabalah_builder_block");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 10);
      setHardness(5.0F);
      setResistance(4000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public TileEntity createNewTileEntity(World worldIn, int meta) {
      return (TileEntity)new BlockKabalahBuilderBlock.TileEntityCustom();
    }
    
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
      super.eventReceived(state, worldIn, pos, eventID, eventParam);
      TileEntity tileentity = worldIn.getTileEntity(pos);
      return (tileentity == null) ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
    
    public EnumBlockRenderType getRenderType(IBlockState state) {
      return EnumBlockRenderType.MODEL;
    }
    
    public boolean hasComparatorInputOverride(IBlockState state) {
      return true;
    }
    
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
      TileEntity tileentity = worldIn.getTileEntity(pos);
      if (tileentity instanceof BlockKabalahBuilderBlock.TileEntityCustom)
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
      ProcedureProKabalahBuilderRecipe.executeProcedure($_dependencies);
      world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
    }
    
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction, float hitX, float hitY, float hitZ) {
      super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      if (entity instanceof EntityPlayer)
        entity.openGui(GctAllMod.INSTANCE, GuiKabalahBuilder.GUIID, world, x, y, z); 
      return true;
    }
  }
  
  public static class TileEntityCustom extends TileEntityLockableLoot {
    private NonNullList<ItemStack> stacks = NonNullList.withSize(14, ItemStack.EMPTY);
    private boolean inputsConsumed;
    
    public int getSizeInventory() {
      return 14;
    }
    
    public boolean isEmpty() {
      for (ItemStack itemstack : this.stacks) {
        if (!itemstack.isEmpty())
          return false; 
      } 
      return true;
    }
    
    public boolean isItemValidForSlot(int index, ItemStack stack) {
      if (index == 13)
        return false; 
      return true;
    }
    
    public ItemStack getStackInSlot(int slot) {
      return (ItemStack)this.stacks.get(slot);
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
      if (index == 13) {
        if (stack != null && !stack.isEmpty()) {
          this.inputsConsumed = false;
        } else if (!getStackInSlot(13).isEmpty()) {
          consumeInputsOnce();
        }
      }
      super.setInventorySlotContents(index, stack);
    }

    public ItemStack decrStackSize(int index, int count) {
      ItemStack taken = super.decrStackSize(index, count);
      if (index == 13 && !taken.isEmpty() && getStackInSlot(13).isEmpty()) {
        consumeInputsOnce();
      }
      return taken;
    }
    
    public String getName() {
      return "container.kabalah_builder_block";
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
      return "gct_all:kabalah_builder_block";
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
      return (Container)new GuiKabalahBuilder.GuiContainerMod(getWorld(), getPos().getX(), getPos().getY(), getPos().getZ(), playerIn);
    }
    
    protected NonNullList<ItemStack> getItems() {
      return this.stacks;
    }

    private void consumeInputsOnce() {
      if (this.world == null || this.world.isRemote || this.inputsConsumed)
        return;
      this.inputsConsumed = true;
      for (int slot = 0; slot <= 9; slot++)
        decrStackSize(slot, 1);
    }
  }
}

