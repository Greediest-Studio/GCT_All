
package com.gmm.gctores.item;

import java.util.Map;
import com.gmm.gctores.procedure.ProcedureCreepyWitherstormDollClick;
import java.util.HashMap;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
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
public class ItemCreepyWitherstormDoll extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:creepy_witherstorm_doll")
    public static final Item block;
    
    public ItemCreepyWitherstormDoll(final ElementsGctOresMod instance) {
        super(instance, 157);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemCreepyWitherstormDoll.block, 0, new ModelResourceLocation("gct_ores:creepy_witherstorm_doll", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 1;
            this.setTranslationKey("creepy_witherstorm_doll");
            this.setRegistryName("creepy_witherstorm_doll");
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
            list.add("\u4e5f\u633a\u53ef\u7231\u7684\u2026\u2026");
            list.add("\u5b83\u5931\u53bb\u4e86\u4f20\u9001\u7684\u80fd\u529b\uff0c\u4e0d\u8fc7\u53ef\u4ee5\u53ec\u5524\u51cb\u7075\u98ce\u66b4\uff01");
        }
        
        public ActionResult<ItemStack> onItemRightClick(final World world, final EntityPlayer entity, final EnumHand hand) {
            final ActionResult<ItemStack> ar = (ActionResult<ItemStack>)super.onItemRightClick(world, entity, hand);
            final ItemStack itemstack = (ItemStack)ar.getResult();
            final int x = (int)entity.posX;
            final int y = (int)entity.posY;
            final int z = (int)entity.posZ;
            final Map<String, Object> $_dependencies = new HashMap<String, Object>();
            $_dependencies.put("entity", entity);
            $_dependencies.put("x", x);
            $_dependencies.put("y", y);
            $_dependencies.put("z", z);
            $_dependencies.put("world", world);
            ProcedureCreepyWitherstormDollClick.executeProcedure($_dependencies);
            return ar;
        }
    }
}
