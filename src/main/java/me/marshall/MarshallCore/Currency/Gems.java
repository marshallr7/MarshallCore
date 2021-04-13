package me.marshall.MarshallCore.Currency;

import me.marshall.MarshallCore.Core;

import java.util.HashMap;
import java.util.UUID;

public class Gems {


    HashMap<UUID, Integer> playerBalances = new HashMap<>();

    public void giveGems(UUID playerUUID, Integer amount) {
        Integer currentBal = playerBalances.get(playerUUID);
        Integer updatedBal = currentBal + amount;
        playerBalances.replace(playerUUID, updatedBal);
    }

    public void removeGems(UUID playerUUID, Integer amount) {
        Integer currentBal = playerBalances.get(playerUUID);
        Integer updatedBal = currentBal - amount;
        playerBalances.replace(playerUUID, updatedBal);
    }

    public void getGems(UUID playerUUID) {
        Core plugin = Core.getInstance();
        int gems = plugin.getPlayerFile(playerUUID).getInt("gems");
    }
}
