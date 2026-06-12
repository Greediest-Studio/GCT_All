package com.gmm.gctall.common.blocks;

import com.gmm.gctall.common.events.AbyssLiquidMobplayerCollidesBlock;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAbyssLiquid extends BlockFluidClassic {
  private static final Fluid FLUID = registerFluid();

  public static final Block block = new BlockAbyssLiquid();
  public static final Item item = new ItemBlock(block);

  public BlockAbyssLiquid() {
    super(FLUID, Material.WATER);
    setTranslationKey("abyss_liquid");
  }

  public static void preInit(FMLPreInitializationEvent event) {
    FluidRegistry.addBucketForFluid(FLUID);
  }

  private static Fluid registerFluid() {
    Fluid fluid = new Fluid("abyss_liquid",
        new ResourceLocation("gct_all:blocks/cwater_still"),
        new ResourceLocation("gct_all:blocks/cwater_flow"))
        .setLuminosity(0)
        .setDensity(1000)
        .setViscosity(1000)
        .setGaseous(false);
    return FluidRegistry.registerFluid(fluid) ? fluid : FluidRegistry.getFluid(fluid.getName());
  }

  @Override
  public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
    super.onEntityCollision(world, pos, state, entity);
      AbyssLiquidMobplayerCollidesBlock.run(entity);
  }

  @SideOnly(Side.CLIENT)
  public static void registerModels(ModelRegistryEvent event) {
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

