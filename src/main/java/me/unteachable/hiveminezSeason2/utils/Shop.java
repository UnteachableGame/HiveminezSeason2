package me.unteachable.hiveminezSeason2.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private final Map<ItemStack, Integer> requiredItems;
    private final Map<ItemStack, Integer> rewardItems;

    public Shop(Map<ItemStack, Integer> requiredItems, Map<ItemStack, Integer> rewardItems) {
        this.requiredItems = new HashMap<>(requiredItems);
        this.rewardItems = new HashMap<>(rewardItems);
    }

    public boolean checkRequiredItems(Player p) {
        Inventory inv = p.getInventory();

        int itemsPassed = 0;
        for (ItemStack requiredItem : requiredItems.keySet()) {
            int requiredCost = requiredItems.get(requiredItem);
            int amountFound = 0;

            for (ItemStack playerItem : inv.getStorageContents()) {
                if (playerItem == null || !playerItem.hasItemMeta()) continue;
                if (ChatColor.stripColor(requiredItem.getItemMeta().getDisplayName()).equalsIgnoreCase(ChatColor.stripColor(playerItem.getItemMeta().getDisplayName()))) {
                    amountFound += playerItem.getAmount();
                }
            }
            if (amountFound >= requiredCost) {
                itemsPassed++;
            }
        }
        return itemsPassed == requiredItems.size();
    }

    public void swapRequiredItemsForRewards(Player p) {
        Inventory inv = p.getInventory();

        // remove the items from the inventory
        for (ItemStack requiredItem : requiredItems.keySet()) {
            int requiredCost = requiredItems.get(requiredItem);

            for (int i = 0; i < inv.getStorageContents().length; i++) {
                ItemStack playerItem = inv.getStorageContents()[i];

                if (playerItem == null) continue;
                if (ChatColor.stripColor(requiredItem.getItemMeta().getDisplayName()).equalsIgnoreCase(ChatColor.stripColor(playerItem.getItemMeta().getDisplayName()))) {
                    int playerItemAmount = playerItem.getAmount();

                    if (playerItemAmount >= requiredCost) {
                        playerItem.setAmount(playerItem.getAmount() - requiredCost);
                    } else {
                        requiredCost -= playerItem.getAmount();
                        inv.setItem(i, null);
                    }

                    if (requiredCost == 0) break;
                }
            }
        }

        // adds the rewards to the inventory
        for (ItemStack rewardItem : rewardItems.keySet()) {
            int count = rewardItems.get(rewardItem);

            // This checks if the inventory is full
            for (int i = 0; i < count; i++) {
                Map<Integer, ItemStack> leftOver = inv.addItem(rewardItem);
                if (!leftOver.isEmpty()) {
                    p.getWorld().dropItem(p.getLocation(), rewardItem);
                }
            }
        }
    }

    public boolean purchase(Player p) {
        boolean hasRequiredItems = checkRequiredItems(p);

        if (hasRequiredItems) {
            swapRequiredItemsForRewards(p);
            return true;
        }
        return false;
    }
}
