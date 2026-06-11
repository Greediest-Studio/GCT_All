package com.gmm.gctall.block;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureReditriteBlockDestroy;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockReditriteBlock extends Block {
    public static final Block block = new BlockReditriteBlock();

    public BlockReditriteBlock() {
    super(Material.ROCK);
    this.setTranslationKey("reditrite_block");
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 6);
    this.setHardness(50.0f);
    this.setResistance(4000.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);

    }



    public int quantityDropped(final Random random) {
    return 0;
    }

    public boolean removedByPlayer(final IBlockState state, final World world, final BlockPos pos, final EntityPlayer entity, final boolean willHarvest) {
    final boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest);
    final int x = pos.getX();
    final int y = pos.getY();
    final int z = pos.getZ();
    final Map<String, Object> $_dependencies = new HashMap<String, Object>();
    $_dependencies.put("entity", entity);
    $_dependencies.put("x", x);
    $_dependencies.put("y", y);
    $_dependencies.put("z", z);
    $_dependencies.put("world", world);
    ProcedureReditriteBlockDestroy.executeProcedure($_dependencies);
    return retval;
    }

}