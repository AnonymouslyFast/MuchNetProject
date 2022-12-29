package me.fast.lemonzero.utils.data;

import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.utils.MessageUtils;
import me.fast.lemonzero.utils.Rank;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class DataManager {

    private static HashMap<UUID, File> dataFiles = new HashMap<>();
    private static HashMap<UUID, Double> balances = new HashMap<>();
    private static HashMap<UUID, Rank> ranks = new HashMap<>();

    public static boolean hasFile(Player player) {
        return dataFiles.get(player.getUniqueId()).exists();
    }

    public static void loadData(Player player) {
        if (!dataFiles.containsKey(player)) {
            File dataFile = new File(LemonZero.getPlugin().getDataFolder() + "/player data", (player.getUniqueId() + ".yml"));
            if (dataFile.exists()) {
                YamlConfiguration file = YamlConfiguration.loadConfiguration(dataFile);
                balances.put(player.getUniqueId(), file.getDouble("balance"));
                ranks.put(player.getUniqueId(), Rank.valueOf(file.getString("rank").toUpperCase()));
            }
            dataFiles.put(player.getUniqueId(), dataFile);
        }
    }

    public static void saveData() {
        for (UUID uuid : dataFiles.keySet()) {
            File dataFile = dataFiles.get(uuid);
            if (!dataFile.exists())
                try {
                    dataFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    MessageUtils.log("&cAn error occurred while creating a player data file for " + Bukkit.getOfflinePlayer(uuid).getName() + ".");
                }
            YamlConfiguration file = YamlConfiguration.loadConfiguration(dataFile);
            if (balances.containsKey(uuid)) {
                file.set("balance", getBalance((Player) Bukkit.getOfflinePlayer(uuid)));
            }
            if (ranks.containsKey(uuid)) {
                file.set("rank", getGroup((Player) Bukkit.getOfflinePlayer(uuid)).name());
            }
            try {
                file.save(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
                MessageUtils.log("&cAn error occurred while saving player data for " + Bukkit.getOfflinePlayer(uuid).getName() + "!");
            }
        }
    }

    public static void setBalance(Player player, double balance) {
        if (balances.containsKey(player.getUniqueId()))
            balances.replace(player.getUniqueId(), balance);
        else
            balances.put(player.getUniqueId(), balance);
    }

    public static double getBalance(Player player) {
        if (balances.containsKey(player.getUniqueId()))
            return balances.get(player.getUniqueId());
        return 0;
    }

    public static void setGroup(Player player, Rank rank) {
        if (ranks.containsKey(player.getUniqueId()))
            ranks.replace(player.getUniqueId(), rank);
        else
            ranks.put(player.getUniqueId(), rank);
    }

    public static Rank getGroup(Player player) {
        for (PermissionAttachmentInfo info : player.getEffectivePermissions()) {
            if (info.getPermission().startsWith("group.")) {
                return Rank.valueOf(info.getPermission().split("group.")[1].replaceAll("-", "_").toUpperCase());
            }
        }
        return Rank.DEFAULT;
    }
}
