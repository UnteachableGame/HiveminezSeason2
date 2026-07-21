package me.unteachable.hiveminezSeason2.features.menus.shopmenus;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.base.menu.PaginatedMenu;
import me.unteachable.hiveminezSeason2.base.menu.PlayerMenuUtility;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import me.unteachable.hiveminezSeason2.models.Shop;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class WeaponsShopMenu  extends PaginatedMenu {

    Plugin plugin = HiveminezSeason2.getPlugin();

    public WeaponsShopMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public void backMenu() {
        HiveminezSeason2.getPlugin().getServer().getScheduler().runTask(HiveminezSeason2.getPlugin(), () -> new ShopMenu(HiveminezSeason2.getPlayerMenuUtility(playerMenuUtility.getOwner())).open());
    }

    @Override
    public String getMenuName() {
        return "✪ Weapons ✪";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = playerMenuUtility.getOwner();

        if (e.getClick().isRightClick()) {
            Map<ItemStack, String> toolsMap = HiveminezSeason2.getAllItemsManager().getToolItems();
            Map<ItemStack, String> oresMap = HiveminezSeason2.getAllItemsManager().getOreItems();
            List<ItemStack> toolsList = new ArrayList<>(toolsMap.keySet());
            List<ItemStack> oresList = new ArrayList<>(HiveminezSeason2.getAllItemsManager().getOreItems().keySet());

            if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) return;

            ItemStack currentItem = null;
            String toolType;

            if (e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(plugin, "tool-id"))) {
                currentItem = e.getCurrentItem();
                toolType = currentItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "tool-id"), PersistentDataType.STRING);
            } else {
                toolType = null;
            }

            List<ItemStack> filteredOres = oresList.stream()
                    .filter(item -> oresMap.get(item).equalsIgnoreCase(toolType))
                    .toList();

            Shop shop = null;
            for (int i = 0; i < toolsList.size(); i++) {
                if (toolType != null && currentItem.hasItemMeta()) {
                    if (i + 1 < filteredOres.size()) {

                        String toolTypeInList = toolsList.get(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "tool-id"), PersistentDataType.STRING);
                        if (toolTypeInList == null) continue;

                        if (toolTypeInList.equalsIgnoreCase(toolType) && ChatColor.stripColor(toolsList.get(i).getItemMeta().getDisplayName()).equalsIgnoreCase(ChatColor.stripColor(currentItem.getItemMeta().getDisplayName()))) {
                            int requiredOreCost = plugin.getConfig().getInt(String.format("shop.tools.%s.%d", toolType, i + 1));

                            Map<ItemStack, Integer> reqs = new HashMap<>();
                            if (i > 0) {
                                reqs.put(toolsList.get(i - 1), 1);
                                reqs.put(filteredOres.get(i - 1), requiredOreCost);
                            }

                            Map<ItemStack, Integer> rewards = new HashMap<>();
                            rewards.put(toolsList.get(i), 1);

                            shop = new Shop(reqs, rewards);
                            break;
                        }
                    }
                }
            }

            // make it so there are not so many if statements but can check each item individually using a switch statement on the e.getCurrentItem()
            if (shop == null) return;
            if (shop.purchase(p)) {
                p.sendMessage(Prefix.translateColorCodes("&aYou have successfully purchased an item from the shop!"));
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            } else {
                p.sendMessage(Prefix.translateColorCodes("&cYou don't have the required items to complete this purchase."));
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 1);
            }

            menuFunction(e, false);
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder(false);

        Map<ItemStack, String> tools = HiveminezSeason2.getAllItemsManager().getToolItems();
        Map<ItemStack, String> ores = HiveminezSeason2.getAllItemsManager().getOreItems();
        List<ItemStack> toolsList = new ArrayList<>(tools.keySet());
        List<ItemStack> oresList = new ArrayList<>(ores.keySet());

        int toolIndex = 1;

        if (!toolsList.isEmpty()) {
            for (int i = 0; i < super.maxItemsPerPage; i++) {
                index = super.maxItemsPerPage * page + i;
                if (index + 1 >= tools.size()) break;

                if (toolsList.get(index) != null) {
                    ItemStack tool = toolsList.get(index + 1);

                    ItemStack newTool = tool.clone();
                    if (!newTool.hasItemMeta()) continue;
                    String toolType = newTool.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "tool-id"), PersistentDataType.STRING);

                    updateLore(newTool, toolType, oresList, toolIndex, toolsList);

                    if (toolIndex == 8) {
                        toolIndex = 0;
                    }

                    inv.addItem(newTool);
                    toolIndex++;
                }
            }
        }
    }

    private void updateLore(ItemStack tool, String toolType, List<ItemStack> ores, int toolIndex, List<ItemStack> tools) {
        ItemMeta toolMeta = tool.getItemMeta();
        if (toolMeta == null) return;
        List<String> lore = toolMeta.getLore();
        if (lore == null) return;

        try {
            if (!lore.contains(Prefix.translateColorCodes("&7&nRequired Cost:"))) {
                lore.set(1, " ");
                lore.add(Prefix.translateColorCodes("&7Required Cost:"));
                lore.add(Prefix.translateColorCodes("&f- &a%s &fx1", Objects.requireNonNull(tools.get(index).getItemMeta()).getDisplayName()));
                lore.add(Prefix.translateColorCodes("&f- &6%s &fx2", Objects.requireNonNull(ores.get(index).getItemMeta()).getDisplayName(),
                        plugin.getConfig().getInt(String.format("shop.tools.%s.%d", toolType, toolIndex))));
                lore.add(" ");
                lore.add(Prefix.translateColorCodes("&eReward:"));
                lore.add(Prefix.translateColorCodes("&f- &a%s &fx1", Objects.requireNonNull(tools.get(index + 1).getItemMeta()).getDisplayName()));
                lore.add(" ");
                lore.add(Prefix.translateColorCodes("&a↑ Right Click to Purchase ↑"));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ran out");
        }

        toolMeta.setLore(lore);
        tool.setItemMeta(toolMeta);
    }
}
