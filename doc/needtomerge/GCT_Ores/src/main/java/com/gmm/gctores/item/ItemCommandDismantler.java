
package com.gmm.gctores.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import com.google.common.collect.Multimap;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import com.gmm.gctores.creativetab.TabCTab;
import net.minecraft.item.ItemStack;
import java.util.Map;
import com.gmm.gctores.procedure.ProcedureCommandDismantlerClick;
import java.util.HashMap;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ItemCommandDismantler extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:command_dismantler")
    public static final Item block;
    
    public ItemCommandDismantler(final ElementsGctOresMod instance) {
        super(instance, 83);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> ((Item)new ItemToolCustom() {
            public EnumActionResult onItemUse(final EntityPlayer entity, final World world, final BlockPos pos, final EnumHand hand, final EnumFacing direction, final float hitX, final float hitY, final float hitZ) {
                final EnumActionResult retval = super.onItemUse(entity, world, pos, hand, direction, hitX, hitY, hitZ);
                final int x = pos.getX();
                final int y = pos.getY();
                final int z = pos.getZ();
                final ItemStack itemstack = entity.getHeldItem(hand);
                final Map $_dependencies = new HashMap();
                $_dependencies.put("entity", entity);
                $_dependencies.put("itemstack", itemstack);
                $_dependencies.put("x", x);
                $_dependencies.put("y", y);
                $_dependencies.put("z", z);
                $_dependencies.put("world", world);
                ProcedureCommandDismantlerClick.executeProcedure($_dependencies);
                return retval;
            }
        }.setTranslationKey("command_dismantler").setRegistryName("command_dismantler")).setCreativeTab(TabCTab.tab));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemCommandDismantler.block, 0, new ModelResourceLocation("gct_ores:command_dismantler", "inventory"));
    }
    
    static {
        block = null;
    }
    
    private static class ItemToolCustom extends Item
    {
        protected ItemToolCustom() {
            this.setMaxDamage(200);
            this.setMaxStackSize(1);
        }
        
        public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot equipmentSlot) {
            final Multimap<String, AttributeModifier> multimap = (Multimap<String, AttributeModifier>)super.getItemAttributeModifiers(equipmentSlot);
            if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
                multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ItemToolCustom.ATTACK_DAMAGE_MODIFIER, "Tool modifier", 0.0, 0));
                multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ItemToolCustom.ATTACK_SPEED_MODIFIER, "Tool modifier", -3.0, 0));
            }
            return multimap;
        }
        
        public float getDestroySpeed(final ItemStack par1ItemStack, final IBlockState par2Block) {
            return 0.0f;
        }
        
        public boolean onBlockDestroyed(final ItemStack stack, final World worldIn, final IBlockState state, final BlockPos pos, final EntityLivingBase entityLiving) {
            stack.damageItem(1, entityLiving);
            return true;
        }
        
        public boolean hitEntity(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker) {
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
