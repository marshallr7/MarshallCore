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
        if (args.length == 3) {
            if (sender.hasPermission("teldaria.gems")) {
                if (args[0].equalsIgnoreCase("give")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (!target.isOnline()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe target user is not online."));
                    } else {
                        int amount = Integer.parseInt(args[2]);
                        gems.giveGems(target.getUniqueId(), amount);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fGems&7] &fYou have received &2" + amount + " &fGems"));
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (!target.isOnline()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe target user is not online."));
                    } else {
                        int amount = Integer.parseInt(args[2]);
                        gems.removeGems(target.getUniqueId(), amount);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fGems&7] &2" + amount + " &fGems have been removed from your account."));
                    }
                }
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYou currently have &2" + gems.getGemsHashMap(player.getUniqueId()) + " &fgems"));
            }
        }


        return true;
    }
}
