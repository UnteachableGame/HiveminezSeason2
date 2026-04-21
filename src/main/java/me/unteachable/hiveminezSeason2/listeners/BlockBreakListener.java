package me.unteachable.hiveminezSeason2.listeners;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.items.OreItems;
import me.unteachable.hiveminezSeason2.utils.MiningInfo;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BlockBreakListener extends Prefix implements EventListener, Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
//        System.out.println("Listener Triggered!");

        Player p = e.getPlayer();
        Block b = e.getBlock();

        // Every Tier pickaxe will give double the last pickaxe in drops
        // T1 1 and 2
        // T2 2 and 4
        // T3 4 and 8 etc

        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            ItemStack mainHandItem = e.getPlayer().getInventory().getItemInMainHand();
            if (mainHandItem == null) return;
            if (!mainHandItem.hasItemMeta()) return;

            MiningInfo miningInfo = HiveminezSeason2.getDropManager().getDropInfoMap().get(b.getType());
            if (miningInfo == null) return;
            e.setCancelled(true);

            e.setDropItems(false);

            double amount = 0;

            ItemMeta meta = mainHandItem.getItemMeta();
            if (meta == null) return;

            if (meta.getPersistentDataContainer().has(new NamespacedKey(HiveminezSeason2.getPlugin(), "tool-tier"), PersistentDataType.INTEGER)) {

                Integer pickTier = meta.getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "tool-tier"), PersistentDataType.INTEGER);
                if (pickTier == null) return;

                // This is the tier check
                String toolType = meta.getPersistentDataContainer().get(new NamespacedKey(HiveminezSeason2.getPlugin(), "tool-id"), PersistentDataType.STRING);
                if (HiveminezSeason2.getDropManager().getToolBaseMaterialTier().get(toolType) >= miningInfo.getTier()) {
                    e.setCancelled(false);

                    amount = Math.pow(2, pickTier - 1);

                    if (miningInfo.hasMultiplier()) {
                        amount *= 2;
                    }
                }
            }

            for (int i = 0; i < (int) amount; i++) {
                b.getWorld().dropItem(b.getLocation().add(0.5, 0.2, 0.5), miningInfo.getDrop());
            }
        }
    }
}
