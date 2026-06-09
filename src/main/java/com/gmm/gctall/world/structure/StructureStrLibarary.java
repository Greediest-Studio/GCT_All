package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureStrLibarary extends TemplateStructureElement {
  public StructureStrLibarary(GctAllContent elements) {
    super(elements, 57, "library", WorldWarpedRuin.DIMID, 30000, false, true);
  }
}

