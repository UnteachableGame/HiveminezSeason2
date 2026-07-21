package me.unteachable.hiveminezSeason2.models;

import org.bukkit.inventory.ItemStack;

public class MiningInfo {

    private final ItemStack drop;
    private final int tier;
    private final boolean hasMultiplier;

    public MiningInfo(ItemStack drop, int tier, boolean hasMultiplier) {
        this.drop = drop;
        this.tier = tier;
        this.hasMultiplier = hasMultiplier;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public int getTier() {
        return tier;
    }

    public boolean hasMultiplier() {
        return hasMultiplier;
    }
}
