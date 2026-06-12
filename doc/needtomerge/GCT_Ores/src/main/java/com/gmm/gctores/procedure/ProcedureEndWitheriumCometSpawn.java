
package com.gmm.gctores.procedure;

import java.util.Map;

import com.gmm.gctores.ElementsGctOresMod;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;

@ElementsGctOresMod.ModElement.Tag
public class ProcedureEndWitheriumCometSpawn extends ElementsGctOresMod.ModElement
{
    public ProcedureEndWitheriumCometSpawn(final ElementsGctOresMod instance) {
        super(instance, 391);
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
