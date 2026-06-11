
package com.gmm.gctall.item;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureCreepyWitherstormDollClick;
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

public class ItemCreepyWitherstormDoll extends Item {
    public static final Item block = new ItemCreepyWitherstormDoll();

    public ItemCreepyWitherstormDoll() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("creepy_witherstorm_doll");
        this.setRegistryName("creepy_witherstorm_doll");
        this.setCreativeTab(TabCTabWitheric.tab);

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
