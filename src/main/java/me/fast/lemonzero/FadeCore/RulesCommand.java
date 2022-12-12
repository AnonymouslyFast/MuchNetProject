package me.fast.lemonzero.FadeCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lLemon&6&lZero &f&lRules"));
            p.sendMessage(" ");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&71) &fNo cheating, hacking or exploiting."));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&72) &fNo inappropriate builds or item names."));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&73) &fNo TP trapping or killing people when they tp to you."));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&74) &fNo scamming."));
            p.sendMessage(" ");
        }

        return true;
    }

}
