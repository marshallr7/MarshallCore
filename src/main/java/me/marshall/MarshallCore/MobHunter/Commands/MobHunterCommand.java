package me.marshall.MarshallCore.MobHunter.Commands;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.Menus.CancelMenu;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MobHunterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("mobhunter.use")) {
                Player player = (Player) sender;

                if (MobHunter.onGoingMobCount.containsKey(player.getUniqueId())) {
                    CancelMenu cancelMenu = new CancelMenu(Core.getPlayerMenuUtility(player));
                    cancelMenu.open();
                } else {
                    MobHunterMenu mainMenu = new MobHunterMenu(Core.getPlayerMenuUtility(player));
                    mainMenu.open();
                }
            }
        }

        return true;
    }
}
