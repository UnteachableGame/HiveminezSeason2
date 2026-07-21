package me.unteachable.hiveminezSeason2.features.menus;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.base.menu.PaginatedMenu;
import me.unteachable.hiveminezSeason2.base.menu.PlayerMenuUtility;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class CompressorInfoMenu extends PaginatedMenu {

    private final HiveminezSeason2 plugin;

    public CompressorInfoMenu(PlayerMenuUtility playerMenuUtility, HiveminezSeason2 plugin) {
        super(playerMenuUtility);
        this.plugin = plugin;
    }

    @Override
    public String getMenuName() {
        return "✪ Compressor Information ✪";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        // nothing

        menuFunction(e, true);
    }

    @Override
    public void setMenuItems() {
        addMenuBorder(true);

        Map<ItemStack, String> ores = HiveminezSeason2.getAllItemsManager().getOreItems();
        List<ItemStack> oresList = new ArrayList<>(ores.keySet());

        int oreIndex = 1;

        if (!ores.isEmpty()) {
            for (int i = 0; i < super.maxItemsPerPage; i++) {
                index = super.maxItemsPerPage * page + i;
                if (index + 1 >= ores.size()) break;

                if (oresList.get(index) != null) {
                    ItemStack ore = oresList.get(index);

                    ItemStack newOre = ore.clone();
                    if (!newOre.hasItemMeta()) continue;
                    String oreType = ores.get(newOre);

                    updateLore(newOre, oreType, oreIndex);

                    if (oreIndex == 6) {
                        oreIndex = 0;
                    }

                    inv.addItem(newOre);
                    oreIndex++;
                }
            }
        }
    }

    public void updateLore(ItemStack ore, String oreType, int oreIndex) {
        ItemMeta itemMeta = ore.getItemMeta();
        if (itemMeta == null) return;
        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        Player p = playerMenuUtility.getOwner();

        int cost = plugin.getConfig().getInt(String.format("ores.%s.%d", oreType, oreIndex));
        int total = 0;

        if (!lore.contains(Prefix.translateColorCodes("&aRequired To Upgrade: &6%d Pieces", cost))) {
            for (ItemStack item : p.getInventory().getStorageContents()) {
                if (item != null && Objects.requireNonNull(item.getItemMeta()).getDisplayName()
                        .equalsIgnoreCase(Objects.requireNonNull(itemMeta.getDisplayName()))) {
                    total += item.getAmount();
                }
            }
            int totalAmount = cost - total;

            totalAmount = Math.max(0, totalAmount);

            lore.set(1, " ");
            lore.add(Prefix.translateColorCodes("&aRequired To Upgrade: &6%d Pieces", cost));
            lore.add(" ");
            lore.add(Prefix.translateColorCodes("&cNeeds &6%d &cMore to Upgrade", totalAmount));
        }

        itemMeta.setLore(lore);
        ore.setItemMeta(itemMeta);
    }

    @Override
    public void backMenu() {
        // nothing
    }
}
