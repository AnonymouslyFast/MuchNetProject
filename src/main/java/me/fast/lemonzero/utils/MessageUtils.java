package me.fast.lemonzero.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtils {

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(translate(message));
    }

    public static void send(CommandSender sender, String... messages) {
        for (String message : messages)
            sender.sendMessage(translate(message));
    }

    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
