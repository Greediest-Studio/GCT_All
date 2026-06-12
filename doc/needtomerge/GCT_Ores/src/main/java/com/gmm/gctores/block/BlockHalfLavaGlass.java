
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
public class BlockHalfLavaGlass extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:half_lava_glass")
    public static final Block block;
    
    public BlockHalfLavaGlass(final ElementsGctOresMod instance) {
        super(instance, 171);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("half_lava_glass"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockHalfLavaGlass.block).setRegistryName(BlockHalfLavaGlass.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockHalfLavaGlass.block), 0, new ModelResourceLocation("gct_ores:half_lava_glass", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.GLASS);
            this.setTranslationKey("half_lava_glass");
            this.setSoundType(SoundType.GLASS);
            this.setHardness(1.0f);
            this.setResistance(10.0f);
            this.setLightLevel(1.0f);
            this.setLightOpacity(0);
            this.setCreativeTab(TabCTabBuilding.tab);
        }
    }
}
