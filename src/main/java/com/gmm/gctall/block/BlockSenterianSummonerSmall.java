package com.gmm.gctall.block;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureSenterianSummonerSmallSummon;
import java.util.HashMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockSenterianSummonerSmall extends Block {
    public static final Block block = new BlockSenterianSummonerSmall();

    public BlockSenterianSummonerSmall() {
    super(Material.ROCK);
    this.setTranslationKey("senterian_summoner_small");
    this.setSoundType(SoundType.STONE);
    this.setHardness(1.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.6666667f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);
    this.setBlockUnbreakable();

    }



    public boolean onBlockActivated(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer entity, final EnumHand hand, final EnumFacing direction, final float hitX, final float hitY, final float hitZ) {
    super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
    final int x = pos.getX();
    final int y = pos.getY();
    final int z = pos.getZ();
    final Map<String, Object> $_dependencies = new HashMap<String, Object>();
    $_dependencies.put("x", x);
    $_dependencies.put("y", y);
    $_dependencies.put("z", z);
    $_dependencies.put("world", world);
    ProcedureSenterianSummonerSmallSummon.executeProcedure($_dependencies);
    return true;
    }

}