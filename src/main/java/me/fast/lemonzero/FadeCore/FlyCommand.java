package me.fast.lemonzero.FadeCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lemoncore.fly")){
                if (!p.getAllowFlight()) {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "Set your fly mode to " + ChatColor.GOLD + "True");
                }else{
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.RED + "Set your fly mode to " + ChatColor.GOLD + "False");
                }
            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission!");
            }
        }

        return true;
    }


}
