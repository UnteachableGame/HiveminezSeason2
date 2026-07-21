package me.unteachable.hiveminezSeason2.features.mining;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import me.unteachable.hiveminezSeason2.utils.manager.AllItemsManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Compressor {

    private HiveminezSeason2 plugin;

    public Compressor(HiveminezSeason2 plugin) {
        this.plugin = plugin;
    }

    public HiveminezSeason2 getPlugin() {
        return plugin;
    }

    public void compressItemInfo(Player p) {
        Map<ItemStack, String> ores = HiveminezSeason2.getAllItemsManager().getOreItems();
        List<ItemStack> oresList = new ArrayList<>(ores.keySet());

        int oreIndex = 1;
        int oresListInt = 0;

        // Loops through all the items in the ores list to prioritize the first lower items first to convert,
        for (int i = 0; i < oresList.size(); i++) {
            FileConfiguration config = getPlugin().getConfig();

            // then it gets the item in the inventory, and
            ItemStack ore = oresList.get(i);
            ItemStack playerOreItem = null;

//            p.sendMessage("1. Index via Ore List: " + i + " w/ Item: " + ore.getItemMeta().getDisplayName());

            // loops through the player's inventory to see if the player has the ore in the inventory,
            for (int j = 0; j < p.getInventory().getStorageContents().length; j++) {
                ItemStack playerItem = p.getInventory().getStorageContents()[j];
//                p.sendMessage("2. Index via Player's Inventory: " + j + " w/ Item: " + playerItem.getItemMeta().getDisplayName() + " is " + (Objects.equals(playerItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(getPlugin(), "ore-id"), PersistentDataType.STRING), ore.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(getPlugin(), "ore-id"), PersistentDataType.STRING))));
                if (playerItem == null || !playerItem.hasItemMeta()) continue;

                // checks if the item in the player's inventory has the data of ore-id.
                if (Objects.equals(playerItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING), ore.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING))) {
                    playerOreItem = playerItem;
//                    p.sendMessage(Prefix.translateColorCodes("Item: %s &rhas been found!", playerItem.getItemMeta().getDisplayName()));
                    break;
                }
            }

            // After we know that the ore is an ore in the player's inventory,
            if (playerOreItem == null) continue;
            // make a new clone of the ore to then change the data.
            ItemStack newPlayerOreItem = playerOreItem.clone();

            // Check for safe cases of the new item to make sure we are still good.
            if (!newPlayerOreItem.hasItemMeta()) return;

            // This gets the type of the ore to then get the amount that is required to convert.
            String oreType = ores.get(newPlayerOreItem); // Then it will get the int of the type of item from the map and then from the config.
            int requiredOreAmount = config.getInt(String.format("ores.%s.%d", oreType, oreIndex));
//            p.sendMessage("Config Required Amount: " + requiredOreAmount);

            // This gets the items that are required to convert and item that will be rewarded after the conversion.
            ItemStack newRequiredItem = AllItemsManager.addItemCloneAmount(oresList.get(oresListInt), requiredOreAmount);
            ItemStack newRewardItem = AllItemsManager.addItemCloneAmount(oresList.get(oresListInt + 1), 1);

            // This is getting the persistent data container string of the item id.
            String id = newRequiredItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING);
            // Finds how many of that item there are in the player's inventory by the required item's id cost.
            int totalAmountOfOreTypeInPlayerInventory = getTotalOreAmountInInventoryByOreId(p, id);

            // This should convert all of that one ore item type items for one conversion based upon the required item amount and the reward amount.
            compress(p, totalAmountOfOreTypeInPlayerInventory, newRequiredItem, newRewardItem, i);

            if (oreIndex == 6) {
                oreIndex = 0;
            }

            oreIndex++;
            oresListInt++;
        }
    }

    // This should convert all of that one ore item type items for one conversion based upon
    // the required item amount and the reward amount.

    public void compress(Player p, int totalOreFound, ItemStack requiredItem, ItemStack rewardItem, int i) {
        // This makes sure that the two items won't be null or empty.
        if (requiredItem.getItemMeta() == null) return;
        if (rewardItem.getItemMeta() == null) return;

        // This is divided by the amount needed in the config file.
        int requiredAmount = requiredItem.getAmount();

//        p.sendMessage("Total Ore Found: " + totalOreFound);
//        p.sendMessage("Required Amount: " + requiredAmount);

        int sets = totalOreFound / requiredAmount;

//        p.sendMessage("Sets of Item Type: " + sets);

        for (int j = 0; j < totalOreFound; j++) {
            // Check if the total ore found has less than the required amount to convert, exit the loop.
            if (sets < 0) break;

            // removes the appropriate amount of items out of the inventory.
            removeByOreId(p, requiredItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING), totalOreFound, i);

            ItemStack reward = rewardItem.clone();
            reward.setAmount(1); // This is 1 item per the rotation of the rewards.

            for (int k = 0; k < sets; k++) {
                p.getInventory().addItem(reward);
            }

            p.playSound(p.getLocation(), Sound.BLOCK_GRASS_BREAK, 1, 0);
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Prefix.translateColorCodes("&6&lAUTO-COMPRESS &fCompressed " + totalOreFound + " items!")));
        }
    }

    // This gives the amount of how many of that ore id there is in the player's inventory.
    public int getTotalOreAmountInInventoryByOreId(Player p, String targetId) {
        int count = 0;

        // Cycles through all the items in the player's inventory.
        for (ItemStack item : p.getInventory().getStorageContents()) {
            // This skips the empty slots in the inventory.
            if (item == null || !item.hasItemMeta()) continue;
            // This checks to see if the item has this specific persistent metadata.
            if (!Objects.requireNonNull(item.getItemMeta()).getPersistentDataContainer().has(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING)) continue;

            // This then gets the id since the item is an item, and it has metadata and persistent metadata.
            String id  = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING);
            // This then checks if the targeted id matches the id given in the ore persistent metadata and adds the item's amount to the count counter.
            if (targetId.equalsIgnoreCase(id)) {
                count += item.getAmount();
            }
        }
        return count;
    }

    private void removeByOreId(Player p, String targetId, int totalCompressed, int i) {
        for (int j = 0; j < p.getInventory().getStorageContents().length; j++) {
            // If there are no sets to compress, then don't run this code below.
            if (totalCompressed <= 0) return;
            // Retrieving each item in the player's inventory.
            ItemStack playerItem = p.getInventory().getStorageContents()[i];
            if (playerItem == null || !playerItem.hasItemMeta()) return;

            // Checks if the ore is an ore with the ore-id namespace.
            if (playerItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING).equalsIgnoreCase(targetId)) {
                int playerItemAmount = playerItem.getAmount();

                // Removes the ore items in the player's inventory above a stack.
                if (playerItemAmount <= totalCompressed) {
                    totalCompressed -= playerItemAmount;
                    // Removes the Item Stack one by one from the player's inventory by the amount of loops.
                    p.getInventory().setItem(i, null);

                    // Removes the ore items in the player's inventory below stack.
                } else {
                    // Otherwise, remove a partial of the Item Stack to the correct number.
                    playerItem.setAmount(playerItemAmount - totalCompressed);
                    totalCompressed = 0;
                }
            }
        }
    }

}
