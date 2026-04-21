package me.unteachable.hiveminezSeason2.menus;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Menu;
import me.unteachable.hiveminezSeason2.utils.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class GetAllItemsMenu extends Menu {

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
        if (e.getCurrentItem() == null) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        p.getInventory().addItem(e.getCurrentItem());
    }

    @Override
    public void setMenuItems() {
        for (ItemStack item : new ArrayList<>(HiveminezSeason2.getAllItemsManager().getOreItems().keySet())) {
            inv.addItem(item);
        }
        for (ItemStack item : new ArrayList<>(HiveminezSeason2.getAllItemsManager().getToolItems().keySet())) {
            inv.addItem(item);
        }
        for (ItemStack item : new ArrayList<>(HiveminezSeason2.getAllItemsManager().getWeaponItems().keySet())) {
            inv.addItem(item);
        }
    }
}
