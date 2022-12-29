package me.fast.lemonzero.lemonextras;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AfkCommand implements CommandExecutor {

    public final static ArrayList<Player> afk_list = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player ) {
            Player p = (Player) sender;

            if (afk_list.contains(p.getPlayer())) {

                afk_list.remove(p.getPlayer());
                p.sendMessage(ChatColor.GRAY + "You are no longer AFK!");
                Bukkit.broadcast(ChatColor.GOLD + "STAFF!" + ChatColor.GRAY + " " + p.getDisplayName() + " is no longer afk!", "staff");

            }else {

                afk_list.add(p.getPlayer());
                p.sendMessage(ChatColor.GRAY + "You are now AFK!");
                Bukkit.broadcast(ChatColor.GOLD + "STAFF!" + ChatColor.GRAY + " " + p.getDisplayName() + " is now afk!", "staff");

            }

        }

        return true;
    }


}
