package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class ItemElfPasses extends GctAllElement {
  @ObjectHolder("gct_all:elf_passes")
  public static final Item block = null;
  
  public ItemElfPasses(GctAllContent instance) {
    super(instance, 295);
  }
  
  public void initElements() {
    this.elements.items.add(() -> new ItemCustom());
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerItemModel(block, "elf_passes");
  }
  
  public static class ItemCustom extends Item {
    public ItemCustom() {
      setMaxDamage(0);
      this.maxStackSize = 64;
      setTranslationKey("elf_passes");
      setRegistryName("elf_passes");
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
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack) {
      return true;
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u53F3\u952E\u7CBE\u7075\u53EF\u4EE5\u5F97\u5230\u81EA\u7136\u7ED3\u6676\u788E\u7247");
    }
  }
}

