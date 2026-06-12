
package com.gmm.gctores.block;

import net.minecraft.inventory.ContainerChest;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import net.minecraft.util.NonNullList;
import net.minecraft.tileentity.TileEntityLockableLoot;
import java.util.Map;
import com.gmm.gctores.procedure.ProcedureFinalliumContainerRightclick;
import java.util.HashMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.client.Minecraft;
import java.util.Random;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
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

@ModElement.Tag
public class BlockFinalliumContainer extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:finallium_container")
    public static final Block block;
    
    public BlockFinalliumContainer(final ElementsGctOresMod instance) {
        super(instance, 491);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("finallium_container"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockFinalliumContainer.block).setRegistryName(BlockFinalliumContainer.block.getRegistryName()));
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.registerTileEntity((Class)TileEntityCustom.class, "gct_ores:tileentityfinallium_container");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockFinalliumContainer.block), 0, new ModelResourceLocation("gct_ores:finallium_container", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block implements ITileEntityProvider
    {
        public BlockCustom() {
            super(Material.IRON);
            this.setTranslationKey("finallium_container");
            this.setSoundType(SoundType.METAL);
            this.setHarvestLevel("pickaxe", 13);
            this.setHardness(50.0f);
            this.setResistance(10000.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(0);
            this.setCreativeTab(TabCTab.tab);
        }
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u51dd\u805a\u80fd\u91cf");
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT_MIPPED;
        }
        
        public boolean isOpaqueCube(final IBlockState state) {
            return false;
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
        
        @SideOnly(Side.CLIENT)
        public void randomDisplayTick(final IBlockState state, final World world, final BlockPos pos, final Random random) {
            super.randomDisplayTick(state, world, pos, random);
            final EntityPlayer entity = (EntityPlayer)Minecraft.getMinecraft().player;
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            final int i = x;
            final int j = y;
            final int k = z;
            for (int l = 0; l < 4; ++l) {
                final double d0 = i + random.nextFloat();
                final double d2 = j + random.nextFloat();
                final double d3 = k + random.nextFloat();
                final int i2 = random.nextInt(2) * 2 - 1;
                final double d4 = (random.nextFloat() - 0.5) * 0.5;
                final double d5 = (random.nextFloat() - 0.5) * 0.5;
                final double d6 = (random.nextFloat() - 0.5) * 0.5;
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d2, d3, d4, d5, d6, new int[0]);
            }
        }
        
        public boolean onBlockActivated(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer entity, final EnumHand hand, final EnumFacing direction, final float hitX, final float hitY, final float hitZ) {
            super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            final Map<String, Object> $_dependencies = new HashMap<String, Object>();
            $_dependencies.put("entity", entity);
            $_dependencies.put("x", x);
            $_dependencies.put("y", y);
            $_dependencies.put("z", z);
            $_dependencies.put("world", world);
            ProcedureFinalliumContainerRightclick.executeProcedure($_dependencies);
            return true;
        }
    }
    
    public static class TileEntityCustom extends TileEntityLockableLoot
    {
        private NonNullList<ItemStack> stacks;
        
        public TileEntityCustom() {
            this.stacks = NonNullList.withSize(1, ItemStack.EMPTY);
        }
        
        public int getSizeInventory() {
            return 1;
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
            return "container.finallium_container";
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
            return 1;
        }
        
        public String getGuiID() {
            return "gct_ores:finallium_container";
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
