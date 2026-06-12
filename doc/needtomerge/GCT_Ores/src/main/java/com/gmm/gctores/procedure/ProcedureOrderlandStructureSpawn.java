
package com.gmm.gctores.procedure;

import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureOrderlandStructureSpawn extends ElementsGctOresMod.ModElement
{
    public ProcedureOrderlandStructureSpawn(final ElementsGctOresMod instance) {
        super(instance, 427);
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
