package com.gmm.gctall.registry;

import com.gmm.gctall.Tags;
import com.gmm.gctall.data.GctAllVariables;
import com.gmm.gctall.network.GctAllNetwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAllContent implements IFuelHandler, IWorldGenerator {
    public static final GctAllContent INSTANCE = new GctAllContent();

    public final List<GctAllElement> elements = new ArrayList<>();
    public final List<Supplier<Block>> blocks = new ArrayList<>();
    public final List<Supplier<Item>> items = new ArrayList<>();
    public final List<Supplier<Biome>> biomes = new ArrayList<>();
    public final List<Supplier<EntityEntry>> entities = new ArrayList<>();
    public final List<Supplier<Potion>> potions = new ArrayList<>();
    public final List<Supplier<PotionType>> potionTypes = new ArrayList<>();
    public final List<ItemModel> itemModels = new ArrayList<>();
    public final Map<ResourceLocation, SoundEvent> sounds = new HashMap<>();

    private GctAllContent() {
        registerElements();
        elements.sort(null);
        elements.forEach(GctAllElement::initElements);
        registerSounds();
    }

    private void registerElements() {
        register(com.gmm.gctall.block.BlockDenseDarkstone::new);
        register(com.gmm.gctall.world.biome.BiomeDarkerRealm::new);
        register(com.gmm.gctall.world.dimension.WorldDIMDarkerRealm::new);
        register(com.gmm.gctall.block.BlockSaniteOre::new);
        register(com.gmm.gctall.entity.EntityDarkerLesserShoggoth::new);
        register(com.gmm.gctall.procedure.ProcedureDarkerLesserShoggothPlayerCollidesWithThisEntity::new);
        register(com.gmm.gctall.entity.EntityAncientShoggoth::new);
        register(com.gmm.gctall.potion.PotionAbyssPlague::new);
        register(com.gmm.gctall.procedure.ProcedureAbyssPlagueOnPotionActiveTick::new);
        register(com.gmm.gctall.procedure.ProcedureAbyssPlagueOnEntityTickUpdate::new);
        register(com.gmm.gctall.procedure.ProcedureAbyssPlaguePlayerCollidesWithThisEntity::new);
        register(com.gmm.gctall.block.BlockEthauxiumOre::new);
        register(com.gmm.gctall.block.BlockDreadiumOre::new);
        register(com.gmm.gctall.item.ItemEssenceOfDarkrealm::new);
        register(com.gmm.gctall.item.ItemEssenceOfDarkerrealm::new);
        register(com.gmm.gctall.item.ItemKeyOfDark::new);
        register(com.gmm.gctall.item.ItemAncientMud::new);
        register(com.gmm.gctall.item.ItemShoggothTancale::new);
        register(com.gmm.gctall.item.ItemShoggothTooth::new);
        register(com.gmm.gctall.item.ItemShadowNuclear::new);
        register(com.gmm.gctall.procedure.ProcedureAncientShoggothEntityDies::new);
        register(com.gmm.gctall.procedure.ProcedureDarkerLesserShoggothEntityDies::new);
        register(com.gmm.gctall.entity.EntityShadowBase::new);
        register(com.gmm.gctall.procedure.ProcedureShadowBaseEntityIsHurt::new);
        register(com.gmm.gctall.block.BlockSanityAltar::new);
        register(com.gmm.gctall.gui.GuiGUISanityAltar::new);
        register(com.gmm.gctall.procedure.ProcedureSanityAltarNeighbourBlockChanges::new);
        register(com.gmm.gctall.procedure.ProcedureShadowBaseOnEntityTickUpdate::new);
        register(com.gmm.gctall.procedure.ProcedureKeyOfDarkRightClickedOnBlock::new);
        register(com.gmm.gctall.item.ItemKeyOfWarped::new);
        register(com.gmm.gctall.item.ItemKeyOfWarpedActive::new);
        register(com.gmm.gctall.item.ItemEssenceOfWarpedRuin::new);
        register(com.gmm.gctall.block.BlockWarprack::new);
        register(com.gmm.gctall.block.BlockAzathothiumOreComplex::new);
        register(com.gmm.gctall.procedure.ProcedureAzathothiumOreComplexBlockDestroyedByPlayer::new);
        register(com.gmm.gctall.world.biome.BiomeWarped::new);
        register(com.gmm.gctall.block.BlockAbyssLiquid::new);
        register(com.gmm.gctall.procedure.ProcedureAbyssLiquidMobplayerCollidesBlock::new);
        register(com.gmm.gctall.world.dimension.WorldWarpedRuin::new);
        register(com.gmm.gctall.block.BlockNyralathotepiumOreComplex::new);
        register(com.gmm.gctall.procedure.ProcedureNyralathotepiumOreComplexBlockDestroyedByPlayer::new);
        register(com.gmm.gctall.potion.PotionStop::new);
        register(com.gmm.gctall.procedure.ProcedureStopOnPotionActiveTick::new);
        register(com.gmm.gctall.block.BlockYogsothothiumOreComplex::new);
        register(com.gmm.gctall.procedure.ProcedureYogsothothiumOreComplexBlockDestroyedByPlayer::new);
        register(com.gmm.gctall.block.BlockShubniggurathiumOreComplex::new);
        register(com.gmm.gctall.procedure.ProcedureShubniggurathiumOreComplexBlockDestroyedByPlayer::new);
        register(com.gmm.gctall.procedure.ProcedureKeyOfWarpedRightClickedOnBlock::new);
        register(com.gmm.gctall.entity.EntityRemnantWandering::new);
        register(com.gmm.gctall.block.BlockSeekBrick::new);
        register(com.gmm.gctall.block.BlockSeekAltar::new);
        register(com.gmm.gctall.block.BlockSeekFinder::new);
        register(com.gmm.gctall.block.BlockAzathothiumOre::new);
        register(com.gmm.gctall.block.BlockNyarlathotepiumOre::new);
        register(com.gmm.gctall.block.BlockYogsothothiumOre::new);
        register(com.gmm.gctall.block.BlockShubniggurathiumOre::new);
        register(com.gmm.gctall.item.ItemWarpedSoul::new);
        register(com.gmm.gctall.item.ItemSoulStealerScroll::new);
        register(com.gmm.gctall.procedure.ProcedureSeekAltarUpdateTick::new);
        register(com.gmm.gctall.block.BlockSolidPotEnergy::new);
        register(com.gmm.gctall.procedure.ProcedureSeekAltarOnBlockRightClicked::new);
        register(com.gmm.gctall.entity.EntityBlueFlameBeholder::new);
        register(com.gmm.gctall.entity.EntityZjarugoth::new);
        register(com.gmm.gctall.item.ItemFurtherSoul::new);
        register(com.gmm.gctall.block.BlockBlueFire::new);
        register(com.gmm.gctall.procedure.ProcedureBlueFireEntityCollidesInTheBlock::new);
        register(com.gmm.gctall.procedure.ProcedureBluefireOnPotionActiveTick::new);
        register(com.gmm.gctall.potion.PotionZjarugothDamage::new);
        register(com.gmm.gctall.procedure.ProcedureZjarugothDamagePotionStartedapplied::new);
        register(com.gmm.gctall.procedure.ProcedureZjarugothOnEntityTickUpdate::new);
        register(com.gmm.gctall.procedure.ProcedureZjarugothEntityIsHurt::new);
        register(com.gmm.gctall.procedure.ProcedureZjarugothEntityDies::new);
        register(com.gmm.gctall.block.BlockWarprackStair::new);
        register(com.gmm.gctall.block.BlockWarprackSlab::new);
        register(com.gmm.gctall.block.BlockWarprackWall::new);
        register(com.gmm.gctall.gui.overlay.OverlaySanityRender::new);
        register(com.gmm.gctall.item.ItemSanityObserver::new);
        register(com.gmm.gctall.procedure.ProcedureSanityRenderDisplayOverlayIngame::new);
        register(com.gmm.gctall.item.ItemSaniteSiphon::new);
        register(com.gmm.gctall.item.ItemShoggothSlimeball::new);
        register(com.gmm.gctall.entity.EntityMixtureShoggoth::new);
        register(com.gmm.gctall.item.ItemEyeOfAbyss::new);
        register(com.gmm.gctall.item.ItemShoggothComplexCrystal::new);
        register(com.gmm.gctall.item.ItemFruitOfMind::new);
        register(com.gmm.gctall.item.ItemShoggothTancaleSoup::new);
        register(com.gmm.gctall.item.ItemRemnantCookie::new);
        register(com.gmm.gctall.item.ItemFruitOfMindEnchanted::new);
        register(com.gmm.gctall.item.ItemAbyssWand::new);
        register(com.gmm.gctall.item.ItemShoggothClump::new);
        register(com.gmm.gctall.item.ItemMuddyFlesh::new);
        register(com.gmm.gctall.item.ItemShoggySlime::new);
        register(com.gmm.gctall.item.ItemShoggySlimePurified::new);
        register(com.gmm.gctall.entity.EntityBloodyShoggoth::new);
        register(com.gmm.gctall.item.ItemAncientShoggothMud::new);
        register(com.gmm.gctall.entity.EntityApocalypseCube::new);
        register(com.gmm.gctall.entity.EntityBligtz::new);
        register(com.gmm.gctall.entity.EntityBninz::new);
        register(com.gmm.gctall.entity.EntityBthdz::new);
        register(com.gmm.gctall.entity.EntityBnatuz::new);
        register(com.gmm.gctall.entity.EntityApocalypseKnight::new);
        register(com.gmm.gctall.entity.EntityRottened::new);
        register(com.gmm.gctall.item.ItemBligtzRod::new);
        register(com.gmm.gctall.item.ItemBninzRod::new);
        register(com.gmm.gctall.item.ItemBthdzRod::new);
        register(com.gmm.gctall.item.ItemBnatuzRod::new);
        register(com.gmm.gctall.item.ItemBligtzDust::new);
        register(com.gmm.gctall.item.ItemBninzDust::new);
        register(com.gmm.gctall.item.ItemBthdzDust::new);
        register(com.gmm.gctall.item.ItemBnatuzDust::new);
        register(com.gmm.gctall.item.ItemLumixeiumDust::new);
        register(com.gmm.gctall.item.ItemNoxexeumDust::new);
        register(com.gmm.gctall.item.ItemTonitruiumDust::new);
        register(com.gmm.gctall.item.ItemNaturaeumDust::new);
        register(com.gmm.gctall.item.ItemApocalypseRuin::new);
        register(com.gmm.gctall.block.BlockApocalypseBarrier::new);
        register(com.gmm.gctall.block.BlockApocalypseAltar::new);
        register(com.gmm.gctall.block.BlockApocalypseBomb::new);
        register(com.gmm.gctall.block.BlockApocalypsiumBlock::new);
        register(com.gmm.gctall.block.BlockSaniteBlock::new);
        register(com.gmm.gctall.block.BlockAzathothiumBlock::new);
        register(com.gmm.gctall.block.BlockNyarlathotepiumBlock::new);
        register(com.gmm.gctall.block.BlockYogsothothiumBlock::new);
        register(com.gmm.gctall.block.BlockShubniggurathiumBlock::new);
        register(com.gmm.gctall.block.BlockCthulhuriteBlock::new);
        register(com.gmm.gctall.item.ItemApocalypsiumIngot::new);
        register(com.gmm.gctall.item.ItemSaniteIngot::new);
        register(com.gmm.gctall.item.ItemAzathothiumIngot::new);
        register(com.gmm.gctall.item.ItemNyarlathotepiumIngot::new);
        register(com.gmm.gctall.item.ItemYogsothothiumIngot::new);
        register(com.gmm.gctall.item.ItemShubniggurathiumIngot::new);
        register(com.gmm.gctall.item.ItemCthulhuriteIngot::new);
        register(com.gmm.gctall.item.ItemApocalypsiumNugget::new);
        register(com.gmm.gctall.item.ItemApocalypsiumScrap::new);
        register(com.gmm.gctall.item.ItemApocalypsiumDust::new);
        register(com.gmm.gctall.item.ItemApocalypsiumGear::new);
        register(com.gmm.gctall.item.ItemApocalypsiumPlate::new);
        register(com.gmm.gctall.block.BlockManaStone::new);
        register(com.gmm.gctall.block.BlockManaCobbleStone::new);
        register(com.gmm.gctall.block.BlockManaDirt::new);
        register(com.gmm.gctall.block.BlockManaGrass::new);
        register(com.gmm.gctall.block.BlockCorruptrock::new);
        register(com.gmm.gctall.block.BlockCorruptgrass::new);
        register(com.gmm.gctall.block.BlockCorruptdirt::new);
        register(com.gmm.gctall.block.BlockBloodyrock::new);
        register(com.gmm.gctall.block.BlockBloodygrass::new);
        register(com.gmm.gctall.block.BlockBloodydirt::new);
        register(com.gmm.gctall.block.BlockRuinHolder::new);
        register(com.gmm.gctall.block.BlockVoidSeedContainer::new);
        register(com.gmm.gctall.block.BlockPrimordialPortalHolder::new);
        register(com.gmm.gctall.block.BlockPrimordialPortalHolder2::new);
        register(com.gmm.gctall.block.BlockArcaneVisReceiver::new);
        register(com.gmm.gctall.block.BlockPrimordialVisReceiver::new);
        register(com.gmm.gctall.block.BlockPrimordialStone::new);
        register(com.gmm.gctall.block.BlockPrimordialStonebrick::new);
        register(com.gmm.gctall.block.BlockPrimordialStoneStairs::new);
        register(com.gmm.gctall.block.BlockPrimordialStonebrickStairs::new);
        register(com.gmm.gctall.block.BlockPrimordialStoneSlab::new);
        register(com.gmm.gctall.block.BlockPrimordialStonebrickSlab::new);
        register(com.gmm.gctall.block.BlockPrimordialStoneWall::new);
        register(com.gmm.gctall.block.BlockPrimordialStonebrickWall::new);
        register(com.gmm.gctall.block.BlockBesideVoidPortal1::new);
        register(com.gmm.gctall.block.BlockBesideVoidPortal2::new);
        register(com.gmm.gctall.block.BlockBesideVoidPortal3::new);
        register(com.gmm.gctall.block.BlockLivingwoodLog::new);
        register(com.gmm.gctall.block.BlockEvileyeLog::new);
        register(com.gmm.gctall.block.BlockEvileyePlank::new);
        register(com.gmm.gctall.block.BlockEvileyeStair::new);
        register(com.gmm.gctall.block.BlockEvileyeSlab::new);
        register(com.gmm.gctall.block.BlockEvileyeFence::new);
        register(com.gmm.gctall.block.BlockLivingwoodLeaves::new);
        register(com.gmm.gctall.block.BlockEvileyeLeaves::new);
        register(com.gmm.gctall.world.dimension.WorldBesideVoid::new);
        register(com.gmm.gctall.item.crafting.RecipeApocalypsiumSti::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseCubeHurt::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseBomb::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseCubeSkill::new);
        register(com.gmm.gctall.procedure.ProcedureProCurseOfTwilightTick::new);
        register(com.gmm.gctall.potion.PotionCurseOfTwilight::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseDeath::new);
        register(com.gmm.gctall.procedure.ProcedureProChannelingTick::new);
        register(com.gmm.gctall.potion.PotionChanneling::new);
        register(com.gmm.gctall.item.crafting.RecipeApocalypsiumDti::new);
        register(com.gmm.gctall.potion.PotionBlueScreen::new);
        register(com.gmm.gctall.procedure.ProcedureProBlueScreenTick::new);
        register(com.gmm.gctall.gui.overlay.OverlayBlueScreenOverlay::new);
        register(com.gmm.gctall.procedure.ProcedureProAntiAnyPosionTick::new);
        register(com.gmm.gctall.potion.PotionAntiAnyposion::new);
        register(com.gmm.gctall.procedure.ProcedureProWorldEndTick::new);
        register(com.gmm.gctall.potion.PotionWorldEnd::new);
        register(com.gmm.gctall.procedure.ProcedureProOverrestrainTick::new);
        register(com.gmm.gctall.potion.PotionOverrestrain::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortal::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortalUp::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortalDown::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortalBegin::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortalDestroy::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidPortalDestroy2::new);
        register(com.gmm.gctall.world.biome.BiomeBloodyplain::new);
        register(com.gmm.gctall.world.biome.BiomeCurruptplain::new);
        register(com.gmm.gctall.procedure.ProcedureProBesideVoidTeleport::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseKnightSkill::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseBarrierClick::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseAltarClick::new);
        register(com.gmm.gctall.world.biome.BiomeManaForest::new);
        register(com.gmm.gctall.block.BlockApocalypseAltarBase::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseAltarTick::new);
        register(com.gmm.gctall.item.crafting.RecipeManaCobbleStoneSmelt::new);
        register(com.gmm.gctall.procedure.ProcedureProZethurSkill::new);
        register(com.gmm.gctall.entity.EntityZethur::new);
        register(com.gmm.gctall.entity.EntityWeatherEyevil::new);
        register(com.gmm.gctall.entity.EntityWeatherWaterRod::new);
        register(com.gmm.gctall.procedure.ProcedureProWaterRodSkill::new);
        register(com.gmm.gctall.procedure.ProcedureProWaterRodClear::new);
        register(com.gmm.gctall.procedure.ProcedureProWeatherBeholderSkill::new);
        register(com.gmm.gctall.entity.EntityApocalypseHolder::new);
        register(com.gmm.gctall.procedure.ProcedureProApocalypseHolder::new);
        register(com.gmm.gctall.block.BlockSolokLog::new);
        register(com.gmm.gctall.block.BlockSolokPlank::new);
        register(com.gmm.gctall.block.BlockSolokLeaves::new);
        register(com.gmm.gctall.block.BlockSolokStair::new);
        register(com.gmm.gctall.block.BlockSolokSlab::new);
        register(com.gmm.gctall.block.BlockSolokFence::new);
        register(com.gmm.gctall.block.BlockWildplainLog::new);
        register(com.gmm.gctall.block.BlockWildplainPlank::new);
        register(com.gmm.gctall.block.BlockWildplainStair::new);
        register(com.gmm.gctall.block.BlockWildplainSlab::new);
        register(com.gmm.gctall.block.BlockWildplainFence::new);
        register(com.gmm.gctall.block.BlockWildplainLeaves::new);
        register(com.gmm.gctall.block.BlockDrurceLog::new);
        register(com.gmm.gctall.block.BlockDrurcePlank::new);
        register(com.gmm.gctall.block.BlockMeteor::new);
        register(com.gmm.gctall.world.dimension.WorldEverheaven::new);
        register(com.gmm.gctall.world.biome.BiomeEverheavenWaste::new);
        register(com.gmm.gctall.block.BlockHeavite::new);
        register(com.gmm.gctall.world.structure.StructureHeavenStonePostSmall::new);
        register(com.gmm.gctall.world.structure.StructureHeavenStonePostSmall2::new);
        register(com.gmm.gctall.world.structure.StructureHeavenStonePostLarge::new);
        register(com.gmm.gctall.world.structure.StructureHeavenPortal::new);
        register(com.gmm.gctall.block.BlockAlfCobbleStone::new);
        register(com.gmm.gctall.world.dimension.WorldAlfheim::new);
        register(com.gmm.gctall.block.BlockAlfGrass::new);
        register(com.gmm.gctall.block.BlockAlfDirt::new);
        register(com.gmm.gctall.block.BlockAlfStone::new);
        register(com.gmm.gctall.block.BlockAlfSand::new);
        register(com.gmm.gctall.block.BlockDreamwoodLog::new);
        register(com.gmm.gctall.block.BlockDreamwoodLeaves::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimPlain::new);
        register(com.gmm.gctall.world.biome.BiomeManaForestHill::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimPlainHill::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimDesert::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimDesertHill::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimDesertRichland::new);
        register(com.gmm.gctall.block.BlockOrichalcosDreamwood::new);
        register(com.gmm.gctall.block.BlockElementiumOre::new);
        register(com.gmm.gctall.block.BlockTerrasteelOre::new);
        register(com.gmm.gctall.block.BlockOrichalcosOre::new);
        register(com.gmm.gctall.gui.GuiKabalahBuilder::new);
        register(com.gmm.gctall.item.ItemRuneActive1::new);
        register(com.gmm.gctall.item.ItemRuneActive2::new);
        register(com.gmm.gctall.item.ItemRuneActive3::new);
        register(com.gmm.gctall.item.ItemRuneActive4::new);
        register(com.gmm.gctall.item.ItemRuneActive5::new);
        register(com.gmm.gctall.item.ItemRuneActive6::new);
        register(com.gmm.gctall.item.ItemRuneActive7::new);
        register(com.gmm.gctall.item.ItemRuneActive8::new);
        register(com.gmm.gctall.item.ItemRuneActive9::new);
        register(com.gmm.gctall.item.ItemRuneActive10::new);
        register(com.gmm.gctall.item.ItemKabalahRingAur::new);
        register(com.gmm.gctall.item.ItemKabalahRingSoph::new);
        register(com.gmm.gctall.item.ItemKabalahRingAin::new);
        register(com.gmm.gctall.block.BlockKabalahBuilderBlock::new);
        register(com.gmm.gctall.procedure.ProcedureProKabalahBuilderRecipe::new);
        register(com.gmm.gctall.procedure.ProcedureProKabalanBuilderTake::new);
        register(com.gmm.gctall.world.dimension.WorldAtlantis::new);
        register(com.gmm.gctall.procedure.ProcedureProElderGuardianDeath::new);
        register(com.gmm.gctall.block.BlockReversedAlfGrass::new);
        register(com.gmm.gctall.block.BlockReversedAlfDirt::new);
        register(com.gmm.gctall.block.BlockReversedAlfStone::new);
        register(com.gmm.gctall.block.BlockReversedAlfCobbleStone::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodLeaves::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodLog::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodPlank::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodPlankRottened::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodStairs::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodSlab::new);
        register(com.gmm.gctall.block.BlockReversedDreamwoodFence::new);
        register(com.gmm.gctall.block.BlockManaBlock::new);
        register(com.gmm.gctall.world.biome.BiomeAlfheimForest::new);
        register(com.gmm.gctall.world.biome.BiomeReversedForest::new);
        register(com.gmm.gctall.item.ItemBotanicalIngot::new);
        register(com.gmm.gctall.item.ItemBotanicalIngotAwakened::new);
        register(com.gmm.gctall.item.ItemBotanicalSoul::new);
        register(com.gmm.gctall.entity.EntityElf::new);
        register(com.gmm.gctall.entity.EntityReversedElf::new);
        register(com.gmm.gctall.item.ItemElfPasses::new);
        register(com.gmm.gctall.item.ItemNaturalline::new);
        register(com.gmm.gctall.item.ItemNaturallineScrap::new);
        register(com.gmm.gctall.procedure.ProcedureProElfTrade::new);
        register(com.gmm.gctall.item.ItemOrichalcosFusionplate::new);
        register(com.gmm.gctall.item.ItemElementiumFusionplate::new);
        register(com.gmm.gctall.item.ItemManasteelFusionplate::new);
        register(com.gmm.gctall.block.BlockReserver::new);
        register(com.gmm.gctall.block.BlockReservedReserver::new);
        register(com.gmm.gctall.world.structure.StructureReversedDungeon::new);
        register(com.gmm.gctall.world.structure.StructureElvenPost::new);
        register(com.gmm.gctall.block.BlockBotanicalStone::new);
        register(com.gmm.gctall.item.ItemGaiaHeart::new);
        register(com.gmm.gctall.item.ItemRosiumIngot::new);
        register(com.gmm.gctall.item.ItemChrysanthemiumIngot::new);
        register(com.gmm.gctall.item.ItemDandelioniumIngot::new);
        register(com.gmm.gctall.item.ItemMyosotisiumIngot::new);
        register(com.gmm.gctall.item.ItemBegoniumIngot::new);
        register(com.gmm.gctall.item.ItemCarnationiumIngot::new);
        register(com.gmm.gctall.block.BlockAstralPortalCore::new);
        register(com.gmm.gctall.procedure.ProcedureProAstralPortal::new);
        register(com.gmm.gctall.block.BlockStarSoil::new);
        register(com.gmm.gctall.block.BlockStarGrass::new);
        register(com.gmm.gctall.block.BlockLunarSoil::new);
        register(com.gmm.gctall.block.BlockLunarGrass::new);
        register(com.gmm.gctall.block.BlockCrystalsand::new);
        register(com.gmm.gctall.block.BlockCrystalsandstone::new);
        register(com.gmm.gctall.block.BlockCrystalsandstoneSlab::new);
        register(com.gmm.gctall.block.BlockCrystalsandstoneStairs::new);
        register(com.gmm.gctall.block.BlockCrystalsandstoneWalls::new);
        register(com.gmm.gctall.block.BlockPolarisite::new);
        register(com.gmm.gctall.block.BlockPolarisiteDark::new);
        register(com.gmm.gctall.block.BlockPolarisiteSlab::new);
        register(com.gmm.gctall.block.BlockPolarisiteStair::new);
        register(com.gmm.gctall.block.BlockPolarisiteWall::new);
        register(com.gmm.gctall.block.BlockPolarisiteBrick::new);
        register(com.gmm.gctall.block.BlockPolarisiteDarkBrick::new);
        register(com.gmm.gctall.block.BlockPolarisiteDarkStair::new);
        register(com.gmm.gctall.block.BlockPolarisiteDarkSlab::new);
        register(com.gmm.gctall.block.BlockPolarisiteDarkWall::new);
        register(com.gmm.gctall.world.biome.BiomeAriesForest::new);
        register(com.gmm.gctall.world.dimension.WorldStarland::new);
        register(com.gmm.gctall.world.biome.BiomeTaurusPlataeu::new);
        register(com.gmm.gctall.world.biome.BiomeGeminiValley::new);
        register(com.gmm.gctall.world.biome.BiomeCancerHills::new);
        register(com.gmm.gctall.world.biome.BiomeLeoBadlands::new);
        register(com.gmm.gctall.world.biome.BiomeVirgoPlain::new);
        register(com.gmm.gctall.world.biome.BiomeCapricornsCliffs::new);
        register(com.gmm.gctall.world.biome.BiomeAquariusIceplain::new);
        register(com.gmm.gctall.world.biome.BiomePiscesOcean::new);
        register(com.gmm.gctall.world.biome.BiomeSagittariusDenseforest::new);
        register(com.gmm.gctall.world.biome.BiomeScorpioDesert::new);
        register(com.gmm.gctall.world.biome.BiomeLibraIsland::new);
        register(com.gmm.gctall.world.structure.StructureLibraIsland1::new);
        register(com.gmm.gctall.world.structure.StructureLibraIsland2::new);
        register(com.gmm.gctall.procedure.ProcedureProStarlandKick::new);
        register(com.gmm.gctall.item.ItemWaviteIngot::new);
        register(com.gmm.gctall.item.ItemElementineIngot::new);
        register(com.gmm.gctall.item.ItemGreedIngot::new);
        register(com.gmm.gctall.block.BlockResonateDebris::new);
        register(com.gmm.gctall.item.ItemResonatedScrap::new);
        register(com.gmm.gctall.block.BlockResonateDebrisCracked::new);
        register(com.gmm.gctall.procedure.ProcedureProResonateDebrisMine::new);
        register(com.gmm.gctall.procedure.ProcedureProResonateDebrisBomb::new);
        register(com.gmm.gctall.potion.PotionCorrecting::new);
        register(com.gmm.gctall.item.ItemEarthIngot::new);
        register(com.gmm.gctall.block.BlockEarthboundReceiver::new);
        register(com.gmm.gctall.block.BlockEarthboundCore::new);
        register(com.gmm.gctall.block.BlockEarthboundAltar::new);
        register(com.gmm.gctall.gui.GuiEarthbound::new);
        register(com.gmm.gctall.item.ItemEarthOrb::new);
        register(com.gmm.gctall.procedure.ProcedureProEarthboundReceiverParticle::new);
        register(com.gmm.gctall.procedure.ProcedureProEarthOrbGlow::new);
        register(com.gmm.gctall.item.ItemHolysteelIngot::new);
        register(com.gmm.gctall.procedure.ProcedureProEarthboundAltarClick::new);
        register(com.gmm.gctall.block.BlockGravityDebris::new);
        register(com.gmm.gctall.item.ItemGravityScrap::new);
        register(com.gmm.gctall.procedure.ProcedureProGravityDebrisTick::new);
        register(com.gmm.gctall.command.CommandGamemode1::new);
        register(com.gmm.gctall.procedure.ProcedureProGamemode1::new);
        register(com.gmm.gctall.procedure.ProcedureProGamemode2::new);
        register(com.gmm.gctall.procedure.ProcedureProGamemode3::new);
        register(com.gmm.gctall.procedure.ProcedureProGamemode0::new);
        register(com.gmm.gctall.command.CommandGamemode2::new);
        register(com.gmm.gctall.command.CommandGamemode3::new);
        register(com.gmm.gctall.command.CommandGamemode0::new);
        register(com.gmm.gctall.block.BlockManaStraw::new);
        register(com.gmm.gctall.block.BlockManaStrawSmall::new);
        register(com.gmm.gctall.block.BlockManaLog::new);
        register(com.gmm.gctall.block.BlockManaLeaves::new);
        register(com.gmm.gctall.block.BlockManaPlank::new);
        register(com.gmm.gctall.block.BlockManaStairs::new);
        register(com.gmm.gctall.block.BlockManaSlab::new);
        register(com.gmm.gctall.block.BlockManaFence::new);
    }

    private void registerSounds() {
        registerSound("remnant_ambient");
        registerSound("zjarugoth_roar");
        registerSound("shoggoth_ambient");
        registerSound("chant_abyss");
        registerSound("shoggoth_death");
        registerSound("shoggoth_hurt");
        registerSound("bligtz_br");
        registerSound("bninz_br");
        registerSound("bninz_ht");
        registerSound("bninz_de");
        registerSound("bligtz_ht");
        registerSound("bligtz_de");
        registerSound("bnatuz_br");
        registerSound("bnatuz_ht");
        registerSound("bnatuz_de");
        registerSound("bthdz_br");
        registerSound("bthdz_ht");
        registerSound("bthdz_de");
        registerSound("reversedlands");
    }

    private void register(Function<GctAllContent, GctAllElement> factory) {
        elements.add(factory.apply(this));
    }

    private void registerSound(String name) {
        ResourceLocation id = new ResourceLocation(Tags.MOD_ID, name);
        sounds.put(id, new SoundEvent(id));
    }

    public void preInit(FMLPreInitializationEvent event) {
        addNetworkMessage(GctAllVariables.WorldSavedDataSyncMessageHandler.class,
                GctAllVariables.WorldSavedDataSyncMessage.class, Side.SERVER, Side.CLIENT);
    }

    public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        sounds.forEach((id, sound) -> event.getRegistry().register(sound.setRegistryName(id)));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        int dimensionId = world.provider.getDimension();
        elements.forEach(element -> element.generateWorld(random, blockX, blockZ, world, dimensionId,
                chunkGenerator, chunkProvider));
    }

    @Override
    public int getBurnTime(ItemStack fuel) {
        for (GctAllElement element : elements) {
            int burnTime = element.addFuel(fuel);
            if (burnTime != 0) {
                return burnTime;
            }
        }
        return 0;
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.world.isRemote && event.player instanceof EntityPlayerMP) {
            WorldSavedData mapData = GctAllVariables.MapVariables.get(event.player.world);
            WorldSavedData worldData = GctAllVariables.WorldVariables.get(event.player.world);
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            GctAllNetwork.CHANNEL.sendTo(new GctAllVariables.WorldSavedDataSyncMessage(0, mapData), player);
            GctAllNetwork.CHANNEL.sendTo(new GctAllVariables.WorldSavedDataSyncMessage(1, worldData), player);
        }
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.world.isRemote && event.player instanceof EntityPlayerMP) {
            WorldSavedData worldData = GctAllVariables.WorldVariables.get(event.player.world);
            GctAllNetwork.CHANNEL.sendTo(new GctAllVariables.WorldSavedDataSyncMessage(1, worldData),
                    (EntityPlayerMP) event.player);
        }
    }

    public <T extends IMessage, V extends IMessage> void addNetworkMessage(
            Class<? extends IMessageHandler<T, V>> handler, Class<T> messageClass, Side... sides) {
        GctAllNetwork.register(handler, messageClass, sides);
    }

    public List<GctAllElement> getElements() {
        return elements;
    }

    public List<Supplier<Block>> getBlocks() {
        return blocks;
    }

    public List<Supplier<Item>> getItems() {
        return items;
    }

    public List<Supplier<Biome>> getBiomes() {
        return biomes;
    }

    public List<Supplier<EntityEntry>> getEntities() {
        return entities;
    }

    public List<Supplier<Potion>> getPotions() {
        return potions;
    }

    public List<Supplier<PotionType>> getPotionTypes() {
        return potionTypes;
    }

    public List<ItemModel> getItemModels() {
        return itemModels;
    }

    public static final class ItemModel {
        private final Supplier<Item> item;
        private final String registryName;

        public ItemModel(Supplier<Item> item, String registryName) {
            this.item = item;
            this.registryName = registryName;
        }

        public Item getItem() {
            return item.get();
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}
