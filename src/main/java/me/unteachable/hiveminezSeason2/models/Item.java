package me.unteachable.hiveminezSeason2.models;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.bukkit.inventory.meta.components.ToolComponent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Item extends ItemStack {

    private Material material;
    private int count = 1;
    private String displayName;
    private String[] displayStringFormat;
    private String color;
    private Object[][] enchantments;
    private Sound breakSound;
    private ItemRarity rarity;
    private boolean isUnbreakable = false;
    private List<String> lore;
    private String[] loreStringFormat;
    private boolean isGlowing = false;
    private boolean hideItemFlags = false;
    private List<ItemFlag> itemFlags;
    private Map<String, Object>[] persistentData;

    public Item() {}
    public Item(Material material) {
        this.material = material;
    }

    public Item count(int count) {
        this.count = count;
        return this;
    }
    public Item displayName(String displayName) {
        this.displayName = displayName;
//        this.color = color;
        System.out.println("Method Colors: " + color);
        return this;
    }
    public Item displayName(String displayName, String... displayStringFormat) {
        this.displayName = displayName;
        this.displayStringFormat = displayStringFormat;
        System.out.println("Method Arrays: " + Arrays.toString(displayStringFormat));
        return this;
    }
    public Item enchantments(Object[][] enchantments) {
        this.enchantments = enchantments;
        return this;
    }
    public Item breakSound(Sound breakSound) {
        this.breakSound = breakSound;
        return this;
    }
    public Item itemRarity(ItemRarity rarity) {
        this.rarity = rarity;
        return this;
    }
    public Item unbreakable() {
        isUnbreakable = true;
        return this;
    }
    public Item lore(String... lore) {
        this.lore = List.of(lore);
        return this;
    }
    public Item lore(List<String> lore) {
        this.lore = lore;
        return this;
    }
    public Item lore(List<String> lore, String... loreStringFormat) {
        this.lore = lore;
        this.loreStringFormat = loreStringFormat;
        return this;
    }
    public Item glowing() {
        isGlowing = true;
        return this;
    }
    public Item hideItemFlags() {
        this.hideItemFlags = true;
        return this;
    }
    public Item hideItemFlags(ItemFlag... itemFlags) {
        this.itemFlags = new ArrayList<>(List.of(itemFlags));
        return this;
    }
    @SafeVarargs
    public final Item persistentData(Map<String, Object>... persistentData) {
        this.persistentData = persistentData;
        return this;
    }

    // This will create the item based on the methods that were selected.
    public ItemStack createItem() {
        assert count != 0;
        ItemStack item = new ItemStack(material, count);
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;

        if (displayName != null) {
            String finalTitle;
            System.out.println(Arrays.toString(displayStringFormat));
            if (displayStringFormat != null && displayStringFormat.length > 0) {
                finalTitle = Prefix.translateColorCodes(displayName, (Object[]) displayStringFormat);
            } else {
                finalTitle = Prefix.translateColorCodes(displayName);
            }
            itemMeta.setDisplayName(finalTitle);
        }
        if (enchantments != null) {
            for (Object[] enchantment: enchantments) {
                Enchantment enchant = (Enchantment) enchantment[0];
                int level = (int) enchantment[1];
                boolean hasRestriction = (boolean) enchantment[2];
                itemMeta.addEnchant(enchant, level, hasRestriction);
            }
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (breakSound != null) {
            itemMeta.setBreakSound(breakSound);
        }
        if (rarity != null) {
            itemMeta.setRarity(rarity);
        }
        itemMeta.setUnbreakable(isUnbreakable);
        if (lore != null) {
            List<String> loreList = new ArrayList<>();
            for (String line : lore) {
                if (loreStringFormat != null && loreStringFormat.length > 0) {
                    loreList.add(Prefix.translateColorCodes(line, (Object[]) loreStringFormat));
                } else {
                    loreList.add(Prefix.translateColorCodes(line));
                }
            }
            itemMeta.setLore(loreList);
        }
        if (isGlowing) {
            itemMeta.addEnchant(Enchantment.INFINITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (hideItemFlags) {
            itemMeta.addItemFlags(ItemFlag.values());
        }
        if (itemFlags != null) {
            for (ItemFlag flag : itemFlags) {
                itemMeta.addItemFlags(flag);
            }
        }
        if (itemMeta instanceof Repairable) {
            ToolComponent toolMeta = itemMeta.getTool();
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            if (item.getType().equals(Material.WOODEN_PICKAXE) || item.getType().equals(Material.STONE_PICKAXE) ||
                    item.getType().equals(Material.COPPER_PICKAXE) || item.getType().equals(Material.IRON_PICKAXE) ||
                    item.getType().equals(Material.GOLDEN_PICKAXE) || item.getType().equals(Material.DIAMOND_PICKAXE) ||
                    item.getType().equals(Material.NETHERITE_PICKAXE)) {
                toolMeta.addRule(Tag.MINEABLE_PICKAXE, 100.0f, true);
                toolMeta.addRule(Tag.LOGS, 100.0f, true);
            }

            itemMeta.setTool(toolMeta);
        }
        if (persistentData != null) {
            PersistentDataContainer data = itemMeta.getPersistentDataContainer();
            for (Map<String, Object> map : persistentData) {
                map.forEach((key, value) -> data.set(new NamespacedKey(HiveminezSeason2.getPlugin(), key), getDataType(value), value));
            }
        }

        item.setItemMeta(itemMeta);
        return item;
    }

    public Object[] makeEnchantList(Enchantment enchantment, int level, boolean hasRestriction) {
        return new Object[]{enchantment, level, hasRestriction};
    }

    private PersistentDataType getDataType(Object value) {
        if (value instanceof String) return PersistentDataType.STRING;
        if (value instanceof Integer) return PersistentDataType.INTEGER;
        if (value instanceof Double) return PersistentDataType.DOUBLE;
        if (value instanceof Float) return PersistentDataType.FLOAT;
        if (value instanceof Boolean) return PersistentDataType.BOOLEAN;
        return null;
    }

    public Material getMaterial() {
        return material;
    }
    public int getCount() {
        return count;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String[] getDisplayStringFormat() {
        return displayStringFormat;
    }
    public String getColor() {
        return color;
    }
    public Sound getBreakSound() {
        return breakSound;
    }
    public ItemRarity getRarity() {
        return rarity;
    }
    public boolean isUnbreakable() {
        return isUnbreakable;
    }
    public List<String> getLore() {
        return lore;
    }
    public String[] getLoreStringFormat() {
        return loreStringFormat;
    }
    public boolean isGlowing() {
        return isGlowing;
    }
    public boolean isHideItemFlags() {
        return hideItemFlags;
    }
    public List<ItemFlag> getItemFlags() {
        return itemFlags;
    }
    public Map<String, Object>[] getPersistentData() {
        return persistentData;
    }
}
