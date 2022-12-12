package me.fast.lemonzero.FadeCore.CommandSpy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SpyCommand implements CommandExecutor {

    public final static ArrayList<Player> spy_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player ) {
            Player p = (Player) sender;
            if (spy_list.contains(p.getPlayer())) {
                spy_list.remove(p.getPlayer());
                p.sendMessage(ChatColor.GRAY + "Command Spy Disabled!");
            }else{
                spy_list.add(p.getPlayer());
                p.sendMessage(ChatColor.GRAY + "Command Spy Enabled!");
            }

        }

        return true;
    }



}
