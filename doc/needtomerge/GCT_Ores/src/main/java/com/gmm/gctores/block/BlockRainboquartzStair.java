
package com.gmm.gctores.block;

import net.minecraft.util.BlockRenderLayer;
import com.gmm.gctores.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockStairs;
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
public class BlockRainboquartzStair extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:rainboquartz_stair")
    public static final Block block;
    
    public BlockRainboquartzStair(final ElementsGctOresMod instance) {
        super(instance, 454);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("rainboquartz_stair"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockRainboquartzStair.block).setRegistryName(BlockRainboquartzStair.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockRainboquartzStair.block), 0, new ModelResourceLocation("gct_ores:rainboquartz_stair", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends BlockStairs
    {
        public BlockCustom() {
            super(new Block(Material.ROCK).getDefaultState());
            this.setTranslationKey("rainboquartz_stair");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 0);
            this.setHardness(2.0f);
            this.setResistance(20.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabBuilding.tab);
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT;
        }
    }
}
