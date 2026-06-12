package com.gmm.gctall.common.events;

import com.gmm.gctall.misc.registry.GctAllItems;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public final class ElfTrade {
  private ElfTrade() {
  }

  public static void run(Entity entity, World world, int x, int y, int z) {
    if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
      .getItem() == (new ItemStack(GctAllItems.ELF_PASSES, 1)).getItem()) {
      if (entity instanceof EntityPlayer)
        ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(GctAllItems.ELF_PASSES, 1)).getItem(), -1, 1, null);
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"<\u7CBE\u7075>\u8FD9\u4E1C\u897F\u771F\u4E0D\u9519\uFF01\"}] ");
      if (entity instanceof EntityPlayer) {
        ItemStack _setstack = new ItemStack(GctAllItems.NATURALLINE_SCRAP, 1);
        _setstack.setCount(1);
        ItemHandlerHelper.giveItemToPlayer((EntityPlayer)entity, _setstack);
      }
    } else {
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"<\u7CBE\u7075>\u4F60\u4F3C\u4E4E\u4E0D\u80FD\u4E0D\u52B3\u800C\u83B7\u5462\u3002\"}] ");
    }
  }
}


