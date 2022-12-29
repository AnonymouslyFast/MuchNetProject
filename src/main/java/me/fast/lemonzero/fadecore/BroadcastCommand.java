package me.fast.lemonzero.fadecore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BroadcastCommand implements CommandExecutor {

    public static String arrayToString(String[] array) {
        return Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lemoncore.broadcast")) {

                if (args.length != 0) {
                    Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lLemon&6&lZero &8- " + "&f" + arrayToString(args) ));
                    Bukkit.broadcastMessage(" ");
                }else{
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou must enter a message!"));
                }

            }else{
                p.sendMessage(ChatColor.RED + "No permission!");
            }

        }

        return true;
    }


}
