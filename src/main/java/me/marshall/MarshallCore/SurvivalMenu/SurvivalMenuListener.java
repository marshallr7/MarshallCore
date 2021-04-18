package me.marshall.MarshallCore.SurvivalMenu;

import me.marshall.MarshallCore.Core;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class SurvivalMenuListener implements Listener {

    @EventHandler
    public void onSurvivalMenuClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemStack air = new ItemStack(Material.AIR);

        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        if (item.getType() == Material.AIR || !item.hasItemMeta() || !Objects.requireNonNull(item.getItemMeta()).hasDisplayName()) {
            return;
        }

        if (!(item.getItemMeta().getDisplayName().contains("Survival Menu"))) {
            return;
        }
        SurvivalMenu survivalMenu = new SurvivalMenu(Core.getPlayerMenuUtility(player));
        survivalMenu.open();


    }

//    @EventHandler
//    public void survivalItemOnConnect
}
