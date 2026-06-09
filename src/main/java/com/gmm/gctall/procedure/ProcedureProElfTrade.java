package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemElfPasses;
import com.gmm.gctall.item.ItemNaturallineScrap;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

@Tag
public class ProcedureProElfTrade extends GctAllElement {
  public ProcedureProElfTrade(GctAllContent instance) {
    super(instance, 298);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProElfTrade", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
      .getItem() == (new ItemStack(ItemElfPasses.block, 1)).getItem()) {
      if (entity instanceof EntityPlayer)
        ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(ItemElfPasses.block, 1)).getItem(), -1, 1, null); 
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"<\u7CBE\u7075>\u8FD9\u4E1C\u897F\u771F\u4E0D\u9519\uFF01\"}] "); 
      if (entity instanceof EntityPlayer) {
        ItemStack _setstack = new ItemStack(ItemNaturallineScrap.block, 1);
        _setstack.setCount(1);
        ItemHandlerHelper.giveItemToPlayer((EntityPlayer)entity, _setstack);
      } 
    } else {
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"<\u7CBE\u7075>\u4F60\u4F3C\u4E4E\u4E0D\u80FD\u4E0D\u52B3\u800C\u83B7\u5462\u3002\"}] ");
    } 
  }
}

