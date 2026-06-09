package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureStrStorage extends TemplateStructureElement {
  public StructureStrStorage(GctAllContent elements) {
    super(elements, 58, "storage", WorldWarpedRuin.DIMID, 30000, false, true);
  }
}

