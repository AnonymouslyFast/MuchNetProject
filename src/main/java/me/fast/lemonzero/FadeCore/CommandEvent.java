package me.fast.lemonzero.FadeCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {

        String p = e.getPlayer().getName();

        Bukkit.broadcast((ChatColor.translateAlternateColorCodes('&', "&6Command Spy &8- &f") + p + ChatColor.translateAlternateColorCodes('&', " &7(&b") + e.getMessage() + ChatColor.GRAY + ")"), "commandspy");



    }


}
