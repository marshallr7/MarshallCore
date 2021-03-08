package me.marshall.MarshallCore.MenuSystem.Commands;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Menus.ExampleMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            ExampleMenu exampleMenu = new ExampleMenu(Core.getPlayerMenuUtility(player));
            exampleMenu.open();

        }











        return true;
    }
}
