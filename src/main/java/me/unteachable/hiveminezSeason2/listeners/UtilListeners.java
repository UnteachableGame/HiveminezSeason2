package me.unteachable.hiveminezSeason2.listeners;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.base.menu.Menu;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.*;

public class UtilListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // if the player hasn't ever joined the server,
        if (!p.hasPlayedBefore()) {
            // if the player hasn't been added to the mining tracker list,
            if (!HiveminezSeason2.getMiningTracker().getPlayerDrops().containsKey(p.getUniqueId())) {
                // add the player to the list with a start count of 0.
                HiveminezSeason2.getMiningTracker().getPlayerDrops().put(p.getUniqueId(), 0);
            }
        }
    }

    @EventHandler
    public void onPlayerItemPickup(EntityPickupItemEvent e) {
        Player p = (Player) e.getEntity();
        Map<UUID, Integer> playerItemDropData = HiveminezSeason2.getMiningTracker().getPlayerDrops();

        // safety for if the player isn't in the list
        if (!playerItemDropData.containsKey(p.getUniqueId())) {
            playerItemDropData.put(p.getUniqueId(), 0);
        }

        // add the count of 1 to the list for the player
        playerItemDropData.replace(p.getUniqueId(), playerItemDropData.get(p.getUniqueId()) + 1);
//        p.sendMessage("Player's Drop Count: " + playerItemDropData.get(p.getUniqueId()));
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        InventoryHolder holder = Objects.requireNonNull(e.getClickedInventory()).getHolder();

        if (holder instanceof Menu m) {
            e.setCancelled(true);

            if (e.getCurrentItem() == null) {
                return;
            }

            m.handleMenu(e);
        }
    }

    @EventHandler
    public void onPlayerChat(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().equalsIgnoreCase("/plm reload HiveminezSeason2")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                for (ServerPlayer npc : HiveminezSeason2.getNpcManager().getNPCS().values()) {
                    HiveminezSeason2.getNpcManager().removeNPC(p, npc);
                }
            }
        }
    }
}
