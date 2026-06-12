
package com.gmm.gctores.block;

import net.minecraft.inventory.ContainerChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.tileentity.TileEntityLockableLoot;
import java.util.Map;
import com.gmm.gctores.procedure.ProcedureSenterianSummonerSummon;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import com.gmm.gctores.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.ITileEntityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockSenterianSummoner extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:senterian_summoner")
    public static final Block block;
    
    public BlockSenterianSummoner(final ElementsGctOresMod instance) {
        super(instance, 462);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("senterian_summoner"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockSenterianSummoner.block).setRegistryName(BlockSenterianSummoner.block.getRegistryName()));
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.registerTileEntity((Class)TileEntityCustom.class, "gct_ores:tileentitysenterian_summoner");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockSenterianSummoner.block), 0, new ModelResourceLocation("gct_ores:senterian_summoner", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block implements ITileEntityProvider
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("senterian_summoner");
            this.setSoundType(SoundType.STONE);
            this.setHardness(1.0f);
            this.setResistance(10.0f);
            this.setLightLevel(0.6666667f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTab.tab);
            this.setBlockUnbreakable();
        }
        
        public TileEntity createNewTileEntity(final World worldIn, final int meta) {
            return (TileEntity)new TileEntityCustom();
        }
        
        public boolean eventReceived(final IBlockState state, final World worldIn, final BlockPos pos, final int eventID, final int eventParam) {
            super.eventReceived(state, worldIn, pos, eventID, eventParam);
            final TileEntity tileentity = worldIn.getTileEntity(pos);
            return tileentity != null && tileentity.receiveClientEvent(eventID, eventParam);
        }
        
        public EnumBlockRenderType getRenderType(final IBlockState state) {
            return EnumBlockRenderType.MODEL;
        }
        
        public void breakBlock(final World world, final BlockPos pos, final IBlockState state) {
            final TileEntity tileentity = world.getTileEntity(pos);
            if (tileentity instanceof TileEntityCustom) {
                InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity);
            }
            world.removeTileEntity(pos);
            super.breakBlock(world, pos, state);
        }
        
        public boolean hasComparatorInputOverride(final IBlockState state) {
            return true;
        }
        
        public int getComparatorInputOverride(final IBlockState blockState, final World worldIn, final BlockPos pos) {
            final TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityCustom) {
                return Container.calcRedstoneFromInventory((IInventory)tileentity);
            }
            return 0;
        }
        
        public void onBlockAdded(final World world, final BlockPos pos, final IBlockState state) {
            super.onBlockAdded(world, pos, state);
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            world.scheduleUpdate(new BlockPos(x, y, z), (Block)this, this.tickRate(world));
        }
        
        public void updateTick(final World world, final BlockPos pos, final IBlockState state, final Random random) {
            super.updateTick(world, pos, state, random);
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            final Map<String, Object> $_dependencies = new HashMap<String, Object>();
            $_dependencies.put("x", x);
            $_dependencies.put("y", y);
            $_dependencies.put("z", z);
            $_dependencies.put("world", world);
            ProcedureSenterianSummonerSummon.executeProcedure($_dependencies);
            world.scheduleUpdate(new BlockPos(x, y, z), (Block)this, this.tickRate(world));
        }
    }
    
    public static class TileEntityCustom extends TileEntityLockableLoot
    {
        private NonNullList<ItemStack> stacks;
        
        public TileEntityCustom() {
            this.stacks = NonNullList.withSize(9, ItemStack.EMPTY);
        }
        
        public int getSizeInventory() {
            return 9;
        }
        
        public boolean isEmpty() {
            for (final ItemStack itemstack : this.stacks) {
                if (!itemstack.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        
        public boolean isItemValidForSlot(final int index, final ItemStack stack) {
            return true;
        }
        
        public ItemStack getStackInSlot(final int slot) {
            return (ItemStack)this.stacks.get(slot);
        }
        
        public String getName() {
            return "container.senterian_summoner";
        }
        
        public void readFromNBT(final NBTTagCompound compound) {
            super.readFromNBT(compound);
            this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
            if (!this.checkLootAndRead(compound)) {
                ItemStackHelper.loadAllItems(compound, (NonNullList)this.stacks);
            }
        }
        
        public NBTTagCompound writeToNBT(final NBTTagCompound compound) {
            super.writeToNBT(compound);
            if (!this.checkLootAndWrite(compound)) {
                ItemStackHelper.saveAllItems(compound, (NonNullList)this.stacks);
            }
            return compound;
        }
        
        public SPacketUpdateTileEntity getUpdatePacket() {
            return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
        }
        
        public NBTTagCompound getUpdateTag() {
            return this.writeToNBT(new NBTTagCompound());
        }
        
        public void onDataPacket(final NetworkManager net, final SPacketUpdateTileEntity pkt) {
            this.readFromNBT(pkt.getNbtCompound());
        }
        
        public void handleUpdateTag(final NBTTagCompound tag) {
            this.readFromNBT(tag);
        }
        
        public int getInventoryStackLimit() {
            return 64;
        }
        
        public String getGuiID() {
            return "gct_ores:senterian_summoner";
        }
        
        public Container createContainer(final InventoryPlayer playerInventory, final EntityPlayer playerIn) {
            this.fillWithLoot(playerIn);
            return (Container)new ContainerChest((IInventory)playerInventory, (IInventory)this, playerIn);
        }
        
        protected NonNullList<ItemStack> getItems() {
            return this.stacks;
        }
    }
}
