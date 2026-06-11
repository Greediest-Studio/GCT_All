
package com.gmm.gctall.procedure;

import java.util.Map;
public final class ProcedureOrderlandStructureSpawn
{
    private ProcedureOrderlandStructureSpawn() {
    }
    
    public static Object executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure OrderlandStructureSpawn!");
            return null;
        }
        final int y = (int)dependencies.get("y");
        if (y > 31 && y < 120) {
            return true;
        }
        return false;
    }
}


