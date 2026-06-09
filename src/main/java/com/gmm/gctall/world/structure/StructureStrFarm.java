package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureStrFarm extends TemplateStructureElement {
  public StructureStrFarm(GctAllContent elements) {
    super(elements, 54, "farm", WorldWarpedRuin.DIMID, 30000, false, true);
  }
}

