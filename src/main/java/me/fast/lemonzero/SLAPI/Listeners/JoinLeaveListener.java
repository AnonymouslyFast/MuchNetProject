package me.fast.lemonzero.SLAPI.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if (p.hasPlayedBefore()) {

            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&f[&a+&f] &b" + p.getName()));

        }else{

            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&f[&2+&f] &b" + p.getName()));

        }

    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player p = e.getPlayer();

        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&f[&c-&f] &b" + p.getName()));



    }

}
