package me.fast.lemonzero.SLAPI.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SLAPICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6SLAPI &8- &fHello, &e") + ChatColor.YELLOW + p.getName() + ChatColor.translateAlternateColorCodes('&', "&f. I am &6SLAPI&f, a totally real robot designed to answer questions above the server! Use &a/slapi help&f!"));

                return true;

            }


            if (args[0].equalsIgnoreCase("help")) {

                p.sendMessage(" ");
                p.sendMessage(ChatColor.GOLD + "SLAPI Commands:");
                p.sendMessage(ChatColor.WHITE + "Coming Soon!");

                return true;

            }


        }




        return true;
    }


}
