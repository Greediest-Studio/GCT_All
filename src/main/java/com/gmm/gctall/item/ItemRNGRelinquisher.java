
package com.gmm.gctall.item;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureRNGRelinquisherClick;
import java.util.HashMap;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRNGRelinquisher extends Item {
    public static final Item block = new ItemRNGRelinquisher();

    public ItemRNGRelinquisher() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("rng_relinquisher");
        this.setRegistryName("rng_relinquisher");
        this.setCreativeTab(TabCTabWitheric.tab);

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
