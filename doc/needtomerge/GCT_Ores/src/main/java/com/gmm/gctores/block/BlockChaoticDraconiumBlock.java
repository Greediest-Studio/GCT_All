
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
public class BlockChaoticDraconiumBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:chaotic_draconium_block")
    public static final Block block;
    
    public BlockChaoticDraconiumBlock(final ElementsGctOresMod instance) {
        super(instance, 39);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("chaotic_draconium_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockChaoticDraconiumBlock.block).setRegistryName(BlockChaoticDraconiumBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockChaoticDraconiumBlock.block), 0, new ModelResourceLocation("gct_ores:chaotic_draconium_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.IRON);
            this.setTranslationKey("chaotic_draconium_block");
            this.setSoundType(SoundType.METAL);
            this.setHarvestLevel("pickaxe", 10);
            this.setHardness(30.0f);
            this.setResistance(4000.0f);
            this.setLightLevel(0.06666667f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTab.tab);
        }
    }
}
