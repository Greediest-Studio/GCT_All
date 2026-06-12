package com.gmm.gctall.common.entity;

import com.gmm.gctall.common.entity.EntityAncientShoggoth;
import com.gmm.gctall.common.entity.EntityApocalypseCube;
import com.gmm.gctall.common.entity.EntityApocalypseHolder;
import com.gmm.gctall.common.entity.EntityApocalypseKnight;
import com.gmm.gctall.common.entity.EntityBligtz;
import com.gmm.gctall.common.entity.EntityBloodyShoggoth;
import com.gmm.gctall.common.entity.EntityBlueFlameBeholder;
import com.gmm.gctall.common.entity.EntityBnatuz;
import com.gmm.gctall.common.entity.EntityBninz;
import com.gmm.gctall.common.entity.EntityBthdz;
import com.gmm.gctall.common.entity.EntityDarkerLesserShoggoth;
import com.gmm.gctall.common.entity.EntityElf;
import com.gmm.gctall.common.entity.EntityMixtureShoggoth;
import com.gmm.gctall.common.entity.EntityRemnantWandering;
import com.gmm.gctall.common.entity.EntityReversedElf;
import com.gmm.gctall.common.entity.EntityRottened;
import com.gmm.gctall.common.entity.EntityShadowBase;
import com.gmm.gctall.common.entity.EntityWeatherEyevil;
import com.gmm.gctall.common.entity.EntityWeatherWaterRod;
import com.gmm.gctall.common.entity.EntityZethur;
import com.gmm.gctall.common.entity.EntityZjarugoth;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllEntities {
    private GctAllEntities() {
    }

    public static void init(FMLInitializationEvent event) {
        EntityBlueFlameBeholder.init(event);
        EntityDarkerLesserShoggoth.init(event);
        EntityReversedElf.init(event);
        EntityRottened.init(event);
        EntityShadowBase.init(event);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenderers(FMLPreInitializationEvent event) {
        EntityAncientShoggoth.registerRenderers(event);
        EntityApocalypseCube.registerRenderers(event);
        EntityApocalypseHolder.registerRenderers(event);
        EntityApocalypseKnight.registerRenderers(event);
        EntityBligtz.registerRenderers(event);
        EntityBloodyShoggoth.registerRenderers(event);
        EntityBlueFlameBeholder.registerRenderers(event);
        EntityBnatuz.registerRenderers(event);
        EntityBninz.registerRenderers(event);
        EntityBthdz.registerRenderers(event);
        EntityDarkerLesserShoggoth.registerRenderers(event);
        EntityElf.registerRenderers(event);
        EntityMixtureShoggoth.registerRenderers(event);
        EntityRemnantWandering.registerRenderers(event);
        EntityReversedElf.registerRenderers(event);
        EntityRottened.registerRenderers(event);
        EntityShadowBase.registerRenderers(event);
        EntityWeatherEyevil.registerRenderers(event);
        EntityWeatherWaterRod.registerRenderers(event);
        EntityZethur.registerRenderers(event);
        EntityZjarugoth.registerRenderers(event);
    }
}
