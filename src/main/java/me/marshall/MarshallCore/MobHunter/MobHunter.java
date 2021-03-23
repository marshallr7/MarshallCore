package me.marshall.MarshallCore.MobHunter;

import java.util.HashMap;
import java.util.UUID;

public class MobHunter {

    public static HashMap<UUID, Integer> attemptedContractPurchase = new HashMap<>();
    public static HashMap<UUID, String> attemptedContractBoss = new HashMap<>();

    public static HashMap<UUID, String> onGoingMobName = new HashMap<>();
    public static HashMap<UUID, Integer> onGoingMobCount = new HashMap<>();

    public static String getOnGoingMobContract(UUID playerUUID) {
        return onGoingMobName.get(playerUUID);
    }

    public static Integer getOnGoingMobCount(UUID playerUUID) {
        return onGoingMobCount.get(playerUUID);
    }

    public static void setOnGoingContract(UUID playerUUID, String mobName) {
        onGoingMobName.put(playerUUID, mobName);
        onGoingMobCount.put(playerUUID, 0);
    }

    public static void updateOnGoingContract(UUID playerUUID) {
        onGoingMobCount.put(playerUUID, onGoingMobCount.get(playerUUID) + 1);
    }

    public static void removeOnGoingContract(UUID playerUUID) {
        onGoingMobCount.remove(playerUUID);
        onGoingMobName.remove(playerUUID);
    }


    public static String getAttemptedContractBoss(UUID playerUUID) {
        return attemptedContractBoss.get(playerUUID);
    }

    public static void setAttemptedContractBoss(UUID playerUUID, String mobName) {
        if (attemptedContractBoss.containsKey(playerUUID)) {
            attemptedContractBoss.replace(playerUUID, mobName);
        } else {
            attemptedContractBoss.put(playerUUID, mobName);
        }
    }

    public static Integer getAttemptedContractPurchase(UUID playerUUID) {
        return attemptedContractPurchase.get(playerUUID);
    }

    public static void setAttemptedContractPurchase(UUID playerUUID, Integer amount) {
        if (attemptedContractPurchase.containsKey(playerUUID)) {
            attemptedContractPurchase.replace(playerUUID, amount);
        } else {
            attemptedContractPurchase.put(playerUUID, amount);
        }
    }


    public static void setAttempt(UUID playerUUID, int amount, String name) {
        setAttemptedContractBoss(playerUUID, name);
        setAttemptedContractPurchase(playerUUID, amount);
    }

    public static void removePlayer(UUID playerUUID) {
        attemptedContractPurchase.remove(playerUUID);
        attemptedContractBoss.remove(playerUUID);
    }


}
