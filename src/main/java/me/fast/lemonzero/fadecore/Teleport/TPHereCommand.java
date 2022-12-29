package me.fast.lemonzero.fadecore.Teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPHereCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("lemoncore.teleport")) {

                if (args.length == 0) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou must specify a player to &6teleport &ato you!"));
                }else{

                    String playerName = args[0];

                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThat player is not online!"));
                    }else{
                        target.teleport(p);
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou were teleported to &6" + p.getName() + "&a!"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully teleported &6" + target.getName() + "&a to you!"));
                    }

                }

            }


        }


        return true;
    }


}
