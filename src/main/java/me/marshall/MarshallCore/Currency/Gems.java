package me.marshall.MarshallCore.Currency;

import me.marshall.MarshallCore.Core;

import java.util.HashMap;
import java.util.UUID;

public class Gems {


    public static HashMap<UUID, Integer> playerBalances = new HashMap<>();

    public static HashMap<UUID, Integer> getBalances() {
        return playerBalances;
    }

    public void giveGems(UUID playerUUID, Integer amount) {
        Integer currentBal = playerBalances.get(playerUUID);
        Integer updatedBal = currentBal + amount;
        playerBalances.replace(playerUUID, updatedBal);
        Core plugin = Core.getInstance();
        plugin.updatePlayerFile(playerUUID, "Gems", Gems.playerBalances.get(playerUUID));
    }

    public void removeGems(UUID playerUUID, Integer amount) {
        Integer currentBal = playerBalances.get(playerUUID);
        Integer updatedBal = currentBal - amount;
        playerBalances.replace(playerUUID, updatedBal);
        Core plugin = Core.getInstance();
        plugin.updatePlayerFile(playerUUID, "Gems", Gems.playerBalances.get(playerUUID));
    }

    public int getGems(UUID playerUUID) {
        Core plugin = Core.getInstance();
        return plugin.getPlayerFile(playerUUID).getInt("Gems");
    }

    public int getGemsHashMap(UUID playerUUID) {
        return playerBalances.get(playerUUID);
    }
}
