package me.marshall.MarshallCore.Store;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.Store.Menus.StoreMainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StoreCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            StoreMainMenu storeMenu = new StoreMainMenu(Core.getPlayerMenuUtility(player));
            storeMenu.open();
        }
        return true;
    }
}
