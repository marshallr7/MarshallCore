package me.marshall.MarshallCore.Currency;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// CMD gems give <player> <amount>
// ARGS null  0    1        2
// LEN   0    1    2        3

// CMD gems remove <player> <amount>
// ARGS null  0    1        2
// LEN   0    1    2        3


public class GemsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Gems gems = new Gems();
        if (args[0].equalsIgnoreCase("give")) {
            if (sender.hasPermission("teldaria.gems.give")) {
                if (args.length != 3) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect command usage: /gems give <player> <amount>"));
                } else {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (!target.isOnline()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe target user is not online."));
                    } else {
                        int amount = Integer.parseInt(args[2]);
                        gems.giveGems(target.getUniqueId(), amount);
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission teldaria.gems.give"));
            }
        } else if (args[0].equalsIgnoreCase("remove")) {
            if (sender.hasPermission("teldaria.gems.remove")) {
                if (args.length != 3) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect command usage: /gems remove <player> <amount>"));
                } else {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (!target.isOnline()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe target user is not online."));
                    } else {
                        int amount = Integer.parseInt(args[2]);
                        gems.removeGems(target.getUniqueId(), amount);
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission teldaria.gems.remove"));
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYou currently have &2" + gems.getGems(player.getUniqueId()) + " &fgems"));
            }
        }


        return true;
    }
}
