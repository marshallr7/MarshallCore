package me.marshall.MarshallCore.MobHunter.Listeners;


import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.Menus.CancelMenu;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class MobHunterListener implements Listener {



//    public void onMobHunterKill(MythicMobDeathEvent event) {
//        if (!(event.getKiller() instanceof Player)) {
//            return;
//        }
//        Player player = (Player) event.getKiller();
//        UUID playerUUID = player.getUniqueId();
//        if (!(MobHunter.onGoingMobName.containsKey(playerUUID))) {
//            return;
//        }
//        MythicMob mob = event.getMobType();
//        //
//    }







    @EventHandler
    public void villagerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.getRightClicked().getCustomName().contains(ChatColor.translateAlternateColorCodes('&', "&fMob Hunter"))) {
            return;
        }
        if (MobHunter.onGoingMobCount.containsKey(player.getUniqueId())) {
            CancelMenu cancelMenu = new CancelMenu(Core.getPlayerMenuUtility(player));
            cancelMenu.open();
        } else {
            MobHunterMenu mainMenu = new MobHunterMenu(Core.getPlayerMenuUtility(player));
            mainMenu.open();
        }

    }
}
