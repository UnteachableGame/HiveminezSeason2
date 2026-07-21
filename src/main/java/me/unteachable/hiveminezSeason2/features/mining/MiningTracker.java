package me.unteachable.hiveminezSeason2.features.mining;

import java.util.HashMap;
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
