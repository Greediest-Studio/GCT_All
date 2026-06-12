
package com.gmm.gctores.block;

import com.gmm.gctores.item.ItemWitheriumDust;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import com.gmm.gctores.creativetab.TabCTabWitheric;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockWitheriumOreEnd extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:witherium_ore_end")
    public static final Block block;
    
    public BlockWitheriumOreEnd(final ElementsGctOresMod instance) {
        super(instance, 90);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("witherium_ore_end"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockWitheriumOreEnd.block).setRegistryName(BlockWitheriumOreEnd.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockWitheriumOreEnd.block), 0, new ModelResourceLocation("gct_ores:witherium_ore_end", "inventory"));
    }
    
    @Override
    public void generateWorld(final Random random, final int chunkX, final int chunkZ, final World world, final int dimID, final IChunkGenerator cg, final IChunkProvider cp) {
        boolean dimensionCriteria = false;
        if (dimID == 1) {
            dimensionCriteria = true;
        }
        if (!dimensionCriteria) {
            return;
        }
        for (int i = 0; i < 8; ++i) {
            final int x = chunkX + random.nextInt(16);
            final int y = random.nextInt(255) + 0;
            final int z = chunkZ + random.nextInt(16);
            new WorldGenMinable(BlockWitheriumOreEnd.block.getDefaultState(), 4, (Predicate)new Predicate<IBlockState>() {
                public boolean apply(final IBlockState blockAt) {
                    boolean blockCriteria = false;
                    if (blockAt.getBlock() == Blocks.END_STONE.getDefaultState().getBlock()) {
                        blockCriteria = true;
                    }
                    return blockCriteria;
                }
            }).generate(world, random, new BlockPos(x, y, z));
        }
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("witherium_ore_end");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 8);
            this.setHardness(5.0f);
            this.setResistance(20.0f);
            this.setLightLevel(0.06666667f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabWitheric.tab);
        }
        
        public void getDrops(final NonNullList<ItemStack> drops, final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
            drops.add(new ItemStack(ItemWitheriumDust.block, 3));
        }
    }
}
