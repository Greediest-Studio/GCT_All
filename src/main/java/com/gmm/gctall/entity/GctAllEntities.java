package com.gmm.gctall.entity;

import com.gmm.gctall.entity.EntityAncientShoggoth;
import com.gmm.gctall.entity.EntityApocalypseCube;
import com.gmm.gctall.entity.EntityApocalypseHolder;
import com.gmm.gctall.entity.EntityApocalypseKnight;
import com.gmm.gctall.entity.EntityBligtz;
import com.gmm.gctall.entity.EntityBloodyShoggoth;
import com.gmm.gctall.entity.EntityBlueFlameBeholder;
import com.gmm.gctall.entity.EntityBnatuz;
import com.gmm.gctall.entity.EntityBninz;
import com.gmm.gctall.entity.EntityBthdz;
import com.gmm.gctall.entity.EntityDarkerLesserShoggoth;
import com.gmm.gctall.entity.EntityElf;
import com.gmm.gctall.entity.EntityMixtureShoggoth;
import com.gmm.gctall.entity.EntityRemnantWandering;
import com.gmm.gctall.entity.EntityReversedElf;
import com.gmm.gctall.entity.EntityRottened;
import com.gmm.gctall.entity.EntityShadowBase;
import com.gmm.gctall.entity.EntityWeatherEyevil;
import com.gmm.gctall.entity.EntityWeatherWaterRod;
import com.gmm.gctall.entity.EntityZethur;
import com.gmm.gctall.entity.EntityZjarugoth;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllEntities {
    private GctAllEntities() {
    }

    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        EntityAncientShoggoth.registerEntities(event);
        EntityApocalypseCube.registerEntities(event);
        EntityApocalypseHolder.registerEntities(event);
        EntityApocalypseKnight.registerEntities(event);
        EntityBligtz.registerEntities(event);
        EntityBloodyShoggoth.registerEntities(event);
        EntityBlueFlameBeholder.registerEntities(event);
        EntityBnatuz.registerEntities(event);
        EntityBninz.registerEntities(event);
        EntityBthdz.registerEntities(event);
        EntityDarkerLesserShoggoth.registerEntities(event);
        EntityElf.registerEntities(event);
        EntityMixtureShoggoth.registerEntities(event);
        EntityRemnantWandering.registerEntities(event);
        EntityReversedElf.registerEntities(event);
        EntityRottened.registerEntities(event);
        EntityShadowBase.registerEntities(event);
        EntityWeatherEyevil.registerEntities(event);
        EntityWeatherWaterRod.registerEntities(event);
        EntityZethur.registerEntities(event);
        EntityZjarugoth.registerEntities(event);
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