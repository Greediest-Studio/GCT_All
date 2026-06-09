package com.gmm.gctall.world.structure;

import com.gmm.gctall.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class PortalTemplateHelper {
  private PortalTemplateHelper() {}

  public static boolean placeFacingPortal(World world, Entity entity, BlockPos clickedPos, String eastWestTemplate,
      String northSouthTemplate) {
    if (world.isRemote) {
      return true;
    }

    EnumFacing facing = entity.getHorizontalFacing();
    ResourceLocation templateId;
    BlockPos origin;
    switch (facing) {
      case EAST:
        templateId = template(eastWestTemplate);
        origin = clickedPos.add(0, 1, -1);
        break;
      case WEST:
        templateId = template(eastWestTemplate);
        origin = clickedPos.add(0, 1, -2);
        break;
      case NORTH:
        templateId = template(northSouthTemplate);
        origin = clickedPos.add(-1, 1, 0);
        break;
      case SOUTH:
        templateId = template(northSouthTemplate);
        origin = clickedPos.add(-2, 1, 0);
        break;
      default:
        return false;
    }

    return StructureGenerationHelper.placeTemplate(world, templateId, origin, Rotation.NONE, Mirror.NONE);
  }

  private static ResourceLocation template(String name) {
    return new ResourceLocation(Tags.MOD_ID, name);
  }
}
