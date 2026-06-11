package com.gmm.gctall.block;

import com.google.common.base.Predicate;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import com.gmm.gctall.item.ItemWitheriumDust;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockWitheriumOreEnd extends Block {
    public static final Block block = new BlockWitheriumOreEnd();

    public BlockWitheriumOreEnd() {
        super(Material.ROCK);
        setTranslationKey("witherium_ore_end");
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 8);
        setHardness(5.0F);
        setResistance(20.0F);
        setLightLevel(0.06666667F);
        setLightOpacity(15);
        setCreativeTab(TabCTabWitheric.tab);
    }

    public static void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID,
            IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (dimID != 1) {
            return;
        }
        for (int i = 0; i < 8; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(255);
            int z = chunkZ + random.nextInt(16);
            new WorldGenMinable(block.getDefaultState(), 4, new Predicate<IBlockState>() {
                @Override
                public boolean apply(IBlockState blockAt) {
                    return blockAt.getBlock() == Blocks.END_STONE;
                }
            }).generate(world, random, new BlockPos(x, y, z));
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(ItemWitheriumDust.block, 3));
    }
}
