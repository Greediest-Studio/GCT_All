
package com.gmm.gctall.procedure;

import java.util.Map;


public final class ProcedureEndWitheriumCometSpawn
{
    private ProcedureEndWitheriumCometSpawn() {
    }
    
    public static Object executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure EndWitheriumCometSpawn!");
            return null;
        }
        final int y = (int) dependencies.get("y");
        if (y > 70) {
            return true;
        }
        return false;
    }
}


