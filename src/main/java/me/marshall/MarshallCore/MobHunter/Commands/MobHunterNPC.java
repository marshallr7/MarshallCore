package me.marshall.MarshallCore.MobHunter.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MobHunterNPC implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("mobhunter.npc.spawn")) {
                    Entity v = player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                    v.setCustomName(ChatColor.translateAlternateColorCodes('&', "&fMob Hunter"));
                    LivingEntity villager = (LivingEntity) v;
                    villager.setAI(false);
                    villager.setInvulnerable(true);
                }
            }
        return true;
    }
}
