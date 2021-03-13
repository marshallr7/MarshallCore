package me.marshall.MarshallCore.MobHunter.Listeners;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.HashMap;
import java.util.UUID;

public class MobHunterListener implements Listener {

    HashMap<UUID, Integer> mobsKilled = new HashMap<>();











    @EventHandler
    public void villagerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.getRightClicked().getCustomName().contains(ChatColor.translateAlternateColorCodes('&', "&fMob Hunter"))) {
            return;
        }
        MobHunterMenu menu = new MobHunterMenu(Core.getPlayerMenuUtility(player));
        menu.open();


    }
}
