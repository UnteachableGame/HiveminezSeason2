package me.unteachable.hiveminezSeason2.features.mining;

import me.unteachable.hiveminezSeason2.items.OreItems;
import me.unteachable.hiveminezSeason2.utils.MiningInfo;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class DropManager {

    public final Map<Material, MiningInfo> dropInfoMap;
    public final Map<String, Integer> toolBaseMaterialTier;

    public DropManager() {
        this.dropInfoMap = new HashMap<>();
        this.toolBaseMaterialTier = new HashMap<>();
    }

    public Map<Material, MiningInfo> getDropInfoMap() {
        return dropInfoMap;
    }

    public Map<String, Integer> getToolBaseMaterialTier() {
        return toolBaseMaterialTier;
    }

    public void makeDrops() {
        OreItems ores = new OreItems();

        toolBaseMaterialTier.put("wood", 1);
        toolBaseMaterialTier.put("stone", 2);
        toolBaseMaterialTier.put("coal", 3);
        toolBaseMaterialTier.put("copper", 4);
        toolBaseMaterialTier.put("iron", 5);
        toolBaseMaterialTier.put("gold", 6);
        toolBaseMaterialTier.put("redstone", 7);
        toolBaseMaterialTier.put("lapis", 8);
        toolBaseMaterialTier.put("emerald", 9);
        toolBaseMaterialTier.put("diamond", 10);
        toolBaseMaterialTier.put("netherite", 11);

        dropInfoMap.put(Material.OAK_LOG, new MiningInfo(ores.getSplinteredPineWood(), 1, false));
        dropInfoMap.put(Material.MANGROVE_LOG, new MiningInfo(ores.getSplinteredPineWood(), 1, true));
        dropInfoMap.put(Material.STONE, new MiningInfo(ores.getGrittyShaleStone(), 2, false));
        dropInfoMap.put(Material.COBBLESTONE, new MiningInfo(ores.getGrittyShaleStone(), 2, true));
        dropInfoMap.put(Material.COAL_ORE, new MiningInfo(ores.getSplinteredPineWood(), 3, false));
        dropInfoMap.put(Material.COAL_BLOCK, new MiningInfo(ores.getSplinteredPineWood(), 3, true));
        dropInfoMap.put(Material.COPPER_ORE, new MiningInfo(ores.getGrittyShaleStone(), 4, false));
        dropInfoMap.put(Material.RAW_COPPER_BLOCK, new MiningInfo(ores.getGrittyShaleStone(), 4, true));
    }

}
