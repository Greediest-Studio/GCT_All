
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.common.items.ItemCreepyWitherstormDoll;
import net.minecraft.entity.player.EntityPlayer;
import com.gmm.gctall.common.world.dimension.WorldTheVoid;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class CreepyWitherstormDollClick
{
    private CreepyWitherstormDollClick() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        if (entity.dimension == WorldTheVoid.DIMID) {
            ServerCommandHelper.run(world, x, y, z, "say \u5c0f\u5fc3\uff0c\u5b83\u6765\u4e86\uff01");
            ServerCommandHelper.run(world, x, y + 5, z, "summon ageofminecraft:witherbosscommandblockhelpful");
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).inventory.clearMatchingItems(new ItemStack(ItemCreepyWitherstormDoll.block, 1).getItem(), -1, 1, (NBTTagCompound)null);
            }
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u6050\u6016\u7684\u98ce\u66b4\u51cb\u7075\u73a9\u5076\uff1a \u6211\u8c8c\u4f3c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u7ef4\u5ea6\u65bd\u5c55\u80fd\u529b\u2026\u2026\"}] ");
        }
    }
}


