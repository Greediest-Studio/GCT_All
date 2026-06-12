
package com.gmm.gctores.block;

import com.gmm.gctores.creativetab.TabCTabWitheric;
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
public class BlockStormyWitheriumBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:stormy_witherium_block")
    public static final Block block;
    
    public BlockStormyWitheriumBlock(final ElementsGctOresMod instance) {
        super(instance, 97);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("stormy_witherium_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockStormyWitheriumBlock.block).setRegistryName(BlockStormyWitheriumBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockStormyWitheriumBlock.block), 0, new ModelResourceLocation("gct_ores:stormy_witherium_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.IRON);
            this.setTranslationKey("stormy_witherium_block");
            this.setSoundType(SoundType.METAL);
            this.setHarvestLevel("pickaxe", 10);
            this.setHardness(30.0f);
            this.setResistance(4000.0f);
            this.setLightLevel(0.06666667f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabWitheric.tab);
        }
    }
}
