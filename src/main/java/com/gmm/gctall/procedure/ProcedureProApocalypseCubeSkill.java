package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionCurseOfTwilight;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public final class ProcedureProApocalypseCubeSkill {
  private ProcedureProApocalypseCubeSkill() {
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
      ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"你过于靠近天启立方，受到了天启诅咒……\"}] ");
      BlockPos center = new BlockPos(x, y, z);
      ProcedureEffectHelper.addEffectToPlayers(world, center, 32.0D, MobEffects.BLINDNESS, 100, 0, false, true);
      ProcedureEffectHelper.addEffectToPlayers(world, center, 32.0D, MobEffects.WITHER, 100, 2, false, true);
      ProcedureEffectHelper.addEffectToPlayers(world, center, 32.0D, MobEffects.SLOWNESS, 100, 4, false, true);
      ProcedureEffectHelper.addEffectToPlayers(world, center, 32.0D, PotionCurseOfTwilight.potion, 100, 0, false, true);
    }
    if (world.rand.nextDouble() < 0.005D && ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHealth() : -1.0F) <= 40.0F) {
      if (entity instanceof EntityPlayer && !entity.world.isRemote)
        ((EntityPlayer)entity).sendStatusMessage((ITextComponent)new TextComponentString("tellraw @a[r=8] [\"\",{\"text\":\"天启不死……\"}] "), false);
      if (entity instanceof EntityLivingBase)
        ((EntityLivingBase)entity).setHealth(1000.0F);
    }
  }
}

