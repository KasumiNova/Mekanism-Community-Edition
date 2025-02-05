package mekanism.common;

import mekanism.common.item.*;
import mekanism.common.multipart.ItemGlowPanel;
import mekanism.common.multipart.ItemPartTransmitter;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder("Mekanism")
public class MekanismItems
{
	public static final Item EnrichedAlloy = new ItemAlloy().setUnlocalizedName("EnrichedAlloy");
	public static final Item ReinforcedAlloy = new ItemAlloy().setUnlocalizedName("ReinforcedAlloy");
	public static final Item AtomicAlloy = new ItemAlloy().setUnlocalizedName("AtomicAlloy");
	public static final Item TeleportationCore = new ItemMekanism().setUnlocalizedName("TeleportationCore");
	public static final Item ElectrolyticCore = new ItemMekanism().setUnlocalizedName("ElectrolyticCore");
	public static final Item Substrate = new ItemMekanism().setUnlocalizedName("Substrate");
	public static final Item Polyethene = new ItemHDPE().setUnlocalizedName("HDPE");
	public static final Item BioFuel = new ItemMekanism().setUnlocalizedName("BioFuel");
	public static final Item ItemProxy = new ItemProxy().setUnlocalizedName("ItemProxy");
	public static final Item EnrichedIron = new ItemMekanism().setUnlocalizedName("EnrichedIron");
	public static final Item CompressedCarbon = new ItemMekanism().setUnlocalizedName("CompressedCarbon");
	public static final Item CompressedRedstone = new ItemMekanism().setUnlocalizedName("CompressedRedstone");
	public static final Item CompressedDiamond = new ItemMekanism().setUnlocalizedName("CompressedDiamond");
	public static final Item CompressedObsidian = new ItemMekanism().setUnlocalizedName("CompressedObsidian");
	public static final Item CompressedEnder = new ItemMekanism().setUnlocalizedName("CompressedEnder");
	public static final Item BrineBucket = new ItemMekanism().setMaxStackSize(1).setContainerItem(Items.bucket).setUnlocalizedName("BrineBucket");
	public static final Item LithiumBucket = new ItemMekanism().setMaxStackSize(1).setContainerItem(Items.bucket).setUnlocalizedName("LithiumBucket");
	public static final Item HeavyWaterBucket = new ItemMekanism().setMaxStackSize(1).setContainerItem(Items.bucket).setUnlocalizedName("HeavyWaterBucket");
	public static final Item SpeedUpgrade = new ItemUpgrade(Upgrade.SPEED).setUnlocalizedName("SpeedUpgrade");
	public static final Item EnergyUpgrade = new ItemUpgrade(Upgrade.ENERGY).setUnlocalizedName("EnergyUpgrade");
	public static final Item FilterUpgrade = new ItemUpgrade(Upgrade.FILTER).setUnlocalizedName("FilterUpgrade");
	public static final Item MufflingUpgrade = new ItemUpgrade(Upgrade.MUFFLING).setUnlocalizedName("MufflingUpgrade");
	public static final Item GasUpgrade = new ItemUpgrade(Upgrade.GAS).setUnlocalizedName("GasUpgrade");
	public static final Item TierInstaller = new ItemTierInstaller().setUnlocalizedName("FactoryInstaller");
	public static final ItemEnergized EnergyTablet = (ItemEnergized)new ItemEnergized(1000000).setUnlocalizedName("EnergyTablet");
	public static final ItemRobit Robit = (ItemRobit)new ItemRobit().setUnlocalizedName("Robit");
	public static final ItemAtomicDisassembler AtomicDisassembler = (ItemAtomicDisassembler)new ItemAtomicDisassembler().setUnlocalizedName("AtomicDisassembler");
	public static final ItemPortableTeleporter PortableTeleporter = (ItemPortableTeleporter)new ItemPortableTeleporter().setUnlocalizedName("PortableTeleporter");
	public static final ItemConfigurator Configurator = (ItemConfigurator)new ItemConfigurator().setUnlocalizedName("Configurator");
	public static final ItemNetworkReader NetworkReader = (ItemNetworkReader)new ItemNetworkReader().setUnlocalizedName("NetworkReader");
	public static final Item WalkieTalkie = new ItemWalkieTalkie().setUnlocalizedName("WalkieTalkie");
	public static final ItemElectricBow ElectricBow = (ItemElectricBow)new ItemElectricBow().setUnlocalizedName("ElectricBow");
	public static final ItemFlamethrower Flamethrower = (ItemFlamethrower)new ItemFlamethrower().setUnlocalizedName("Flamethrower");
	public static final ItemSeismicReader SeismicReader = (ItemSeismicReader)new ItemSeismicReader().setUnlocalizedName("SeismicReader");
	public static final Item Dictionary = new ItemDictionary().setUnlocalizedName("Dictionary");
	public static final ItemGaugeDropper GaugeDropper = (ItemGaugeDropper)new ItemGaugeDropper().setUnlocalizedName("GaugeDropper");
	public static final Item ConfigurationCard = new ItemConfigurationCard().setUnlocalizedName("ConfigurationCard");
	public static final Item CraftingFormula = new ItemCraftingFormula().setUnlocalizedName("CraftingFormula");
	public static final Item PartTransmitter = new ItemPartTransmitter().setUnlocalizedName("MultipartTransmitter");
	public static final Item GlowPanel = new ItemGlowPanel().setUnlocalizedName("GlowPanel");
	public static final ItemScubaTank ScubaTank = (ItemScubaTank)new ItemScubaTank().setUnlocalizedName("ScubaTank");
	public static final ItemGasMask GasMask = (ItemGasMask)new ItemGasMask().setUnlocalizedName("GasMask");
	public static final ItemJetpack Jetpack = (ItemJetpack)new ItemJetpack().setUnlocalizedName("Jetpack");
	public static final ItemJetpack ArmoredJetpack = (ItemJetpack)new ItemJetpack().setUnlocalizedName("ArmoredJetpack");
	public static final ItemFreeRunners FreeRunners = (ItemFreeRunners)new ItemFreeRunners().setUnlocalizedName("FreeRunners");
	public static final Item Balloon = new ItemBalloon().setUnlocalizedName("Balloon");

	//Multi-ID Items
	public static final Item OtherDust = new ItemOtherDust();
	public static final Item Dust = new ItemDust();
	public static final Item Sawdust = new ItemMekanism().setUnlocalizedName("Sawdust");
	public static final Item Salt = new ItemMekanism().setUnlocalizedName("Salt");
	public static final Item Yeast = new ItemMekanism().setUnlocalizedName("Yeast");

	public static final Item Ingot = new ItemIngot();
	public static final Item Clump = new ItemClump();
	public static final Item DirtyDust = new ItemDirtyDust();
	public static final Item Shard = new ItemShard();
	public static final Item Crystal = new ItemCrystal();
	public static final Item ControlCircuit = new ItemControlCircuit();

	/**
	 * Adds and registers all items.
	 */
	public static void register()
	{
		GameRegistry.registerItem(PartTransmitter, "PartTransmitter");
		GameRegistry.registerItem(ElectricBow, "ElectricBow");
		GameRegistry.registerItem(Dust, "Dust");
		GameRegistry.registerItem(Ingot, "Ingot");
		GameRegistry.registerItem(EnergyTablet, "EnergyTablet");
		GameRegistry.registerItem(SpeedUpgrade, "SpeedUpgrade");
		GameRegistry.registerItem(EnergyUpgrade, "EnergyUpgrade");
		GameRegistry.registerItem(FilterUpgrade, "FilterUpgrade");
		GameRegistry.registerItem(MufflingUpgrade, "MufflingUpgrade");
		GameRegistry.registerItem(GasUpgrade, "GasUpgrade");
		GameRegistry.registerItem(Robit, "Robit");
		GameRegistry.registerItem(AtomicDisassembler, "AtomicDisassembler");
		GameRegistry.registerItem(EnrichedAlloy, "EnrichedAlloy");
		GameRegistry.registerItem(ReinforcedAlloy, "ReinforcedAlloy");
		GameRegistry.registerItem(AtomicAlloy, "AtomicAlloy");
		GameRegistry.registerItem(ItemProxy, "ItemProxy");
		GameRegistry.registerItem(ControlCircuit, "ControlCircuit");
		GameRegistry.registerItem(EnrichedIron, "EnrichedIron");
		GameRegistry.registerItem(CompressedCarbon, "CompressedCarbon");
		GameRegistry.registerItem(CompressedRedstone, "CompressedRedstone");
		GameRegistry.registerItem(CompressedDiamond, "CompressedDiamond");
		GameRegistry.registerItem(CompressedObsidian, "CompressedObsidian");
		GameRegistry.registerItem(CompressedEnder, "CompressedEnder");
		GameRegistry.registerItem(PortableTeleporter, "PortableTeleporter");
		GameRegistry.registerItem(TeleportationCore, "TeleportationCore");
		GameRegistry.registerItem(Clump, "Clump");
		GameRegistry.registerItem(DirtyDust, "DirtyDust");
		GameRegistry.registerItem(Configurator, "Configurator");
		GameRegistry.registerItem(NetworkReader, "NetworkReader");
		GameRegistry.registerItem(WalkieTalkie, "WalkieTalkie");
		GameRegistry.registerItem(Jetpack, "Jetpack");
		GameRegistry.registerItem(Dictionary, "Dictionary");
		GameRegistry.registerItem(GasMask, "GasMask");
		GameRegistry.registerItem(ScubaTank, "ScubaTank");
		GameRegistry.registerItem(Balloon, "Balloon");
		GameRegistry.registerItem(Shard, "Shard");
		GameRegistry.registerItem(ElectrolyticCore, "ElectrolyticCore");
		GameRegistry.registerItem(Sawdust, "Sawdust");
		GameRegistry.registerItem(Salt, "Salt");
		GameRegistry.registerItem(Yeast, "Yeast");
		GameRegistry.registerItem(BrineBucket, "BrineBucket");
		GameRegistry.registerItem(LithiumBucket, "LithiumBucket");
		GameRegistry.registerItem(HeavyWaterBucket, "HeavyWaterBucket");
		GameRegistry.registerItem(Crystal, "Crystal");
		GameRegistry.registerItem(FreeRunners, "FreeRunners");
		GameRegistry.registerItem(ArmoredJetpack, "ArmoredJetpack");
		GameRegistry.registerItem(ConfigurationCard, "ConfigurationCard");
		GameRegistry.registerItem(CraftingFormula, "CraftingFormula");
		GameRegistry.registerItem(SeismicReader, "SeismicReader");
		GameRegistry.registerItem(Substrate, "Substrate");
		GameRegistry.registerItem(Polyethene, "Polyethene");
		GameRegistry.registerItem(BioFuel, "BioFuel");
		GameRegistry.registerItem(GlowPanel, "GlowPanel");
		GameRegistry.registerItem(Flamethrower, "Flamethrower");
		GameRegistry.registerItem(GaugeDropper, "GaugeDropper");
		GameRegistry.registerItem(TierInstaller, "FactoryInstaller");
		GameRegistry.registerItem(OtherDust, "OtherDust");

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid("brine"), new ItemStack(BrineBucket), FluidContainerRegistry.EMPTY_BUCKET);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid("lithium"), new ItemStack(LithiumBucket), FluidContainerRegistry.EMPTY_BUCKET);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid("heavywater"), new ItemStack(HeavyWaterBucket), FluidContainerRegistry.EMPTY_BUCKET);

		MinecraftForge.EVENT_BUS.register(GasMask);
		MinecraftForge.EVENT_BUS.register(FreeRunners);
	}
}
