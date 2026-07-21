package me.unteachable.hiveminezSeason2.utils.items;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class WeaponItems {

    public void setWeaponItemsInList() {
        Map<ItemStack, String> weaponItemsList = HiveminezSeason2.getAllItemsManager().getWeaponItems();

    }

}
