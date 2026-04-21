package me.unteachable.hiveminezSeason2.items;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Item;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolItems {

    Item item = new Item();

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
    private final String OXIDIZED_CORE_COLOR_CODE = "&#F97316";
    private final String CRYSTALLINE_MARROW_COLOR_CODE = "&#22D3EE";
    private final String ABYSSAL_SHARD_COLOR_CODE = "&#6366F1";
    private final String SENTIENT_PULSE_COLOR_CODE = "&#EC4899";
    private final String SINGULARITY_COLOR_CODE = "&#1E1B4B";

    public void setToolItemsInList() {
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
    }

    // ------------------------- Wooden Tools ------------------------- //

    public ItemStack getT1SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT1 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT2SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT2 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT3SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT3 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT4SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT4 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT5SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT5 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT6SplinterPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&aT6 %sSplinter Pickaxe", WOOD_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "wood", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Stone Items ------------------------- //

    public ItemStack getT1ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT1 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSediment Pickaxe", "&8Item"), SEDIMENT_SLATE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 1))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT2ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT2 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sOxidized Pickaxe", "&8Item"), OXIDIZED_CORE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 2))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT3ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT3 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sCrystalline Pickaxe", "&8Item"), CRYSTALLINE_MARROW_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 3))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT4ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT4 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sAbyssal Pickaxe", "&8Item"), ABYSSAL_SHARD_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 4))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT5ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT5 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSentient Pickaxe", "&8Item"), SENTIENT_PULSE_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 5))).enchantments(enchantments).unbreakable().createItem();
    }

    public ItemStack getT6ChipperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.STONE_PICKAXE).displayName("&aT6 %sChipper Pickaxe", STONE_HEX_COLOR_CODE).lore(List.of("%sSingularity Pickaxe", "&8Item"), SINGULARITY_COLOR_CODE)
                .hideItemFlags(ItemFlag.HIDE_UNBREAKABLE).persistentData(new HashMap<>(Map.of("tool-id", "stone", "tool-tier", 6))).enchantments(enchantments).unbreakable().createItem();
    }

    // ------------------------- Copper Items ------------------------- //

    public ItemStack getCoalPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&7&lEmber-Pick Pickaxe").lore("&7Miner Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getCopperPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.COPPER_PICKAXE).displayName("&6&lWire-Drill Pickaxe").lore("&7Wired Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getIronPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.IRON_PICKAXE).displayName("&f&lHeavy-Bit Pickaxe").lore("&4Starter Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getGoldPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.GOLDEN_PICKAXE).displayName("&e&lGilded-Pick Pickaxe").lore("&7Miner Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getRedstonePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&7&lPulse-Drill Pickaxe").lore("&7Wired Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getLapisPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&1&lMana-Pick Pickaxe").lore("&4Starter Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getEmeraldPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.WOODEN_PICKAXE).displayName("&a&lBeryl-Spade Pickaxe").lore("&7Beryl-Spade Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getDiamondPickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.DIAMOND_PICKAXE).displayName("&b&lPrism-Pick Pickaxe").lore("&7Prism-Pick Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }

    public ItemStack getNetheritePickaxe() {
        Object[][] enchantments = {item.makeEnchantList(Enchantment.EFFICIENCY, 255, true)};
        return new Item(Material.NETHERITE_PICKAXE).displayName("&8&lVoid-Breaker Pickaxe").lore("&7Void-Breaker Pickaxe").enchantments(enchantments)
                .unbreakable().hideItemFlags().createItem();
    }
}
