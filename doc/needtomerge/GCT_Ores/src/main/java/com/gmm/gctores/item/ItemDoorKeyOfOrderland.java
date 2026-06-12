
package com.gmm.gctores.item;

import java.util.Map;
import com.gmm.gctores.procedure.ProcedureDoorKeyOrderlandClick;
import java.util.HashMap;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.creativetab.TabCTabWitheric;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ItemDoorKeyOfOrderland extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:door_key_of_orderland")
    public static final Item block;
    
    public ItemDoorKeyOfOrderland(final ElementsGctOresMod instance) {
        super(instance, 159);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemDoorKeyOfOrderland.block, 0, new ModelResourceLocation("gct_ores:door_key_of_orderland", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 1;
            this.setTranslationKey("door_key_of_orderland");
            this.setRegistryName("door_key_of_orderland");
            this.setCreativeTab(TabCTabWitheric.tab);
        }
        
        public int getItemEnchantability() {
            return 0;
        }
        
        public int getMaxItemUseDuration(final ItemStack itemstack) {
            return 0;
        }
        
        public float getDestroySpeed(final ItemStack par1ItemStack, final IBlockState par2Block) {
            return 1.0f;
        }
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u53f3\u952e\u751f\u6210\u4e00\u4e2a\u79e9\u5e8f\u4e4b\u5730\u4f20\u9001\u95e8\uff01");
            list.add("\u53ea\u6709\u51fb\u8d25\u4e86\u51cb\u7075\u98ce\u66b4\u7684\u4eba\u624d\u6709\u8d44\u683c\u8fdb\u5165\u79e9\u5e8f\u4e4b\u5730\u2026\u2026");
        }
        
        public EnumActionResult onItemUseFirst(final EntityPlayer entity, final World world, final BlockPos pos, final EnumFacing direction, final float hitX, final float hitY, final float hitZ, final EnumHand hand) {
            final EnumActionResult retval = super.onItemUseFirst(entity, world, pos, direction, hitX, hitY, hitZ, hand);
            final ItemStack itemstack = entity.getHeldItem(hand);
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            final Map<String, Object> $_dependencies = new HashMap<String, Object>();
            $_dependencies.put("entity", entity);
            $_dependencies.put("x", x);
            $_dependencies.put("y", y);
            $_dependencies.put("z", z);
            $_dependencies.put("world", world);
            ProcedureDoorKeyOrderlandClick.executeProcedure($_dependencies);
            return retval;
        }
    }
}
