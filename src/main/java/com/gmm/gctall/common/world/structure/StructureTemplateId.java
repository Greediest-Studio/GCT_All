package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.Tags;
import net.minecraft.util.ResourceLocation;

public final class StructureTemplateId {
    private final String name;
    private final ResourceLocation resourceLocation;

    public StructureTemplateId(String name) {
        this.name = name;
        this.resourceLocation = new ResourceLocation(Tags.MOD_ID, name);
    }

    public String getName() {
        return name;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }
}
