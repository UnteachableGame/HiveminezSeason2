package me.unteachable.hiveminezSeason2.features.mining.tracker;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MiningTracker {

    private final Map<UUID, Integer> playerDrops;

    public MiningTracker() {
        this.playerDrops = new HashMap<>();
    }

    public Map<UUID, Integer> getPlayerDrops() {
        return playerDrops;
    }
}
