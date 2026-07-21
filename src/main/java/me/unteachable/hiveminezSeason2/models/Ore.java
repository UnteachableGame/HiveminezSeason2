package me.unteachable.hiveminezSeason2.models;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ore extends Item {

    public static final String ORE_ID = "ore-id";

    // Sets
    public static final String WOOD_HEX_COLOR_CODE = "&#92400E";
    public static final String STONE_HEX_COLOR_CODE = "&#64748B";
    public static final String COAL_HEX_COLOR_CODE = "&#1F2937";
    public static final String COPPER_HEX_COLOR_CODE = "&#B45309";
    public static final String IRON_HEX_COLOR_CODE = "&#E2E8F0";
    public static final String GOLD_HEX_COLOR_CODE = "&#FACC15";
    public static final String REDSTONE_HEX_COLOR_CODE = "&#EF4444";
    public static final String LAPIS_HEX_COLOR_CODE = "&#3B82F6";
    public static final String EMERALD_HEX_COLOR_CODE = "&#10B981";
    public static final String DIAMOND_HEX_COLOR_CODE = "&#06B6D4";
    public static final String NETHERITE_HEX_COLOR_CODE = "&#451A03";

    // Tiers
    public static final String SEDIMENT_SLATE_COLOR_CODE = "&#94A3B8";
    public static final String OXIDIZED_CORE_COLOR_CODE = "&#D97706";
    public static final String CRYSTALLINE_MARROW_COLOR_CODE = "&#22D3EE";
    public static final String ABYSSAL_SHARD_COLOR_CODE = "&#1E3A8A";
    public static final String SENTIENT_PULSE_COLOR_CODE = "&#F472B6";
    public static final String SINGULARITY_COLOR_CODE = "&#2b3038";

    private int tier;
    private String tierName;
    private String tierColor;
    private int setNumber;
    private String setName;
    private String setColor;
    private String oreIdString;

    public Ore(Material material) {
        super(material);
    }

    // Setters
    public Ore setNumber(int set) {
        this.setNumber = set;
        return this;
    }
    public Ore setName(String setName) {
        this.setName = setName;
        return this;
    }
    public Ore setColor(String setColor) {
        this.setColor = setColor;
        return this;
    }
    public Ore tier(int tier) {
        this.tier = tier;
        return this;
    }
    public Ore tierName(String tierName) {
        this.tierName = tierName;
        return this;
    }
    public Ore tierColor(String tierColor) {
        this.tierColor = tierColor;
        return this;
    }
    public Ore oreIdString(String oreIdString) {
        this.oreIdString = oreIdString;
        return this;
    }

    public ItemStack createOreItem() {
        ItemStack item = createItem();
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        if (getSetName() != null) {
            displayName(getSetName());
        }
        if (getSetNumber() != 0) {
//            persistentData(, getSetNumber())));
        }
        if (getSetColor() != null) {
            displayName(getSetColor() + meta.getDisplayName());
        }

        List<String> lore = meta.getLore();
        if (getTierName() != null) {
            lore.set(0, getTierName());
        }
        if (getTier() != 0) {
            persistentData();
        }
        if (getTierColor() != null) {
            lore.set(0, getTierColor() + lore.getFirst());
        }

        item.setItemMeta(meta);
        return item;
    }

    // Getters
    public int getTier() {
        return tier;
    }
    public String getTierName() {
        return tierName;
    }
    public String getTierColor() {
        return tierColor;
    }
    public int getSetNumber() {
        return setNumber;
    }
    public String getSetName() {
        return setName;
    }
    public String getSetColor() {
        return setColor;
    }
    public String getOreIdString() {
        return oreIdString;
    }
}
