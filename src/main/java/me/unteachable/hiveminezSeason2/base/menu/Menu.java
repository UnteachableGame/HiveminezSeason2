package me.unteachable.hiveminezSeason2.base.menu;

import me.unteachable.hiveminezSeason2.models.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class Menu implements InventoryHolder {

    protected Inventory inv;

    protected PlayerMenuUtility playerMenuUtility;

    protected ItemStack FILLER_GLASS = new Item(Material.GRAY_STAINED_GLASS_PANE).displayName(" ").createItem();

    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void handleMenu(InventoryClickEvent e);

    public abstract void setMenuItems();

    public void open() {
        inv = Bukkit.createInventory(this, getSlots(), getMenuName());

        this.setMenuItems();

        playerMenuUtility.getOwner().openInventory(inv);
    }

    //Overridden method from the InventoryHolder interface
    @Override
    public Inventory getInventory() {
        return inv;
    }

    public void addFillerGlass() {
        for (int i = 0; i < getSlots(); i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, FILLER_GLASS);
            }
        }
    }
}
