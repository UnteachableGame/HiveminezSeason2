package me.unteachable.hiveminezSeason2.models.npc;

import net.minecraft.world.entity.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class EquipmentSlotData {

    private ItemStack item;
    private EquipmentSlot equipmentSlot;

    public EquipmentSlotData(EquipmentSlot equipmentSlot, ItemStack item) {
        this.item = item;
        this.equipmentSlot = equipmentSlot;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public void setEquipmentSlot(EquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
    }

}
