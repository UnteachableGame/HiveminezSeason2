package me.unteachable.hiveminezSeason2.utils.manager;

import org.bukkit.inventory.ItemStack;

import java.util.*;

public class AllItemsManager {

    private final Map<ItemStack, String> oreItems;
    private final Map<ItemStack, String> toolItems;
    private final Map<ItemStack, String> weaponItems;

    public AllItemsManager() {
        this.oreItems = new LinkedHashMap<>();
        this.toolItems = new LinkedHashMap<>();
        this.weaponItems = new LinkedHashMap<>();
    }

    public Map<ItemStack, String> getOreItems() {
        return oreItems;
    }

    public Map<ItemStack, String> getToolItems() {
        return toolItems;
    }

    public Map<ItemStack, String> getWeaponItems() {
        return weaponItems;
    }

    public static ItemStack addItemCloneAmount(ItemStack item, int count) {
        ItemStack clone = item.clone();
        clone.setAmount(count);
        return clone;
    }
}
