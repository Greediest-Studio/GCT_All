package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.google.common.collect.Multimap;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class ItemEarthOrb extends GctAllElement {
  @ObjectHolder("gct_all:earth_orb")
  public static final Item block = null;
  
  public ItemEarthOrb(GctAllContent instance) {
    super(instance, 371);
  }
  
  public void initElements() {
    this.elements.items.add(() -> ((Item)(new ItemToolCustom() {
          @SideOnly(Side.CLIENT)
          public boolean hasEffect(ItemStack itemstack) {
            return true;
          }
        }).setTranslationKey("earth_orb").setRegistryName("earth_orb")).setCreativeTab(GctAllCreativeTab.TAB));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerItemModel(block, "earth_orb");
  }
  
  private static class ItemToolCustom extends Item {
    protected ItemToolCustom() {
      setMaxDamage(16);
      setMaxStackSize(1);
    }
    
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
      Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
      if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", -4.0D, 0));
        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -4.0D, 0));
      } 
      return multimap;
    }
    
    public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
      return 0.0F;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
      stack.damageItem(1, entityLiving);
      return true;
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
      stack.damageItem(2, attacker);
      return true;
    }
    
    public boolean isFull3D() {
      return true;
    }
    
    public int getItemEnchantability() {
      return 2;
    }
  }
}

