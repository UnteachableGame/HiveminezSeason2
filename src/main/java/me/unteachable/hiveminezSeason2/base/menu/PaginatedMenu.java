package me.unteachable.hiveminezSeason2.base.menu;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.models.Item;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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

    public abstract void backMenu();

    public void addMenuBorder(boolean isCloseButton) {
        ItemStack left = new Item(Material.DARK_OAK_BUTTON).displayName("&aLeft").createItem();
        inv.setItem(48, left);

        ItemStack right = new Item(Material.DARK_OAK_BUTTON).displayName("&aRight").createItem();
        inv.setItem(50, right);

        ItemStack back;
        if (isCloseButton) {
            back = new Item(Material.BARRIER).displayName("&4Close").createItem();
        } else {
            back = new Item(Material.BARRIER).displayName("&4Back").createItem();
        }
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

    public void addHalfMenuBorder(boolean isCloseButton) {
        maxItemsPerPage = 45;

        ItemStack left = new Item(Material.DARK_OAK_BUTTON).displayName("&aLeft").createItem();
        inv.setItem(48, left);

        ItemStack right = new Item(Material.DARK_OAK_BUTTON).displayName("&aRight").createItem();
        inv.setItem(50, right);

        ItemStack back;
        if (isCloseButton) {
            back = new Item(Material.BARRIER).displayName("&4Close").createItem();
        } else {
            back = new Item(Material.BARRIER).displayName("&4Back").createItem();
        }
        inv.setItem(49, back);

        for (int i = 45; i < 54; i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, super.FILLER_GLASS);
            }
        }
    }

    public void menuFunction(InventoryClickEvent e, boolean isCloseButton) {
        Player p = (Player) e.getWhoClicked();

        if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.DARK_OAK_BUTTON) {
            if (ChatColor.stripColor(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName()).equalsIgnoreCase("Left")) {
                if (page == 0) {
                    p.sendMessage(Prefix.translateColorCodes("&7You are already on the first page."));
                } else {
                    page--;
                    super.open();
                }
            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Right")) {
                int itemListSize = HiveminezSeason2.getAllItemsManager().getOreItems().size();

                // this checks if the next position in the list has an item.
//                p.sendMessage("(" + index + " + 1) " + (index + 1) + " > " + itemListSize + ":: " + ((index + 1) > itemListSize));
                if ((index + 1) < itemListSize) {
                    page++;
                    super.open();
                } else {
                    p.sendMessage(Prefix.translateColorCodes("&7You are on the last page."));
                }
            }
        } else if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.BARRIER)) {
            if (isCloseButton) {
                p.closeInventory();
            } else {
                backMenu();
            }
        }
    }
}
