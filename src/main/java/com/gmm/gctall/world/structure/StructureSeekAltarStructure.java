package com.gmm.gctall.world.structure;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldWarpedRuin;

@Tag
public class StructureSeekAltarStructure extends TemplateStructureElement {
  public StructureSeekAltarStructure(GctAllContent elements) {
    super(elements, 74, "seek_altar", WorldWarpedRuin.DIMID, 3000, false, true);
  }
}

