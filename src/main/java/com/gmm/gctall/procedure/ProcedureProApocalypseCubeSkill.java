package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

@Tag
public class ProcedureProApocalypseCubeSkill extends GctAllElement {
  public ProcedureProApocalypseCubeSkill(GctAllContent instance) {
    super(instance, 101);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseCubeSkill", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.rand.nextDouble() < 0.001D) {
      ServerCommandHelper.run(world, new BlockPos(x + 6, y, z), "summon twilightforest:adherent ~ ~1 ~");
      ServerCommandHelper.run(world, new BlockPos(x - 6, y, z), "summon twilightforest:adherent ~ ~1 ~");
    } 
    if (world.rand.nextDouble() < 0.001D) {
      ServerCommandHelper.run(world, new BlockPos(x, y, z + 6), "summon twilightforest:adherent ~ ~1 ~");
      ServerCommandHelper.run(world, new BlockPos(x, y, z - 6), "summon twilightforest:adherent ~ ~1 ~");
    } 
    if (world.rand.nextDouble() < 0.005D) {
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"\u4F60\u8FC7\u4E8E\u9760\u8FD1\u5929\u542F\u7ACB\u65B9\uFF0C\u53D7\u5230\u4E86\u5929\u542F\u8BC5\u5492\u2026\u2026\"}] ");
      ServerCommandHelper.run(world, x, y, z, "effect @a[r=32] minecraft:blindness 5 0");
      ServerCommandHelper.run(world, x, y, z, "effect @a[r=32] minecraft:wither 5 2");
      ServerCommandHelper.run(world, x, y, z, "effect @a[r=32] minecraft:slowness 5 4");
      ServerCommandHelper.run(world, x, y, z, "effect @a[r=32] gct_all:curse_of_twilight 5 0");
    } 
    if (world.rand.nextDouble() < 0.005D && ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHealth() : -1.0F) <= 40.0F) {
      if (entity instanceof EntityPlayer && !entity.world.isRemote)
        ((EntityPlayer)entity).sendStatusMessage((ITextComponent)new TextComponentString("tellraw @a[r=8] [\"\",{\"text\":\"\u5929\u542F\u4E0D\u6B7B\u2026\u2026\"}] "), false); 
      if (entity instanceof EntityLivingBase)
        ((EntityLivingBase)entity).setHealth(1000.0F); 
    } 
  }
}

