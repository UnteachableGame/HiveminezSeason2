package me.unteachable.hiveminezSeason2.utils;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;

    // 28 empty slots per page
    protected int maxItemsPerPage = 28;

    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuBorder() {
        ItemStack left = new Item(Material.DARK_OAK_BUTTON).displayName("&aLeft").createItem();
        inv.setItem(48, left);

        ItemStack right = new Item(Material.DARK_OAK_BUTTON).displayName("&aRight").createItem();
        inv.setItem(50, right);

        ItemStack back = new Item(Material.BARRIER).displayName("&4Back").createItem();
        inv.setItem(49, back);

        for (int i = 0; i < 10; i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, super.FILLER_GLASS);
            }
        }

        inv.setItem(17, super.FILLER_GLASS);
        inv.setItem(18, super.FILLER_GLASS);
        inv.setItem(26, super.FILLER_GLASS);
        inv.setItem(27, super.FILLER_GLASS);
        inv.setItem(17, super.FILLER_GLASS);
        inv.setItem(35, super.FILLER_GLASS);
        inv.setItem(36, super.FILLER_GLASS);

        for (int i = 44; i < 54; i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, super.FILLER_GLASS);
            }
        }
    }

    public void menuFunction(InventoryClickEvent e) {
        if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.DARK_OAK_BUTTON) {
            if (ChatColor.stripColor(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName()).equalsIgnoreCase("Left")) {
                if (page == 0) {
                    e.getWhoClicked().sendMessage(HiveminezSeason2.getPrefix().translateColorCodes("&7You are already on the first page."));
                } else {
                    page--;
                    super.open();
                }
            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Right")) {
                if (!((index + 1) >= HiveminezSeason2.getAllItemsManager().getOreItems().size())) {
                    page++;
                    super.open();
                } else {
                    e.getWhoClicked().sendMessage(HiveminezSeason2.getPrefix().translateColorCodes("&7You are on the last page."));
                }
            }
        }
    }
}
