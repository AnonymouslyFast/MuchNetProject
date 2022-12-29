package me.fast.lemonzero.fadecore.Commands.Gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;

            if (p.hasPermission("fadecore.gamemode")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GREEN + "Set your gamemode to " + ChatColor.GOLD + "Creative");
                Bukkit.broadcast(ChatColor.AQUA + p.getName() + ChatColor.translateAlternateColorCodes('&', "&a set their gamemode to &6Creative"), "fadecore.notify");
            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission!");
            }
        }

        return true;
    }



}
