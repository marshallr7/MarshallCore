package me.marshall.MarshallCore.Bar.Commands;

import me.marshall.MarshallCore.Bar.Menus.BarMenu;
import me.marshall.MarshallCore.Bar.Menus.GambleMenu;
import me.marshall.MarshallCore.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GambleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("gamble.use")) {
                Player player = (Player) sender;

                GambleMenu gambleMenu = new GambleMenu(Core.getPlayerMenuUtility(player));
                gambleMenu.open();
            }
        }

        return true;
    }
}
