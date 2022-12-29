package me.fast.lemonzero.lemonextras.Homes;

import me.fast.lemonzero.LemonZero;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Se6HomeCommand implements CommandExecutor {

    final static LemonZero plugin = LemonZero.getPlugin();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;
            UUID id = p.getUniqueId();
            Location location = p.getLocation();

            if (plugin.getHome(id) == null) {
                plugin.getFiles().addHome(id, location);
                p.sendMessage(ChatColor.GREEN + "Home set to your location!");
                plugin.addHome(id, location);
            }else {
                if (plugin.hasHome(id)) {
                    p.sendMessage(ChatColor.RED + "You already have a home! Use /delhome.");
                } else {
                    plugin.getFiles().addHome(id, location);
                    p.sendMessage(ChatColor.GREEN + "Home set to your location!");
                    plugin.addHome(id, location);
                }
            }
        }


        return true;
    }

}
