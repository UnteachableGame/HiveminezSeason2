package me.unteachable.hiveminezSeason2.commands;

import me.unteachable.hiveminezSeason2.items.ToolItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveStarterPickaxe implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (command.getName().equalsIgnoreCase("starterpickaxe")) {
                p.getInventory().addItem(new ToolItems().getT1SplinterPickaxe());
            }
        }
        return true;
    }
}
