package com.gmm.gctall.item;

import com.gmm.gctall.client.GctAllModels;
import com.gmm.gctall.item.ItemAbyssWand;
import com.gmm.gctall.item.ItemAncientMud;
import com.gmm.gctall.item.ItemAncientShoggothMud;
import com.gmm.gctall.item.ItemApocalypseRuin;
import com.gmm.gctall.item.ItemBligtzDust;
import com.gmm.gctall.item.ItemBligtzRod;
import com.gmm.gctall.item.ItemBnatuzDust;
import com.gmm.gctall.item.ItemBnatuzRod;
import com.gmm.gctall.item.ItemBninzDust;
import com.gmm.gctall.item.ItemBninzRod;
import com.gmm.gctall.item.ItemBthdzDust;
import com.gmm.gctall.item.ItemBthdzRod;
import com.gmm.gctall.item.ItemCommandDismantler;
import com.gmm.gctall.item.ItemEarthOrb;
import com.gmm.gctall.item.ItemElfPasses;
import com.gmm.gctall.item.ItemEssenceOfDarkerrealm;
import com.gmm.gctall.item.ItemEyeOfAbyss;
import com.gmm.gctall.item.ItemFruitOfMind;
import com.gmm.gctall.item.ItemFruitOfMindEnchanted;
import com.gmm.gctall.item.ItemFurtherSoul;
import com.gmm.gctall.item.ItemGaiaHeart;
import com.gmm.gctall.item.ItemGravityScrap;
import com.gmm.gctall.item.ItemKeyOfDark;
import com.gmm.gctall.item.ItemKeyOfWarped;
import com.gmm.gctall.item.ItemKeyOfWarpedActive;
import com.gmm.gctall.item.ItemMuddyFlesh;
import com.gmm.gctall.item.ItemRemnantCookie;
import com.gmm.gctall.item.ItemResonatedScrap;
import com.gmm.gctall.item.ItemSaniteSiphon;
import com.gmm.gctall.item.ItemSanityObserver;
import com.gmm.gctall.item.ItemSenterianWrench;
import com.gmm.gctall.item.ItemShadowNuclear;
import com.gmm.gctall.item.ItemShoggothClump;
import com.gmm.gctall.item.ItemShoggothSlimeball;
import com.gmm.gctall.item.ItemShoggothTancale;
import com.gmm.gctall.item.ItemShoggothTancaleSoup;
import com.gmm.gctall.item.ItemShoggothTooth;
import com.gmm.gctall.item.ItemSoulStealerScroll;
import com.gmm.gctall.item.ItemWarpedSoul;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllItems {
    private GctAllItems() {
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemAbyssWand.block,
                ItemEyeOfAbyss.block,
                ItemEssenceOfDarkerrealm.block,
                ItemWarpedSoul.block,
                ItemFurtherSoul.block,
                ItemSoulStealerScroll.block,
                ItemAncientMud.block,
                ItemAncientShoggothMud.block,
                ItemMuddyFlesh.block,
                ItemShoggothClump.block,
                ItemShoggothSlimeball.block,
                ItemShoggothTancale.block,
                ItemShoggothTancaleSoup.block,
                ItemShoggothTooth.block,
                ItemKeyOfDark.block,
                ItemKeyOfWarped.block,
                ItemKeyOfWarpedActive.block,

                ItemApocalypseRuin.block,
                ItemApocalypsiumScrap.block,
                ItemShadowNuclear.block,
                ItemGravityScrap.block,
                ItemResonatedScrap.block,
                ItemNaturallineScrap.block,

                ItemEarthIngot.block,
                ItemEarthOrb.block,
                ItemElfPasses.block,
                ItemGaiaHeart.block,
                ItemHolysteelIngot.block,

                ItemOrderCrystal.block,
                ItemOrderedCore.block,
                ItemCommandCore.block,
                ItemCommandDismantler.block,
                ItemDoorKeyEmpty.block,
                ItemDoorKeyOfOrderland.block,

                ItemSenterianKey.block,
                ItemSenterianWrench.block,

                ItemStormyFragmentTiny.block,
                ItemStormyFragmentSmall.block,
                ItemStormyFragmentLarge.block,
                ItemStormyShard.block,
                ItemStormyCore.block,
                ItemWithericCore.block,
                ItemFallenCore.block,
                ItemRelifedCore.block,
                ItemSnowingiumNugget.block,

                ItemBligtzDust.block,
                ItemBligtzRod.block,
                ItemBnatuzDust.block,
                ItemBnatuzRod.block,
                ItemBninzDust.block,
                ItemBninzRod.block,
                ItemBthdzDust.block,
                ItemBthdzRod.block,

                ItemFruitOfMind.block,
                ItemFruitOfMindEnchanted.block,
                ItemRemnantCookie.block,
                ItemSaniteSiphon.block,
                ItemSanityObserver.block,

                ItemBluePrintEmpty.block,
                ItemBluePrintForge.block,
                ItemCreepyWitherDoll.block,
                ItemCreepyWitherstormDoll.block,
                ItemFinalliumIngot.block,
                ItemGreedycraftModChanger.block,
                ItemHermaphroditicArtifact.block,
                ItemPhotovoltaicCellIX.block,
                ItemPhotovoltaicCellVII.block,
                ItemPhotovoltaicCellVIII.block,
                ItemPhotovoltaicCellX.block,
                ItemPhotovoltaicCellXI.block,
                ItemPhotovoltaicCellXII.block,
                ItemRainboquartz.block,
                ItemRNGRelinquisher.block,
                ItemShalloite.block
        );
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        GctAllModels.item(ItemAbyssWand.block, "abyss_wand");
        GctAllModels.item(ItemEyeOfAbyss.block, "eye_of_abyss");
        GctAllModels.item(ItemEssenceOfDarkerrealm.block, "essenceofdarkerrealm");
        GctAllModels.item(ItemWarpedSoul.block, "warped_soul");
        GctAllModels.item(ItemFurtherSoul.block, "further_soul");
        GctAllModels.item(ItemSoulStealerScroll.block, "soul_stealer_scroll");
        GctAllModels.item(ItemAncientMud.block, "ancientmud");
        GctAllModels.item(ItemAncientShoggothMud.block, "ancient_shoggoth_mud");
        GctAllModels.item(ItemMuddyFlesh.block, "muddy_flesh");
        GctAllModels.item(ItemShoggothClump.block, "shoggoth_clump");
        GctAllModels.item(ItemShoggothSlimeball.block, "shoggoth_slimeball");
        GctAllModels.item(ItemShoggothTancale.block, "shoggothtancale");
        GctAllModels.item(ItemShoggothTancaleSoup.block, "shoggoth_tancale_soup");
        GctAllModels.item(ItemShoggothTooth.block, "shoggothtooth");
        GctAllModels.item(ItemKeyOfDark.block, "keyofdark");
        GctAllModels.item(ItemKeyOfWarped.block, "key_of_warped");
        GctAllModels.item(ItemKeyOfWarpedActive.block, "key_of_warped_active");

        GctAllModels.item(ItemApocalypseRuin.block, "apocalypse_ruin");
        GctAllModels.item(ItemApocalypsiumScrap.block, "apocalypsium_scrap");
        GctAllModels.item(ItemShadowNuclear.block, "shadownuclear");
        GctAllModels.item(ItemGravityScrap.block, "gravity_scrap");
        GctAllModels.item(ItemResonatedScrap.block, "resonated_scrap");
        GctAllModels.item(ItemNaturallineScrap.block, "naturalline_scrap");

        GctAllModels.item(ItemEarthIngot.block, "earth_ingot");
        GctAllModels.item(ItemEarthOrb.block, "earth_orb");
        GctAllModels.item(ItemElfPasses.block, "elf_passes");
        GctAllModels.item(ItemGaiaHeart.block, "gaia_heart");
        GctAllModels.item(ItemHolysteelIngot.block, "holysteel_ingot");

        GctAllModels.item(ItemOrderCrystal.block, "order_crystal");
        GctAllModels.item(ItemOrderedCore.block, "ordered_core");
        GctAllModels.item(ItemCommandCore.block, "command_core");
        GctAllModels.item(ItemCommandDismantler.block, "command_dismantler");
        GctAllModels.item(ItemDoorKeyEmpty.block, "door_key_empty");
        GctAllModels.item(ItemDoorKeyOfOrderland.block, "door_key_of_orderland");

        GctAllModels.item(ItemSenterianKey.block, "senterian_key");
        GctAllModels.item(ItemSenterianWrench.block, "senterian_wrench");

        GctAllModels.item(ItemStormyFragmentTiny.block, "stormy_fragment_tiny");
        GctAllModels.item(ItemStormyFragmentSmall.block, "stormy_fragment_small");
        GctAllModels.item(ItemStormyFragmentLarge.block, "stormy_fragment_large");
        GctAllModels.item(ItemStormyShard.block, "stormy_shard");
        GctAllModels.item(ItemStormyCore.block, "stormy_core");
        GctAllModels.item(ItemWithericCore.block, "witheric_core");
        GctAllModels.item(ItemFallenCore.block, "fallen_core");
        GctAllModels.item(ItemRelifedCore.block, "relifed_core");
        GctAllModels.item(ItemSnowingiumNugget.block, "snowingium_nugget");

        GctAllModels.item(ItemBligtzDust.block, "bligtz_dust");
        GctAllModels.item(ItemBligtzRod.block, "bligtz_rod");
        GctAllModels.item(ItemBnatuzDust.block, "bnatuz_dust");
        GctAllModels.item(ItemBnatuzRod.block, "bnatuz_rod");
        GctAllModels.item(ItemBninzDust.block, "bninz_dust");
        GctAllModels.item(ItemBninzRod.block, "bninz_rod");
        GctAllModels.item(ItemBthdzDust.block, "bthdz_dust");
        GctAllModels.item(ItemBthdzRod.block, "bthdz_rod");

        GctAllModels.item(ItemFruitOfMind.block, "fruit_of_mind");
        GctAllModels.item(ItemFruitOfMindEnchanted.block, "fruit_of_mind_enchanted");
        GctAllModels.item(ItemRemnantCookie.block, "remnant_cookie");
        GctAllModels.item(ItemSaniteSiphon.block, "sanite_siphon");
        GctAllModels.item(ItemSanityObserver.block, "sanity_observer");

        GctAllModels.item(ItemBluePrintEmpty.block, "blue_print_empty");
        GctAllModels.item(ItemBluePrintForge.block, "blue_print_forge");
        GctAllModels.item(ItemCreepyWitherDoll.block, "creepy_wither_doll");
        GctAllModels.item(ItemCreepyWitherstormDoll.block, "creepy_witherstorm_doll");
        GctAllModels.item(ItemFinalliumIngot.block, "finallium_ingot");
        GctAllModels.item(ItemGreedycraftModChanger.block, "greedycraft_mod_changer");
        GctAllModels.item(ItemHermaphroditicArtifact.block, "hermaphroditic_artifact");
        GctAllModels.item(ItemPhotovoltaicCellIX.block, "photovoltaic_cell_ix");
        GctAllModels.item(ItemPhotovoltaicCellVII.block, "photovoltaic_cell_vii");
        GctAllModels.item(ItemPhotovoltaicCellVIII.block, "photovoltaic_cell_viii");
        GctAllModels.item(ItemPhotovoltaicCellX.block, "photovoltaic_cell_x");
        GctAllModels.item(ItemPhotovoltaicCellXI.block, "photovoltaic_cell_xi");
        GctAllModels.item(ItemPhotovoltaicCellXII.block, "photovoltaic_cell_xii");
        GctAllModels.item(ItemRainboquartz.block, "rainboquartz");
        GctAllModels.item(ItemRNGRelinquisher.block, "rng_relinquisher");
        GctAllModels.item(ItemShalloite.block, "shalloite");
    }
}
