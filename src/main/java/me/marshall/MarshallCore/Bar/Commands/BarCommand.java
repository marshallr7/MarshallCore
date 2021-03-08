package me.marshall.MarshallCore.Bar.Commands;

import me.marshall.MarshallCore.Bar.Menus.BarMenu;
import me.marshall.MarshallCore.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


//CMD:   Bar give player drink amount
//ARGS: null  0     1      2     3
//LEN:   0    1     2      3     4

public class BarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("bar.use")) {
                Player player = (Player) sender;

                BarMenu barMenu = new BarMenu(Core.getPlayerMenuUtility(player));
                barMenu.open();
            }
        }

        return true;
    }
}
