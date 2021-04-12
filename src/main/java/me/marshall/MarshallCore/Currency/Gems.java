package me.marshall.MarshallCore.Currency;

import java.util.HashMap;
import java.util.UUID;

public class Gems {

    HashMap<UUID, Integer> playerBalances = new HashMap<>();

    public void giveGems(UUID playerUUID, Integer amount) {
        Integer currentBal = playerBalances.get(playerUUID);
        Integer updatedBal = currentBal + amount;
        playerBalances.replace(playerUUID, updatedBal);
    }

}
