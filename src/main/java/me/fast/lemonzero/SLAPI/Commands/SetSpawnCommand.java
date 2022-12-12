package me.fast.lemonzero.SLAPI.Commands;

import me.fast.lemonzero.LemonZero;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            Location location = p.getLocation();

            LemonZero.getPlugin().getConfig().set("spawn", location);
            LemonZero.getPlugin().saveConfig();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSpawn Location Set!"));



        }

        return true;
    }


}
