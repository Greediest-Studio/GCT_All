package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureKeyOfWarpedRightClickedOnBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class ItemKeyOfWarpedActive extends GctAllElement {
  @ObjectHolder("gct_all:key_of_warped_active")
  public static final Item block = null;
  
  public ItemKeyOfWarpedActive(GctAllContent instance) {
    super(instance, 34);
  }
  
  public void initElements() {
    registerItem(ItemCustom::new, "key_of_warped_active");
  }
  
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 1;
      setTranslationKey("key_of_warped_active");
      setRegistryName("key_of_warped_active");
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public int getItemEnchantability() {
      return 0;
    }
    
    public int getMaxItemUseDuration(ItemStack itemstack) {
      return 0;
    }
    
    public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
      return 1.0F;
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A72\u8352\u829C\uFF0C\u626D\u66F2\u7684\u8BE1\u5F02\u4E4B\u5730");
    }
    
    public EnumActionResult onItemUseFirst(EntityPlayer entity, World world, BlockPos pos, EnumFacing direction,
        float hitX, float hitY, float hitZ, EnumHand hand) {
      return useKey(entity, world, pos, hand, direction);
    }

    public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand,
        EnumFacing direction, float hitX, float hitY, float hitZ) {
      return useKey(entity, world, pos, hand, direction);
    }

    private EnumActionResult useKey(EntityPlayer entity, World world, BlockPos pos, EnumHand hand,
        EnumFacing direction) {
      ItemStack itemstack = entity.getHeldItem(hand);
      if (!entity.canPlayerEdit(pos, direction, itemstack))
        return EnumActionResult.FAIL;
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("entity", entity);
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", world);
      return ProcedureKeyOfWarpedRightClickedOnBlock.executeProcedure($_dependencies) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }
  }
}

