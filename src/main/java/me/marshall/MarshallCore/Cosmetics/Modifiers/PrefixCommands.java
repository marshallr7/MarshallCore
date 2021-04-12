package me.marshall.MarshallCore.Cosmetics.Modifiers;

import me.marshall.MarshallCore.MenuSystem.Items;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrefixCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String[] prefixItemLore = {"&7Click with this item and follow", "&7the instructions to modify your", "&7prefix"};

        if (sender.hasPermission("teldaria.modifiers.give")) {
            if (args.length != 2) {
                sender.sendMessage("§CCorrect command usage: §f/prefixitem give <player>");
            } else {
                Player target = Bukkit.getPlayer(args[1]);
                if (!target.isOnline()) {
                    sender.sendMessage("§cThat player is not online.");
                } else {
                    target.getInventory().addItem(Items.modifierItem("&2Prefix", prefixItemLore));
                    sender.sendMessage("§2You have successfully given a prefix modifier to " + target.getPlayerListName());
                }
            }
        } else {
            sender.sendMessage("§cYou do not have permission to use this command.");
        }


        return true;
    }
}
