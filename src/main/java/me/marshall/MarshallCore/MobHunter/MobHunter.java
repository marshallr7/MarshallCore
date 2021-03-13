package me.marshall.MarshallCore.MobHunter;

import java.util.HashMap;
import java.util.UUID;

public class MobHunter {

    public HashMap<UUID, Double> attemptedContractPurchase = new HashMap<>();
    public HashMap<UUID, String> attemptedContractBoss = new HashMap<>();

    public String getAttemptedContractBoss(UUID playerUUID) {
        return attemptedContractBoss.get(playerUUID);
    }

    public void setAttemptedContractBoss(UUID playerUUID, String mobName) {
        if (attemptedContractBoss.containsKey(playerUUID)) {
            attemptedContractBoss.replace(playerUUID, mobName);
        } else {
            attemptedContractBoss.put(playerUUID, mobName);
        }
    }

    public Double getAttemptedContractPurchase(UUID playerUUID) {
        return attemptedContractPurchase.get(playerUUID);
    }

    public void setAttemptedContractPurchase(UUID playerUUID, Double amount) {
        if (attemptedContractPurchase.containsKey(playerUUID)) {
            attemptedContractPurchase.replace(playerUUID, amount);
        } else {
            attemptedContractPurchase.put(playerUUID, amount);
        }
    }


}
