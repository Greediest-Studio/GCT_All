
package com.gmm.gctall.item;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureCreepyWitherDollClick;
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

public class ItemCreepyWitherDoll extends Item {
    public static final Item block = new ItemCreepyWitherDoll();

    public ItemCreepyWitherDoll() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("creepy_wither_doll");
        this.setRegistryName("creepy_wither_doll");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u5176\u5b9e\u8fd8\u662f\u86ee\u53ef\u7231\u7684\u561b\u2026\u2026");
    list.add("\u5728\u672b\u5730\u539f\u70b9\u53f3\u952e\u4f20\u9001\u81f3\u865a\u7a7a\u4e4b\u5730");
    list.add("\u5728\u865a\u7a7a\u4e4b\u5730\u4efb\u610f\u5730\u70b9\u53f3\u952e\u4f20\u9001\u56de\u672b\u5730");
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
    ProcedureCreepyWitherDollClick.executeProcedure($_dependencies);
    return ar;
    }

}
