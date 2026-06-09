package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureStrTower2 extends TemplateStructureElement {
  public StructureStrTower2(GctAllContent elements) {
    super(elements, 60, "tower_2", WorldWarpedRuin.DIMID, 5000, false, true);
  }
}

