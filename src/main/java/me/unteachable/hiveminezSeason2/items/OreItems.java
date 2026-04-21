package me.unteachable.hiveminezSeason2.items;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Item;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OreItems {

    private final String WOOD_HEX_COLOR_CODE = "&#92400E";
    private final String STONE_HEX_COLOR_CODE = "&#64748B";
    private final String COAL_HEX_COLOR_CODE = "&#1F2937";
    private final String COPPER_HEX_COLOR_CODE = "&#B45309";
    private final String IRON_HEX_COLOR_CODE = "&#E2E8F0";
    private final String GOLD_HEX_COLOR_CODE = "&#FACC15";
    private final String REDSTONE_HEX_COLOR_CODE = "&#EF4444";
    private final String LAPIS_HEX_COLOR_CODE = "&#3B82F6";
    private final String EMERALD_HEX_COLOR_CODE = "&#10B981";
    private final String DIAMOND_HEX_COLOR_CODE = "&#06B6D4";
    private final String NETHERITE_HEX_COLOR_CODE = "&#451A03";

    private final String SEDIMENT_SLATE_COLOR_CODE = "&#94A3B8";
    private final String OXIDIZED_CORE_COLOR_CODE = "&#D97706";
    private final String CRYSTALLINE_MARROW_COLOR_CODE = "&#22D3EE";
    private final String ABYSSAL_SHARD_COLOR_CODE = "&#1E3A8A";
    private final String SENTIENT_PULSE_COLOR_CODE = "&#F472B6";
    private final String SINGULARITY_COLOR_CODE = "&#2b3038";

    public void setOreItemsInList() {
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
    }

    // ------------------------- Wood Items ------------------------- //

    public ItemStack getSplinteredPineWood() {
        return new Item(Material.OAK_LOG)
                .displayName("%sSplintered Pine Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).createItem();
    }

    public ItemStack getCharredBarkWood() {
        return new Item(Material.JUNGLE_LOG)
                .displayName("%sCharred Bark Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).glowing().createItem();
    }

    public ItemStack getAmberGlassWood() {
        return new Item(Material.SPRUCE_LOG)
                .displayName("%sAmber Glass Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).glowing().createItem();
    }

    public ItemStack getSunkenDriftWood() {
        return new Item(Material.DARK_OAK_LOG)
                .displayName("%sSunken Drift Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).glowing().createItem();
    }

    public ItemStack getLivingRootWood() {
        return new Item(Material.PALE_OAK_LOG)
                .displayName("%sLiving Root Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).glowing().createItem();
    }

    public ItemStack getWorldTreeSeedWood() {
        return new Item(Material.ACACIA_LOG)
                .displayName("%sWorld Tree Seed Wood", WOOD_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "wood"))).glowing().createItem();
    }

    // ------------------------- Stone Items ------------------------- //

    public ItemStack getGrittyShaleStone() {
        return new Item(Material.COBBLESTONE)
                .displayName("%sGritty Shale Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).createItem();
    }

    public ItemStack getMoltenSlateStone() {
        return new Item(Material.ANDESITE)
                .displayName("%sMolten Slate Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).glowing().createItem();
    }

    public ItemStack getGeodeSlateStone() {
        return new Item(Material.STONE)
                .displayName("%sGeode Slate Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).glowing().createItem();
    }

    public ItemStack getMonolithShardStone() {
        return new Item(Material.GRAVEL)
                .displayName("%sMonolith Shard Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).glowing().createItem();
    }

    public ItemStack getPulsingPebbleStone() {
        return new Item(Material.TUFF)
                .displayName("%sPulsing Pebble Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).glowing().createItem();
    }

    public ItemStack getDeepslateCoreStone() {
        return new Item(Material.COBBLED_DEEPSLATE)
                .displayName("%sDeepslate Core Stone", STONE_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "stone"))).glowing().createItem();
    }

    // ------------------------- Coal Items ------------------------- //

    public ItemStack getPeatDustCoal() {
        return new Item(Material.CHARCOAL)
                .displayName("%sPeat Dust Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).createItem();
    }

    public ItemStack getBituminousCoal() {
        return new Item(Material.COAL)
                .displayName("%sBituminous Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).glowing().createItem();
    }

    public ItemStack getAnthraciteCoal() {
        return new Item(Material.COAL_ORE)
                .displayName("%sAnthracite Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).glowing().createItem();
    }

    public ItemStack getPressureCarbonCoal() {
        return new Item(Material.DEEPSLATE_COAL_ORE)
                .displayName("%sPressure Carbon Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).glowing().createItem();
    }

    public ItemStack getShiftingSmokeCoal() {
        return new Item(Material.COAL_BLOCK)
                .displayName("%sShifting Smoke Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).glowing().createItem();
    }

    public ItemStack getBlackHoleFuelCoal() {
        return new Item(Material.OBSIDIAN)
                .displayName("%sBlack Hole Fuel Coal", COAL_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "coal"))).glowing().createItem();
    }

    // ------------------------- Copper Items ------------------------- //

    public ItemStack getVerdigrisCopper() {
        return new Item(Material.COPPER_NUGGET)
                .displayName("%sVerdigris Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).createItem();
    }

    public ItemStack getRustedWireCopper() {
        return new Item(Material.RAW_COPPER)
                .displayName("%sRusted Wire Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    public ItemStack getTealSparkCopper() {
        return new Item(Material.COPPER_INGOT)
                .displayName("%sTeal Spark Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    public ItemStack getTrenchWireCopper() {
        return new Item(Material.RAW_COPPER_BLOCK)
                .displayName("%sTrench Wire Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    public ItemStack getMagneticCoilCopper() {
        return new Item(Material.COPPER_ORE)
                .displayName("%sMagnetic Coil Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    public ItemStack getSuperconductorCopper() {
        return new Item(Material.DEEPSLATE_COPPER_ORE)
                .displayName("%sSuperconductor Copper", COPPER_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "copper"))).glowing().createItem();
    }

    // ------------------------- Iron Items ------------------------- //

    public ItemStack getRawFlakeIron() {
        return new Item(Material.RAW_IRON)
                .displayName("%sRaw Flake Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSediment Slate", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).createItem();
    }

    public ItemStack getCastIron() {
        return new Item(Material.RAW_IRON_BLOCK)
                .displayName("%sCast Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sOxidized Core", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public ItemStack getSteelLusterIron() {
        return new Item(Material.IRON_NUGGET)
                .displayName("%sSteel Luster Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sCrystalline Marrow", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public ItemStack getHeavyPlateIron() {
        return new Item(Material.IRON_INGOT)
                .displayName("%sHeavy Plate Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sAbyssal Shard", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public ItemStack getThumpingMetalIron() {
        return new Item(Material.IRON_ORE)
                .displayName("%sThumping Metal Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSentient Pulse", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

    public ItemStack getPureNeutronIron() {
        return new Item(Material.DEEPSLATE_IRON_ORE)
                .displayName("%sPure Neutron Iron", IRON_HEX_COLOR_CODE)
                .lore(List.of("%sSingularity", "&8Item"), SINGULARITY_COLOR_CODE)
                .persistentData(new HashMap<>(Map.of("ore-id", "iron"))).glowing().createItem();
    }

}
