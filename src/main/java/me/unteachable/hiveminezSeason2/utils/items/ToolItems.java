package me.unteachable.hiveminezSeason2.utils.items;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.models.Item;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolItems {

    private ToolItems() {}

    private static final Item item = new Item();

    private static final String WOOD_HEX_COLOR_CODE = "&#92400E";
    private static final String STONE_HEX_COLOR_CODE = "&#64748B";
    private static final String COAL_HEX_COLOR_CODE = "&#1F2937";
    private static final String COPPER_HEX_COLOR_CODE = "&#B45309";
    private static final String IRON_HEX_COLOR_CODE = "&#E2E8F0";
    private static final String GOLD_HEX_COLOR_CODE = "&#FACC15";
    private static final String REDSTONE_HEX_COLOR_CODE = "&#EF4444";
    private static final String LAPIS_HEX_COLOR_CODE = "&#3B82F6";
    private static final String EMERALD_HEX_COLOR_CODE = "&#10B981";
    private static final String DIAMOND_HEX_COLOR_CODE = "&#06B6D4";
    private static final String NETHERITE_HEX_COLOR_CODE = "&#451A03";

    private static final String SEDIMENT_SLATE_COLOR_CODE = "&#94A3B8";
    private static final String OXIDIZED_CORE_COLOR_CODE = "&#F97316";
    private static final String CRYSTALLINE_MARROW_COLOR_CODE = "&#22D3EE";
    private static final String ABYSSAL_SHARD_COLOR_CODE = "&#6366F1";
    private static final String SENTIENT_PULSE_COLOR_CODE = "&#EC4899";
    private static final String SINGULARITY_COLOR_CODE = "&#1E1B4B";

    public static void setToolItemsInList() {
        Map<ItemStack, String> toolItemsList = HiveminezSeason2.getAllItemsManager().getToolItems();

        // Wood Tools
        toolItemsList.put(getT1SplinterPickaxe(), "wood");
        toolItemsList.put(getT2SplinterPickaxe(), "wood");
        toolItemsList.put(getT3SplinterPickaxe(), "wood");
        toolItemsList.put(getT4SplinterPickaxe(), "wood");
        toolItemsList.put(getT5SplinterPickaxe(), "wood");
        toolItemsList.put(getT6SplinterPickaxe(), "wood");
        // Stone Tools
        toolItemsList.put(getT1ChipperPickaxe(), "stone");
        toolItemsList.put(getT2ChipperPickaxe(), "stone");
        toolItemsList.put(getT3ChipperPickaxe(), "stone");
        toolItemsList.put(getT4ChipperPickaxe(), "stone");
        toolItemsList.put(getT5ChipperPickaxe(), "stone");
        toolItemsList.put(getT6ChipperPickaxe(), "stone");
        // Coal Tools
        toolItemsList.put(getT1EmberPickaxe(), "coal");
        toolItemsList.put(getT2EmberPickaxe(), "coal");
        toolItemsList.put(getT3EmberPickaxe(), "coal");
        toolItemsList.put(getT4EmberPickaxe(), "coal");
        toolItemsList.put(getT5EmberPickaxe(), "coal");
        toolItemsList.put(getT6EmberPickaxe(), "coal");
        // Copper Tools
        toolItemsList.put(getT1WireDrillPickaxe(), "copper");
        toolItemsList.put(getT2WireDrillPickaxe(), "copper");
        toolItemsList.put(getT3WireDrillPickaxe(), "copper");
        toolItemsList.put(getT4WireDrillPickaxe(), "copper");
        toolItemsList.put(getT5WireDrillPickaxe(), "copper");
        toolItemsList.put(getT6WireDrillPickaxe(), "copper");
        // Iron Tools
        toolItemsList.put(getT1HeavyBitPickaxe(), "iron");
        toolItemsList.put(getT2HeavyBitPickaxe(), "iron");
        toolItemsList.put(getT3HeavyBitPickaxe(), "iron");
        toolItemsList.put(getT4HeavyBitPickaxe(), "iron");
        toolItemsList.put(getT5HeavyBitPickaxe(), "iron");
        toolItemsList.put(getT6HeavyBitPickaxe(), "iron");
        // Gold Tools
        toolItemsList.put(getT1GildedPickaxe(), "gold");
        toolItemsList.put(getT2GildedPickaxe(), "gold");
        toolItemsList.put(getT3GildedPickaxe(), "wood");
        toolItemsList.put(getT4GildedPickaxe(), "gold");
        toolItemsList.put(getT5GildedPickaxe(), "gold");
        toolItemsList.put(getT6GildedPickaxe(), "gold");
        // Redstone Tools
        toolItemsList.put(getT1PulseDrillPickaxe(), "redstone");
        toolItemsList.put(getT2PulseDrillPickaxe(), "redstone");
        toolItemsList.put(getT3PulseDrillPickaxe(), "redstone");
        toolItemsList.put(getT4PulseDrillPickaxe(), "redstone");
        toolItemsList.put(getT5PulseDrillPickaxe(), "redstone");
        toolItemsList.put(getT6PulseDrillPickaxe(), "redstone");
        // Lapis Tools
        toolItemsList.put(getT1ManaPickaxe(), "lapis");
        toolItemsList.put(getT2ManaPickaxe(), "lapis");
        toolItemsList.put(getT3ManaPickaxe(), "lapis");
        toolItemsList.put(getT4ManaPickaxe(), "lapis");
        toolItemsList.put(getT5ManaPickaxe(), "lapis");
        toolItemsList.put(getT6ManaPickaxe(), "lapis");
        // Emerald Tools
        toolItemsList.put(getT1BerylSpadePickaxe(), "emerald");
        toolItemsList.put(getT2BerylSpadePickaxe(), "emerald");
        toolItemsList.put(getT3BerylSpadePickaxe(), "emerald");
        toolItemsList.put(getT4BerylSpadePickaxe(), "emerald");
        toolItemsList.put(getT5BerylSpadePickaxe(), "emerald");
        toolItemsList.put(getT6BerylSpadePickaxe(), "emerald");
        // Diamond Tools
        toolItemsList.put(getT1PrismPickaxe(), "diamond");
        toolItemsList.put(getT2PrismPickaxe(), "diamond");
        toolItemsList.put(getT3PrismPickaxe(), "diamond");
        toolItemsList.put(getT4PrismPickaxe(), "diamond");
        toolItemsList.put(getT5PrismPickaxe(), "diamond");
        toolItemsList.put(getT6PrismPickaxe(), "diamond");
        // Diamond Tools
        toolItemsList.put(getT1VoidBreakerPickaxe(), "netherite");
        toolItemsList.put(getT2VoidBreakerPickaxe(), "netherite");
        toolItemsList.put(getT3VoidBreakerPickaxe(), "netherite");
        toolItemsList.put(getT4VoidBreakerPickaxe(), "netherite");
        toolItemsList.put(getT5VoidBreakerPickaxe(), "netherite");
        toolItemsList.put(getT6VoidBreakerPickaxe(), "netherite");
    }

    // ------------------------- Wooden Tools ------------------------- //

    public static ItemStack getT1SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Stone Items ------------------------- //

    public static ItemStack getT1ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT1 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT2 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT3 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT4 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT5 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT6 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Coal Items ------------------------- //

    public static ItemStack getT1EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6EmberPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sEmber-Pick Pickaxe", COAL_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "coal", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Copper Items ------------------------- //

    public static ItemStack getT1WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT1 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT2 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT3 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT4 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT5 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6WireDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&aT6 %sWire-Drill Pickaxe", COPPER_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "copper", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Iron Items ------------------------- //

    public static ItemStack getT1HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT1 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT2 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT3 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT4 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT5 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6HeavyBitPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&aT6 %sHeavy-Bit Pickaxe", IRON_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "iron", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Gold Items ------------------------- //

    public static ItemStack getT1GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT1 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT2 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT3 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT4 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT5 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6GildedPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&aT6 %sGilded-Pick Pickaxe", GOLD_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "gold", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Redstone Items ------------------------- //

    public static ItemStack getT1PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6PulseDrillPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sPulse-Drill Pickaxe", REDSTONE_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "redstone", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Lapis Items ------------------------- //

    public static ItemStack getT1ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6ManaPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sMana-Pick Pickaxe", LAPIS_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "lapis", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Emerald Items ------------------------- //

    public static ItemStack getT1BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6BerylSpadePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sBeryl-Spade Pickaxe", EMERALD_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "emerald", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Diamond Items ------------------------- //

    public static ItemStack getT1PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT1 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT2 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT3 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT4 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT5 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6PrismPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&aT6 %sPrism-Pick Pickaxe", DIAMOND_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "diamond", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Netherite Items ------------------------- //

    public static ItemStack getT1VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT1 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT2VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT2 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT3VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT3 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT4VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT4 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT5VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT5 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public static ItemStack getT6VoidBreakerPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&aT6 %sVoid-Breaker Pickaxe", NETHERITE_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "netherite", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }
}
