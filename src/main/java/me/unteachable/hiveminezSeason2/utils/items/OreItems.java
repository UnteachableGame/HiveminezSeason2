package me.unteachable.hiveminezSeason2.utils.items;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.models.Item;
import me.unteachable.hiveminezSeason2.models.Ore;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OreItems {

    private OreItems() {}

    public static void setOreItemsInList() {
        Map<ItemStack, String> oreItemsList = HiveminezSeason2.getAllItemsManager().getOreItems();
        // Wood
        oreItemsList.put(getSplinteredPineWood(), "wood");
        oreItemsList.put(getCharredBarkWood(), "wood");
        oreItemsList.put(getAmberGlassWood(), "wood");
        oreItemsList.put(getSunkenDriftWood(), "wood");
        oreItemsList.put(getLivingRootWood(), "wood");
        oreItemsList.put(getWorldTreeSeedWood(), "wood");
        // Stone
        oreItemsList.put(getGrittyShaleStone(), "stone");
        oreItemsList.put(getMoltenSlateStone(), "stone");
        oreItemsList.put(getGeodeSlateStone(), "stone");
        oreItemsList.put(getMonolithShardStone(), "stone");
        oreItemsList.put(getPulsingPebbleStone(), "stone");
        oreItemsList.put(getDeepslateCoreStone(), "stone");
        // Coal
        oreItemsList.put(getPeatDustCoal(), "coal");
        oreItemsList.put(getBituminousCoal(), "coal");
        oreItemsList.put(getAnthraciteCoal(), "coal");
        oreItemsList.put(getPressureCarbonCoal(), "coal");
        oreItemsList.put(getShiftingSmokeCoal(), "coal");
        oreItemsList.put(getBlackHoleFuelCoal(), "coal");
        // Copper
        oreItemsList.put(getVerdigrisCopper(), "copper");
        oreItemsList.put(getRustedWireCopper(), "copper");
        oreItemsList.put(getTealSparkCopper(), "copper");
        oreItemsList.put(getTrenchWireCopper(), "copper");
        oreItemsList.put(getMagneticCoilCopper(), "copper");
        oreItemsList.put(getSuperconductorCopper(), "copper");
        // Iron
        oreItemsList.put(getRawFlakeIron(), "iron");
        oreItemsList.put(getCastIron(), "iron");
        oreItemsList.put(getSteelLusterIron(), "iron");
        oreItemsList.put(getHeavyPlateIron(), "iron");
        oreItemsList.put(getThumpingMetalIron(), "iron");
        oreItemsList.put(getPureNeutronIron(), "iron");
        // Gold
        oreItemsList.put(getSoftNuggetGold(), "gold");
        oreItemsList.put(getGildedScuffGold(), "gold");
        oreItemsList.put(getSolarGemGold(), "gold");
        oreItemsList.put(getDeepSeaGildGold(), "gold");
        oreItemsList.put(getLiquidGold(), "gold");
        oreItemsList.put(getCrownJewelGold(), "gold");
        // Redstone
        oreItemsList.put(getLowChargeRedstone(), "redstone");
        oreItemsList.put(getSparkWireRedstone(), "redstone");
        oreItemsList.put(getPulsingFiberRedstone(), "redstone");
        oreItemsList.put(getSignalVeinRedstone(), "redstone");
        oreItemsList.put(getNeuralPathRedstone(), "redstone");
        oreItemsList.put(getInfiniteLogicRedstone(), "redstone");
        // Lapis
        oreItemsList.put(getDyeSpeckLapis(), "lapis");
        oreItemsList.put(getAzureDustLapis(), "lapis");
        oreItemsList.put(getManaCrystalLapis(), "lapis");
        oreItemsList.put(getDeepInkGemLapis(), "lapis");
        oreItemsList.put(getArcaneEyeLapis(), "lapis");
        oreItemsList.put(getCosmicBlueLapis(), "lapis");
        // Emerald
        oreItemsList.put(getBerylChipEmerald(), "emerald");
        oreItemsList.put(getRoughJadeEmerald(), "emerald");
        oreItemsList.put(getRoyalBerylEmerald(), "emerald");
        oreItemsList.put(getDarkEmerald(), "emerald");
        oreItemsList.put(getGrowingVineEmerald(), "emerald");
        oreItemsList.put(getMerchantsHeartEmerald(), "emerald");
        // Diamond
        oreItemsList.put(getDullGemDiamond(), "diamond");
        oreItemsList.put(getCarbonEdgeDiamond(), "diamond");
        oreItemsList.put(getPrismGlassDiamond(), "diamond");
        oreItemsList.put(getPressureBlueDiamond(), "diamond");
        oreItemsList.put(getShiverGemDiamond(), "diamond");
        oreItemsList.put(getStarDiamond(), "diamond");
        // Netherite
        oreItemsList.put(getScrapDustNetherite(), "netherite");
        oreItemsList.put(getBurntIngotNetherite(), "netherite");
        oreItemsList.put(getSoulEssenceNetherite(), "netherite");
        oreItemsList.put(getVoidScrapNetherite(), "netherite");
        oreItemsList.put(getAncientHeartNetherite(), "netherite");
        oreItemsList.put(getTheEndOfTimeNetherite(), "netherite");
    }

    // ------------------------- Wood Items ------------------------- //

    public static ItemStack getSplinteredPineWood() {
        return new Item(Material.OAK_LOG)
                .displayName("%sSplintered Pine Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).createItem();
    }

    public static ItemStack getCharredBarkWood() {
        return new Ore(Material.JUNGLE_LOG)
                .displayName("%sCharred Bark Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).glowing().createItem();
    }

    public static ItemStack getAmberGlassWood() {
        return new Item(Material.SPRUCE_LOG)
                .displayName("%sAmber Glass Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).glowing().createItem();
    }

    public static ItemStack getSunkenDriftWood() {
        return new Item(Material.DARK_OAK_LOG)
                .displayName("%sSunken Drift Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).glowing().createItem();
    }

    public static ItemStack getLivingRootWood() {
        return new Item(Material.PALE_OAK_LOG)
                .displayName("%sLiving Root Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).glowing().createItem();
    }

    public static ItemStack getWorldTreeSeedWood() {
        return new Item(Material.ACACIA_LOG)
                .displayName("%sWorld Tree Seed Wood", Ore.WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(
                        new HashMap<>(Map.of(Ore.ORE_ID, "wood"))
//                        new HashMap<>(Map.of("ore-set", 1)),
//                        new HashMap<>(Map.of("ore-tier", 1))
                ).glowing().createItem();
    }

    // ------------------------- Stone Items ------------------------- //

    public static ItemStack getGrittyShaleStone() {
        return new Item(Material.COBBLESTONE)
                .displayName("%sGritty Shale Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).createItem();
    }

    public static ItemStack getMoltenSlateStone() {
        return new Item(Material.ANDESITE)
                .displayName("%sMolten Slate Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).glowing().createItem();
    }

    public static ItemStack getGeodeSlateStone() {
        return new Item(Material.STONE)
                .displayName("%sGeode Slate Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).glowing().createItem();
    }

    public static ItemStack getMonolithShardStone() {
        return new Item(Material.GRAVEL)
                .displayName("%sMonolith Shard Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).glowing().createItem();
    }

    public static ItemStack getPulsingPebbleStone() {
        return new Item(Material.TUFF)
                .displayName("%sPulsing Pebble Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).glowing().createItem();
    }

    public static ItemStack getDeepslateCoreStone() {
        return new Item(Material.COBBLED_DEEPSLATE)
                .displayName("%sDeepslate Core Stone", Ore.STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "stone"))).glowing().createItem();
    }

    // ------------------------- Coal Items ------------------------- //

    public static ItemStack getPeatDustCoal() {
        return new Item(Material.CHARCOAL)
                .displayName("%sPeat Dust Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).createItem();
    }

    public static ItemStack getBituminousCoal() {
        return new Item(Material.COAL)
                .displayName("%sBituminous Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).glowing().createItem();
    }

    public static ItemStack getAnthraciteCoal() {
        return new Item(Material.COAL_ORE)
                .displayName("%sAnthracite Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).glowing().createItem();
    }

    public static ItemStack getPressureCarbonCoal() {
        return new Item(Material.DEEPSLATE_COAL_ORE)
                .displayName("%sPressure Carbon Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).glowing().createItem();
    }

    public static ItemStack getShiftingSmokeCoal() {
        return new Item(Material.COAL_BLOCK)
                .displayName("%sShifting Smoke Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).glowing().createItem();
    }

    public static ItemStack getBlackHoleFuelCoal() {
        return new Item(Material.OBSIDIAN)
                .displayName("%sBlack Hole Fuel Coal", Ore.COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "coal"))).glowing().createItem();
    }

    // ------------------------- Copper Items ------------------------- //

    public static ItemStack getVerdigrisCopper() {
        return new Item(Material.COPPER_NUGGET)
                .displayName("%sVerdigris Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "copper"))).createItem();
    }

    public static ItemStack getRustedWireCopper() {
        return new Item(Material.RAW_COPPER)
                .displayName("%sRusted Wire Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "copper"))).glowing().createItem();
    }

    public static ItemStack getTealSparkCopper() {
        return new Item(Material.COPPER_INGOT)
                .displayName("%sTeal Spark Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "copper"))).glowing().createItem();
    }

    public static ItemStack getTrenchWireCopper() {
        return new Item(Material.RAW_COPPER_BLOCK)
                .displayName("%sTrench Wire Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "copper"))).glowing().createItem();
    }

    public static ItemStack getMagneticCoilCopper() {
        return new Item(Material.COPPER_ORE)
                .displayName("%sMagnetic Coil Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of(Ore.ORE_ID, "copper"))).glowing().createItem();
    }

    public static ItemStack getSuperconductorCopper() {
        return new Item(Material.DEEPSLATE_COPPER_ORE)
                .displayName("%sSuperconductor Copper", Ore.COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    // ------------------------- Iron Items ------------------------- //

    public static ItemStack getRawFlakeIron() {
        return new Item(Material.RAW_IRON)
                .displayName("%sRaw Flake Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).createItem();
    }

    public static ItemStack getCastIron() {
        return new Item(Material.RAW_IRON_BLOCK)
                .displayName("%sCast Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public static ItemStack getSteelLusterIron() {
        return new Item(Material.IRON_NUGGET)
                .displayName("%sSteel Luster Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public static ItemStack getHeavyPlateIron() {
        return new Item(Material.IRON_INGOT)
                .displayName("%sHeavy Plate Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public static ItemStack getThumpingMetalIron() {
        return new Item(Material.IRON_ORE)
                .displayName("%sThumping Metal Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public static ItemStack getPureNeutronIron() {
        return new Item(Material.DEEPSLATE_IRON_ORE)
                .displayName("%sPure Neutron Iron", Ore.IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    // ------------------------- Gold Items ------------------------- //

    public static ItemStack getSoftNuggetGold() {
        return new Item(Material.RAW_GOLD)
                .displayName("%sSoft Nugget Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "gold"))).createItem();
    }

    public static ItemStack getGildedScuffGold() {
        return new Item(Material.RAW_GOLD_BLOCK)
                .displayName("%sGilded Scuff Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "gold"))).glowing().createItem();
    }

    public static ItemStack getSolarGemGold() {
        return new Item(Material.GOLD_NUGGET)
                .displayName("%sSolar Gem Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "gold"))).glowing().createItem();
    }

    public static ItemStack getDeepSeaGildGold() {
        return new Item(Material.GOLD_INGOT)
                .displayName("%sDeep-Sea Gild Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "gold"))).glowing().createItem();
    }

    public static ItemStack getLiquidGold() {
        return new Item(Material.GOLD_ORE)
                .displayName("%sLiquid Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "gold"))).glowing().createItem();
    }

    public static ItemStack getCrownJewelGold() {
        return new Item(Material.DEEPSLATE_GOLD_ORE)
                .displayName("%sCrown Jewel Gold", Ore.GOLD_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    // ------------------------- Redstone Items ------------------------- //

    public static ItemStack getLowChargeRedstone() {
        return new Item(Material.REDSTONE)
                .displayName("%sLow Charge Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).createItem();
    }

    public static ItemStack getSparkWireRedstone() {
        return new Item(Material.REDSTONE_ORE)
                .displayName("%sSpark Wire Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).glowing().createItem();
    }

    public static ItemStack getPulsingFiberRedstone() {
        return new Item(Material.DEEPSLATE_REDSTONE_ORE)
                .displayName("%sPulsing Fiber Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).glowing().createItem();
    }

    public static ItemStack getSignalVeinRedstone() {
        return new Item(Material.FIRE_CORAL_BLOCK)
                .displayName("%sSignal Vein Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).glowing().createItem();
    }

    public static ItemStack getNeuralPathRedstone() {
        return new Item(Material.REDSTONE_BLOCK)
                .displayName("%sNeural Path Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).glowing().createItem();
    }

    public static ItemStack getInfiniteLogicRedstone() {
        return new Item(Material.NETHER_WART_BLOCK)
                .displayName("%sInfinite Logic Redstone", Ore.REDSTONE_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "redstone"))).glowing().createItem();
    }

    // ------------------------- Lapis Items ------------------------- //

    public static ItemStack getDyeSpeckLapis() {
        return new Item(Material.LAPIS_LAZULI)
                .displayName("%sDye Charge Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).createItem();
    }

    public static ItemStack getAzureDustLapis() {
        return new Item(Material.LAPIS_ORE)
                .displayName("%sAzure Dust Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).glowing().createItem();
    }

    public static ItemStack getManaCrystalLapis() {
        return new Item(Material.DEEPSLATE_LAPIS_ORE)
                .displayName("%sMana Crystal Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).glowing().createItem();
    }

    public static ItemStack getDeepInkGemLapis() {
        return new Item(Material.LAPIS_BLOCK)
                .displayName("%sDeep-Ink Gem Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).glowing().createItem();
    }

    public static ItemStack getArcaneEyeLapis() {
        return new Item(Material.DARK_PRISMARINE)
                .displayName("%sArcane Eye Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).glowing().createItem();
    }

    public static ItemStack getCosmicBlueLapis() {
        return new Item(Material.SCULK)
                .displayName("%sCosmic Blue Lapis", Ore.LAPIS_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "lapis"))).glowing().createItem();
    }

    // ------------------------- Emerald Items ------------------------- //

    public static ItemStack getBerylChipEmerald() {
        return new Item(Material.EMERALD)
                .displayName("%sBeryl Chip Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).createItem();
    }

    public static ItemStack getRoughJadeEmerald() {
        return new Item(Material.EMERALD_ORE)
                .displayName("%sRough Jade Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).glowing().createItem();
    }

    public static ItemStack getRoyalBerylEmerald() {
        return new Item(Material.DEEPSLATE_EMERALD_ORE)
                .displayName("%sRoyal Beryl Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).glowing().createItem();
    }

    public static ItemStack getDarkEmerald() {
        return new Item(Material.WAXED_WEATHERED_COPPER)
                .displayName("%sDark Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).glowing().createItem();
    }

    public static ItemStack getGrowingVineEmerald() {
        return new Item(Material.SLIME_BLOCK)
                .displayName("%sGrowing Vine Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).glowing().createItem();
    }

    public static ItemStack getMerchantsHeartEmerald() {
        return new Item(Material.EMERALD_BLOCK)
                .displayName("%sMerchant's Heart Emerald", Ore.EMERALD_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "emerald"))).glowing().createItem();
    }

    // ------------------------- Diamond Items ------------------------- //

    public static ItemStack getDullGemDiamond() {
        return new Item(Material.DIAMOND)
                .displayName("%sDull Gem Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).createItem();
    }

    public static ItemStack getCarbonEdgeDiamond() {
        return new Item(Material.DIAMOND_ORE)
                .displayName("%sCarbon Edge Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).glowing().createItem();
    }

    public static ItemStack getPrismGlassDiamond() {
        return new Item(Material.DEEPSLATE_DIAMOND_ORE)
                .displayName("%sPrism Glass Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).glowing().createItem();
    }

    public static ItemStack getPressureBlueDiamond() {
        return new Item(Material.PRISMARINE)
                .displayName("%sPressure Blue Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).glowing().createItem();
    }

    public static ItemStack getShiverGemDiamond() {
        return new Item(Material.PRISMARINE_BRICKS)
                .displayName("%sShiver Gem Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).glowing().createItem();
    }

    public static ItemStack getStarDiamond() {
        return new Item(Material.DIAMOND_BLOCK)
                .displayName("%sStar Diamond", Ore.DIAMOND_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "diamond"))).glowing().createItem();
    }

    // ------------------------- Netherite Items ------------------------- //

    public static ItemStack getScrapDustNetherite() {
        return new Item(Material.NETHERITE_SCRAP)
                .displayName("%sScrap Dust Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), Ore.SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).createItem();
    }

    public static ItemStack getBurntIngotNetherite() {
        return new Item(Material.ANCIENT_DEBRIS)
                .displayName("%sBurnt Ingot Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), Ore.OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).glowing().createItem();
    }

    public static ItemStack getSoulEssenceNetherite() {
        return new Item(Material.NETHERITE_INGOT)
                .displayName("%sSoul Essence Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), Ore.CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).glowing().createItem();
    }

    public static ItemStack getVoidScrapNetherite() {
        return new Item(Material.COBBLED_DEEPSLATE)
                .displayName("%sVoid Scrap Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), Ore.ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).glowing().createItem();
    }

    public static ItemStack getAncientHeartNetherite() {
        return new Item(Material.CHISELED_DEEPSLATE)
                .displayName("%sAncient Heart Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), Ore.SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).glowing().createItem();
    }

    public static ItemStack getTheEndOfTimeNetherite() {
        return new Item(Material.NETHERITE_BLOCK)
                .displayName("%sThe End Of Time Netherite", Ore.NETHERITE_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), Ore.SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "netherite"))).glowing().createItem();
    }

}
