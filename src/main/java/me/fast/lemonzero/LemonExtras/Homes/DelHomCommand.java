package me.fast.lemonzero.LemonExtras.Homes;

import me.fast.lemonzero.LemonZero;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class DelHomCommand implements CommandExecutor {

    private static LemonZero plugin = LemonZero.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            UUID id = p.getUniqueId();
            if (!plugin.hasHome(id)) {
                p.sendMessage(ChatColor.RED + "You do not have a home set!");
            }else{

                if (plugin.getHome(id) == null) {
                    p.sendMessage(ChatColor.RED + "You do not have a home!");
                }else {
                    new BukkitRunnable() {
                        int delay = 5;
                        @Override
                        public void run() {
                            if (delay == 0) {
                                p.teleport(plugin.getHome(id));
                                p.sendMessage(ChatColor.GOLD + "Teleporting...");
                                this.cancel();
                            }else{
                                p.sendMessage(ChatColor.GOLD + "Teleporting in " + delay-- + " seconds.");

                            }
                        }
                    }.runTaskTimer(plugin, 0, 20);
                }
            }

        }

        return true;
    }


}
