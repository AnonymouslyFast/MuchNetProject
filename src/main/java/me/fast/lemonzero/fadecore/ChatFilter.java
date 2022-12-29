package me.fast.lemonzero.fadecore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFilter implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (e.getMessage().contains("fuck") || e.getMessage().contains("nigger") || e.getMessage().contains("nig") || e.getMessage().contains("bitch") || e.getMessage().contains("sex") || e.getMessage().contains("dick") || e.getMessage().contains("pussy") || e.getMessage().contains("penis") || e.getMessage().contains("cum") || e.getMessage().contains("vagina") || e.getMessage().contains("shit") || e.getMessage().contains("ass")){
            e.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lFILTER &8&l- &fYour message was blocked from our chat, please do not swear. You can see our rules by doing &d/rules"));
        }

    }
}