package me.unteachable.hiveminezSeason2.features.menus.shopmenus;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.models.Item;
import me.unteachable.hiveminezSeason2.base.menu.Menu;
import me.unteachable.hiveminezSeason2.base.menu.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ShopMenu extends Menu {

    public ShopMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "✪ Shop ✪";
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        switch (e.getCurrentItem().getType()) {
            case NETHERITE_PICKAXE -> HiveminezSeason2.getPlugin().getServer().getScheduler().runTask(HiveminezSeason2.getPlugin(), () -> new ToolsShopMenu(HiveminezSeason2.getPlayerMenuUtility(p)).open());
            case GOLDEN_PICKAXE -> HiveminezSeason2.getPlugin().getServer().getScheduler().runTask(HiveminezSeason2.getPlugin(), () -> new WeaponsShopMenu(HiveminezSeason2.getPlayerMenuUtility(p)).open());
            case DIAMOND_HELMET -> HiveminezSeason2.getPlugin().getServer().getScheduler().runTask(HiveminezSeason2.getPlugin(), () -> new ArmorShopMenu(HiveminezSeason2.getPlayerMenuUtility(p)).open());
            case FISHING_ROD -> HiveminezSeason2.getPlugin().getServer().getScheduler().runTask(HiveminezSeason2.getPlugin(), () -> new OthersShopMenu(HiveminezSeason2.getPlayerMenuUtility(p)).open());
            case BARRIER -> p.closeInventory();
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack tools = new Item(Material.NETHERITE_PICKAXE).displayName("&bTools").lore(" ", "&a↑ Click to Buy Tools ↑").glowing().createItem();
        inv.setItem(10, tools);

        ItemStack weapons = new Item(Material.GOLDEN_SWORD).displayName("&cWeapons").lore(" ", "&a↑ Click to Buy Weapons ↑").glowing().createItem();
        inv.setItem(12, weapons);

        ItemStack armor = new Item(Material.DIAMOND_HELMET).displayName("&6Armor").lore(" ", "&a↑ Click to Buy Armor ↑").glowing().createItem();
        inv.setItem(14, armor);

        ItemStack others = new Item(Material.FISHING_ROD).displayName("&9Others").lore(" ", "&a↑ Click to Buy Others ↑").glowing().createItem();
        inv.setItem(16, others);

        ItemStack close = new Item(Material.BARRIER).displayName("&4Close").createItem();
        inv.setItem(31, close);

        addFillerGlass();
    }
}
