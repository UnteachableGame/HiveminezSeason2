package me.unteachable.hiveminezSeason2.features.menus;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.base.menu.PaginatedMenu;
import me.unteachable.hiveminezSeason2.base.menu.PlayerMenuUtility;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GetAllItemsMenu extends PaginatedMenu {

    public GetAllItemsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "All Items";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;

        // This lets the right and left buttons work normally without the get all items special function.
        if (!e.getCurrentItem().getType().equals(Material.DARK_OAK_BUTTON) &&
                !e.getCurrentItem().getType().equals(Material.BARRIER) &&
                !e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {

            p.getInventory().addItem(e.getCurrentItem());
            p.sendMessage(new Prefix().translateColorCodes("&6You have added &f%s &6to your inventory!", ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())));
        } else {
            menuFunction(e, true);
        }
    }

    @Override
    public void setMenuItems() {
        addHalfMenuBorder(true);
        List<ItemStack> items = createAllItemsList();

        // This checks if the list is empty so there won't be any misplacement.
        if (!items.isEmpty()) {
            // Loops through the amount of pages that are in the paginated menu.
            for (int i = 0; i < super.maxItemsPerPage; i++) {
                // This gets the page index using the max page number and the page.
                index = super.maxItemsPerPage * page + i;
                if (index >= items.size()) break;

                ItemStack item = items.get(index);
                if (item != null) {
                    inv.addItem(item);
                }
            }
        }
    }

    @Override
    public void backMenu() {
        // nothing
    }

    public List<ItemStack> createAllItemsList() {
        List<ItemStack> allItems = new ArrayList<>();
        allItems.addAll(new ArrayList<>(HiveminezSeason2.getAllItemsManager().getOreItems().keySet()));
        allItems.addAll(new ArrayList<>(HiveminezSeason2.getAllItemsManager().getToolItems().keySet()));
        allItems.addAll(new ArrayList<>(HiveminezSeason2.getAllItemsManager().getWeaponItems().keySet()));

        return allItems;
    }
}
