
package com.gmm.gctores.block;

import java.util.Map;
import com.gmm.gctores.procedure.ProcedureSenterianLabBuilderClick;
import java.util.HashMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
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
public class BlockSenterianBuilderLab extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:senterian_builder_lab")
    public static final Block block;
    
    public BlockSenterianBuilderLab(final ElementsGctOresMod instance) {
        super(instance, 467);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("senterian_builder_lab"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockSenterianBuilderLab.block).setRegistryName(BlockSenterianBuilderLab.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockSenterianBuilderLab.block), 0, new ModelResourceLocation("gct_ores:senterian_builder_lab", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("senterian_builder_lab");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 8);
            this.setHardness(1.0f);
            this.setResistance(10.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTab.tab);
        }
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u53ea\u80fd\u5728\u9ed1\u5ca9\u8ff7\u5baby=21\u683c\u5904\u4f7f\u7528\uff01");
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
            ProcedureSenterianLabBuilderClick.executeProcedure($_dependencies);
            return true;
        }
    }
}
