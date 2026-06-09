package com.gmm.gctall.registry;

import com.gmm.gctall.Tags;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public final class GctAllOreDictionary {
    private static final List<Entry> ENTRIES = Arrays.asList(
            entry("oreChromium", "nether_chromium_ore"),
            entry("oreChromium", "end_chromium_ore"),
            entry("oreChrome", "nether_chromium_ore"),
            entry("oreChrome", "end_chromium_ore"),
            entry("oreManganese", "end_manganese_ore"),
            entry("oreManganese", "nether_manganese_ore"),
            entry("oreSanite", "sanite_ore"),
            entry("oreEthaxium", "ethauxium_ore"),
            entry("oreDreadium", "dreadium_ore"),
            entry("blockPe", "solid_pot_energy"),
            entry("oreAzathothium", "azathothium_ore"),
            entry("oreNyarlathotepium", "nyarlathotepium_ore"),
            entry("oreYogsothothium", "yogsothothium_ore"),
            entry("oreShubniggurathium", "shubniggurathium_ore"),
            entry("oreAzathothiumComplex", "azathothium_ore_complex"),
            entry("oreNyarlathotepiumComplex", "nyralathotepium_ore_complex"),
            entry("oreYogsothothiumComplex", "yogsothothium_ore_complex"),
            entry("oreShubniggurathiumComplex", "shubniggurathium_ore_complex"),
            entry("oreAbyssComplex", "azathothium_ore_complex"),
            entry("oreAbyssComplex", "nyralathotepium_ore_complex"),
            entry("oreAbyssComplex", "yogsothothium_ore_complex"),
            entry("oreAbyssComplex", "shubniggurathium_ore_complex"),
            entry("stoneAbyssExtended", "densedarkstone"),
            entry("stoneAbyssExtended", "warprack"),
            entry("slimeball", "shoggoth_slimeball"),
            entry("blockApocalypsium", "apocalypsium_block"),
            entry("blockAzathothium", "azathothium_block"),
            entry("blockAzathoth", "azathothium_block"),
            entry("blockCthulhurite", "cthulhurite_block"),
            entry("blockMana", "mana_block"),
            entry("blockNyarlathotepium", "nyarlathotepium_block"),
            entry("blockNyarlathotep", "nyarlathotepium_block"),
            entry("blockSanite", "sanite_block"),
            entry("blockShubniggurathium", "shubniggurathium_block"),
            entry("blockShubniggurath", "shubniggurathium_block"),
            entry("blockYogsothothium", "yogsothothium_block"),
            entry("blockYogsothoth", "yogsothothium_block"),
            entry("cobblestoneAlf", "alf_cobble_stone"),
            entry("cobblestoneMana", "mana_cobble_stone"),
            entry("dirtAlf", "alf_dirt"),
            entry("dirtBesidevoid", "bloodydirt"),
            entry("dirtBesidevoid", "corruptdirt"),
            entry("dirtMana", "mana_dirt"),
            entry("dustApocalypsium", "apocalypsium_dust"),
            entry("dustBligtz", "bligtz_dust"),
            entry("dustBnatuz", "bnatuz_dust"),
            entry("dustBninz", "bninz_dust"),
            entry("dustBthdz", "bthdz_dust"),
            entry("dustLumixeium", "lumixeium_dust"),
            entry("dustNaturaeum", "naturaeum_dust"),
            entry("dustNoxexeum", "noxexeum_dust"),
            entry("dustTonitruium", "tonitruium_dust"),
            entry("fenceWood", "evileye_fence"),
            entry("gearApocalypsium", "apocalypsium_gear"),
            entry("gemGravityDebris", "gravity_scrap"),
            entry("gemResonantDebris", "resonated_scrap"),
            entry("grassAlf", "alf_grass"),
            entry("grassBesidevoid", "bloodygrass"),
            entry("grassBesidevoid", "corruptgrass"),
            entry("grassMana", "mana_grass"),
            entry("ingotApocalypsium", "apocalypsium_ingot"),
            entry("ingotAzathothium", "azathothium_ingot"),
            entry("ingotAzathoth", "azathothium_ingot"),
            entry("ingotBotanical", "botanical_ingot"),
            entry("ingotBotanicalAwakened", "botanical_ingot_awakened"),
            entry("ingotCthulhurite", "cthulhurite_ingot"),
            entry("ingotEarth", "earth_ingot"),
            entry("ingotElementine", "elementine_ingot"),
            entry("ingotGreed", "greed_ingot"),
            entry("ingotHolysteel", "holysteel_ingot"),
            entry("ingotNyarlathotepium", "nyarlathotepium_ingot"),
            entry("ingotNyarlathotep", "nyarlathotepium_ingot"),
            entry("ingotSanite", "sanite_ingot"),
            entry("ingotShubniggurathium", "shubniggurathium_ingot"),
            entry("ingotShubniggurath", "shubniggurathium_ingot"),
            entry("ingotWavite", "wavite_ingot"),
            entry("ingotYogsothothium", "yogsothothium_ingot"),
            entry("ingotYogsothoth", "yogsothothium_ingot"),
            entry("logWoodDream", "dreamwood_log"),
            entry("logWoodDream", "reversed_dreamwood_log"),
            entry("logWood", "evileye_log"),
            entry("logWoodLiving", "livingwood_log"),
            entry("logWoodMana", "mana_log"),
            entry("nuggetApocalypsium", "apocalypsium_nugget"),
            entry("oreElementium", "elementium_ore"),
            entry("oreGravityDebris", "gravity_debris"),
            entry("oreOrichalcos", "orichalcos_ore"),
            entry("oreResonantDebris", "resonate_debris"),
            entry("oreTerrasteel", "terrasteel_ore"),
            entry("plankWood", "evileye_plank"),
            entry("plankWoodMana", "mana_plank"),
            entry("plateApocalypsium", "apocalypsium_plate"),
            entry("rodBligtz", "bligtz_rod"),
            entry("rodBnatuz", "bnatuz_rod"),
            entry("rodBninz", "bninz_rod"),
            entry("rodBthdz", "bthdz_rod"),
            entry("sandAlf", "alf_sand"),
            entry("scrapApocalypsium", "apocalypsium_scrap"),
            entry("slabWood", "evileye_slab"),
            entry("soulBotanical", "botanical_soul"),
            entry("stairWood", "evileye_stair"),
            entry("stoneAlf", "alf_stone"),
            entry("stoneBesidevoid", "corruptrock"),
            entry("stoneBesidevoid", "bloodyrock"),
            entry("stoneHeavite", "heavite"),
            entry("stoneMana", "mana_stone"),
            entry("treeLeaves", "evileye_leaves"),
            entry("treeLeavesDream", "dreamwood_leaves"),
            entry("treeLeavesDream", "reversed_dreamwood_leaves"),
            entry("treeLeavesLiving", "livingwood_leaves"),
            entry("treeLeavesMana", "mana_leaves")
    );

    private GctAllOreDictionary() {
    }

    public static void register() {
        for (Entry entry : ENTRIES) {
            ItemStack stack = stack(entry.itemName);
            if (!stack.isEmpty()) {
                OreDictionary.registerOre(entry.oreName, stack);
            }
        }
    }

    private static ItemStack stack(String itemName) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Tags.MOD_ID, itemName));
        return item == null ? ItemStack.EMPTY : new ItemStack(item, 1);
    }

    private static Entry entry(String oreName, String itemName) {
        return new Entry(oreName, itemName);
    }

    private static final class Entry {
        private final String oreName;
        private final String itemName;

        private Entry(String oreName, String itemName) {
            this.oreName = oreName;
            this.itemName = itemName;
        }
    }
}
