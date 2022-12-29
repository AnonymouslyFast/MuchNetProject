package me.fast.lemonzero.fadecore.Commands.Gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpectatorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("lemoncore.gamemode")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.GREEN + "Set your gamemode to " + ChatColor.GOLD + "Spectator");
                Bukkit.broadcast(ChatColor.AQUA + p.getName() + ChatColor.translateAlternateColorCodes('&', "&a set their gamemode to &6Spectator"), "fadecore.notify");
            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission!");
            }
        }

        return true;
    }



}
