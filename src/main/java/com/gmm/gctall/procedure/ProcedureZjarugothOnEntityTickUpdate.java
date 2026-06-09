package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommands;
import com.gmm.gctall.block.BlockBlueFire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tag
public class ProcedureZjarugothOnEntityTickUpdate extends GctAllElement {
  public ProcedureZjarugothOnEntityTickUpdate(GctAllContent instance) {
    super(instance, 78);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ZjarugothOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ZjarugothOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ZjarugothOnEntityTickUpdate!");
      return;
    } 
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ZjarugothOnEntityTickUpdate!");
      return;
    } 
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if (!world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "effect @e[type=gct_all:zjarugoth,r=10] clear"); 
    if (Math.random() < 0.005D && 
      !world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>\u54C8\uFF0C\u4F60\u4F3C\u4E4E\u8BA4\u4E3A\u6211\u6BD4\u624E\u54C8\u5C14\u90A3\u5BB6\u4F19\u5F31\uFF1F\"}]"); 
    if (Math.random() < 0.008D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Ymg' uaaah ya lloigazath!\"}]"); 
      if (Math.random() < 0.25D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x + 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D), 
              (int)(z + 6.0D + Math.random() * 10.0D), 4.0F, true); 
      } else if (Math.random() < 0.33D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x - 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D), 
              (int)(z + 6.0D + Math.random() * 10.0D), 4.0F, true); 
      } else if (Math.random() < 0.5D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x - 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D), 
              (int)(z - 6.0D + Math.random() * 10.0D), 4.0F, true); 
      } else if (!world.isRemote) {
        world.createExplosion(null, (int)(x + 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D), 
            (int)(z - 6.0D + Math.random() * 10.0D), 4.0F, true);
      } 
    } 
    if (Math.random() < 0.008D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Ymg' uaaah ya lloigazath!\"}]"); 
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "effect @a[r=64] gct_all:zjarugoth_damage 1 0 false"); 
      world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
          .getObject(new ResourceLocation("gct_all:zjarugoth_roar")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
    } 
    if (Math.random() < 0.002D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Fm'latghor, fm'latgh!\"}]"); 
      world.setBlockState(new BlockPos(x + 3, y + 6, z + 0), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 3, y + 6, z + 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 3, y + 6, z - 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z + 0), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z + 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z - 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 0, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 1, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 1, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 0, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 1, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 1, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 2, y + 6, z + 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 2, y + 6, z + 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 2, y + 6, z - 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 2, y + 6, z - 2), BlockBlueFire.block.getDefaultState(), 3);
    } 
  }
}

