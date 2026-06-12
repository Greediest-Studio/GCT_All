
package com.gmm.gctores.block;

import com.gmm.gctores.creativetab.TabCTabBuilding;
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
public class BlockShalloiteBlockChiseled extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:shalloite_block_chiseled")
    public static final Block block;
    
    public BlockShalloiteBlockChiseled(final ElementsGctOresMod instance) {
        super(instance, 479);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("shalloite_block_chiseled"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockShalloiteBlockChiseled.block).setRegistryName(BlockShalloiteBlockChiseled.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockShalloiteBlockChiseled.block), 0, new ModelResourceLocation("gct_ores:shalloite_block_chiseled", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("shalloite_block_chiseled");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 0);
            this.setHardness(2.0f);
            this.setResistance(20.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabBuilding.tab);
        }
    }
}
