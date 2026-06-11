
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureModeChanger;
import java.util.HashMap;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGreedycraftModChanger extends Item {
    public static final Item block = new ItemGreedycraftModChanger();

    public ItemGreedycraftModChanger() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("greedycraft_mod_changer");
        this.setRegistryName("greedycraft_mod_changer");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

    public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u53f3\u952e\u5728\u751f\u5b58\u548c\u521b\u9020\u4e4b\u95f4\u8fdb\u884c\u5207\u6362");
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
    ProcedureModeChanger.executeProcedure($_dependencies);
    return ar;
    }

}
