package me.unteachable.hiveminezSeason2.features.mining;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Compressor {

    public static void compress(Player p, ItemStack item, ItemStack cost) {
        // This makes sure that this is an item that is not null or empty.
        ItemMeta costMeta = cost.getItemMeta();
        if (costMeta == null) return;

        String id = cost.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING);

        // Finds how many of that item there are by the cost's id.
        int totalFound = countByOreId(p, id);
        // 32 makes the compressing faster and more efficient.
        int sets = totalFound / 32;

        if (sets > 0) {
            p.playSound(p.getLocation(), Sound.BLOCK_GRASS_BREAK, 1, 0);

            removeByOreId(p, id, sets * 32);

            ItemStack reward = item.clone();
            reward.setAmount(sets);
            p.getInventory().addItem(reward);

            int totalCompressed = sets * 32;
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(new Prefix().translateColorCodes("&6&lAUTO-COMPRESS &fCompressed " + totalCompressed + " items!")));
        }
    }

    // This gives the amount of how many of that ore id there is in the player's inventory.
    private static int countByOreId(Player p, String targetId) {
        int count = 0;

        for (ItemStack item : p.getInventory().getStorageContents()) {
            // This skips the empty slots in the inventory
            if (item == null || !item.hasItemMeta()) continue;
            // This checks to see if the item has this specific persistent metadata.
            if (!item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING)) continue;

            // This then gets the id since the item is an item and it has metadata and persistent metadata.
            String id  = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING);
            // This then checks if the targeted id matches the id given in the ore persistent metadata and adds the item's amount to the count counter.
            if (targetId.equalsIgnoreCase(id)) count += item.getAmount();
        }
        return count;
    }

    private static void removeByOreId(Player p, String targetId, int toRemove) {
        ItemStack[] contents = p.getInventory().getStorageContents();

        for (int i = 0; i < contents.length; i++) {
            if (toRemove <= 0) break;

            ItemStack item = contents[i];
            if (item == null || !item.hasItemMeta()) continue;

            String id  = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "ore-id"), PersistentDataType.STRING);

            if (targetId.equalsIgnoreCase(id)) {
                int amount = item.getAmount();

                if (amount <= toRemove) {
                    toRemove -= amount;
                    p.getInventory().setItem(i, null);
                } else {
                    item.setAmount(amount - toRemove);
                    toRemove = 0;
                }
            }
        }
    }

}
