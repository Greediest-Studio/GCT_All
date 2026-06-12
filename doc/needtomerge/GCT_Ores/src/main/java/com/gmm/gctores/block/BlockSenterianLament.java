
package com.gmm.gctores.block;

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
public class BlockSenterianLament extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:senterian_lament")
    public static final Block block;
    
    public BlockSenterianLament(final ElementsGctOresMod instance) {
        super(instance, 460);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("senterian_lament"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockSenterianLament.block).setRegistryName(BlockSenterianLament.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockSenterianLament.block), 0, new ModelResourceLocation("gct_ores:senterian_lament", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("senterian_lament");
            this.setSoundType(SoundType.STONE);
            this.setHardness(1.0f);
            this.setResistance(4000.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTab.tab);
            this.setBlockUnbreakable();
        }
    }
}
