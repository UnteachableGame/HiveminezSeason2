package me.unteachable.hiveminezSeason2.commands;

import me.unteachable.hiveminezSeason2.features.menus.GetAllItemsMenu;
import me.unteachable.hiveminezSeason2.base.menu.PlayerMenuUtility;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UtilCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (command.getName().equalsIgnoreCase("feed")) {
                p.setHealth(20.0);
                p.setFoodLevel(20);
                p.setSaturation(20.0F);
                p.sendMessage(Prefix.setHiveMinezFormat("You are all set again!"));

            } else if (command.getName().equalsIgnoreCase("seeallitems")) {
                new GetAllItemsMenu(new PlayerMenuUtility(p)).open();
            }
        }
        return true;
    }
}
