package me.fast.lemonzero.SLAPI.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.fast.lemonzero.LemonZero.getPlugin;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            Location location = getPlugin().getConfig().getLocation("spawn");

            if (location != null) {
                p.teleport(location);
                p.sendMessage(ChatColor.GREEN + "Teleported to spawn!");


            } else {
                p.sendMessage(ChatColor.RED + "No spawn set!");
            }
        }

        return true;
    }


}
