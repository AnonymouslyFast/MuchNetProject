package me.fast.lemonzero.listeners.minecraft;

import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.utils.DiscordUtils;
import me.fast.lemonzero.utils.data.DataManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        if (message.contains("@everyone") || message.contains("@here")) {
            event.setCancelled(true);
            return;
        }
        Player player = event.getPlayer();
        if (DiscordUtils.isEnabled())
            LemonZero.mcChat.sendMessage(ChatColor.stripColor("**" + DataManager.getGroup(player).getDisplay() + " " + player.getDisplayName()) + " »** " + message).queue();
    }
}
