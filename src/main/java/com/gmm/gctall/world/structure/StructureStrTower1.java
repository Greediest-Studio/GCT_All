package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureStrTower1 extends TemplateStructureElement {
  public StructureStrTower1(GctAllContent elements) {
    super(elements, 59, "tower_1", WorldWarpedRuin.DIMID, 5000, false, true);
  }
}

