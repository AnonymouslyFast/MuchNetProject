package me.fast.lemonzero.FadeCore.Teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lemoncore.teleport")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou must specify who you want to &6teleport &ato!"));
                }else if (args.length == 1){

                    String playerName = args[0];

                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if(target == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThat player is not online!"));
                    }else{
                        p.teleport(target);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully teleported to &6" + target.getName() + "&a!"));
                    }
                }else if (args.length == 2){

                    String playerOne = args[0];
                    String playerTwo = args[1];

                    Player target = Bukkit.getServer().getPlayerExact(playerTwo);
                    Player commandSender = Bukkit.getServer().getPlayerExact(playerOne);

                    if (target == null) {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThat player is not online!"));
                    }else{
                        commandSender.teleport(target);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully teleported &6" + commandSender.getName() + "&a to &6" + target.getName() + "&a!"));
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou were teleported to &6" + target.getName() + "&a!"));
                    }
                }


            }
        }



        return true;
    }

}
