package me.fast.lemonzero.fadecore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Collection;
import java.util.Objects;

import static me.fast.lemonzero.minecraft.utils.LuckPerms.possibleGroups;

public class ChatEvent implements Listener {

    public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
        for (String group : possibleGroups) {
            if (player.hasPermission("group." + group)) {
                return group;
            }
        }
        return null;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();

        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("owner")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&c&k|&4Owner&c&k| ") + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage());

        }
        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("co-owner")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&c&k|&4Co-Owner&c&k| ") + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage());

        }
        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("admin")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&c&lAdmin ") + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage());

        }
        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("moderator")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&2&lModerator ") + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage());

        }
        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("helper")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&9&lHelper ") + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage());

        }
        if (Objects.requireNonNull(getPlayerGroup(p, possibleGroups)).equalsIgnoreCase("lemongod")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&e&k|") + net.md_5.bungee.api.ChatColor.of("#edd34e") + "Lemon God" + ChatColor.translateAlternateColorCodes('&', "&e&k| " + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + e.getMessage()));
        }
    }

}
