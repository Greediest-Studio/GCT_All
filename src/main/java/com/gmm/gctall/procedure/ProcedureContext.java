package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureContext {
  private ProcedureContext() {}

  public static boolean require(Map<String, Object> dependencies, String procedureName, String... keys) {
    for (String key : keys) {
      if (dependencies.get(key) == null) {
        System.err.println("Failed to load dependency " + key + " for procedure " + procedureName + "!");
        return false;
      }
    }
    return true;
  }

  public static Entity entity(Map<String, Object> dependencies) {
    return dependency(dependencies, "entity", Entity.class);
  }

  public static World world(Map<String, Object> dependencies) {
    return dependency(dependencies, "world", World.class);
  }

  public static ItemStack itemStack(Map<String, Object> dependencies, String key) {
    return dependency(dependencies, key, ItemStack.class);
  }

  public static int x(Map<String, Object> dependencies) {
    return intValue(dependencies, "x");
  }

  public static int y(Map<String, Object> dependencies) {
    return intValue(dependencies, "y");
  }

  public static int z(Map<String, Object> dependencies) {
    return intValue(dependencies, "z");
  }

  public static BlockPos blockPos(Map<String, Object> dependencies) {
    return new BlockPos(x(dependencies), y(dependencies), z(dependencies));
  }

  public static int intValue(Map<String, Object> dependencies, String key) {
    return ((Number)dependencies.get(key)).intValue();
  }

  public static <T> T dependency(Map<String, Object> dependencies, String key, Class<T> type) {
    return type.cast(dependencies.get(key));
  }
}
