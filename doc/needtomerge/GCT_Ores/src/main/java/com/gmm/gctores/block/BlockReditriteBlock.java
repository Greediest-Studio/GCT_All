
package com.gmm.gctores.block;

import java.util.Map;
import com.gmm.gctores.procedure.ProcedureReditriteBlockDestroy;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import com.gmm.gctores.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
public class BlockReditriteBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:reditrite_block")
    public static final Block block;
    
    public BlockReditriteBlock(final ElementsGctOresMod instance) {
        super(instance, 34);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("reditrite_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockReditriteBlock.block).setRegistryName(BlockReditriteBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockReditriteBlock.block), 0, new ModelResourceLocation("gct_ores:reditrite_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
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
}
