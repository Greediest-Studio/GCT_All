
package com.gmm.gctores.item;

import java.util.Map;
import com.gmm.gctores.procedure.ProcedureRNGRelinquisherClick;
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
public class ItemRNGRelinquisher extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:rng_relinquisher")
    public static final Item block;
    
    public ItemRNGRelinquisher(final ElementsGctOresMod instance) {
        super(instance, 158);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemRNGRelinquisher.block, 0, new ModelResourceLocation("gct_ores:rng_relinquisher", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 1;
            this.setTranslationKey("rng_relinquisher");
            this.setRegistryName("rng_relinquisher");
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
            list.add("\u5728\u672b\u5730\u539f\u70b9\u53f3\u952e\u4f20\u9001\u81f3\u65e0\u540d\u4e4b\u5730");
            list.add("\u5728\u65e0\u540d\u4e4b\u5730\u4efb\u610f\u5730\u70b9\u53f3\u952e\u4f20\u9001\u56de\u672b\u5730");
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
            ProcedureRNGRelinquisherClick.executeProcedure($_dependencies);
            return ar;
        }
    }
}
