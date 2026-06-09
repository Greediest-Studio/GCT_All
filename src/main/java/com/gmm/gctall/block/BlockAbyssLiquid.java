package com.gmm.gctall.block;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureAbyssLiquidMobplayerCollidesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockAbyssLiquid extends GctAllElement {
  @ObjectHolder("gct_all:abyss_liquid")
  public static final Block block = null;
  
  @ObjectHolder("gct_all:abyss_liquid")
  public static final Item item = null;
  
  private Fluid fluid;
  
  public BlockAbyssLiquid(GctAllContent instance) {
    super(instance, 39);
    this
      .fluid = (new Fluid("abyss_liquid", new ResourceLocation("gct_all:blocks/cwater_still"), new ResourceLocation("gct_all:blocks/cwater_flow"))).setLuminosity(0).setDensity(1000).setViscosity(1000).setGaseous(false);
  }
  
  public void initElements() {
    final Block[] registeredBlock = new Block[1];
    registerBlock(() -> {
      Block fluidBlock = (Block)(new BlockFluidClassic(this.fluid, Material.WATER) {
          public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
            super.onEntityCollision(world, pos, state, entity);
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            Map<String, Object> $_dependencies = new HashMap<>();
            $_dependencies.put("entity", entity);
            ProcedureAbyssLiquidMobplayerCollidesBlock.executeProcedure($_dependencies);
          }
        }).setTranslationKey("abyss_liquid").setRegistryName("abyss_liquid");
      registeredBlock[0] = fluidBlock;
      return fluidBlock;
    });
    registerItem(() -> (Item)(new ItemBlock(registeredBlock[0])).setRegistryName("abyss_liquid"));
  }
  
  public void preInit(FMLPreInitializationEvent event) {
    FluidRegistry.registerFluid(this.fluid);
    FluidRegistry.addBucketForFluid(this.fluid);
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    ModelBakery.registerItemVariants(item, new ResourceLocation[0]);
    ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
          public ModelResourceLocation getModelLocation(ItemStack stack) {
            return new ModelResourceLocation("gct_all:abyss_liquid", "abyss_liquid");
          }
        });
    ModelLoader.setCustomStateMapper(block, (IStateMapper)new StateMapperBase() {
          protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
            return new ModelResourceLocation("gct_all:abyss_liquid", "abyss_liquid");
          }
        });
  }
}

