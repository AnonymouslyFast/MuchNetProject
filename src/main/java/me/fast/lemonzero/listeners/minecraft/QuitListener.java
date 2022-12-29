package me.fast.lemonzero.listeners.minecraft;

import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.utils.DiscordUtils;
import me.fast.lemonzero.utils.data.DataManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (DiscordUtils.isEnabled()) {
            EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.red).setAuthor(ChatColor.stripColor(DataManager.getGroup(player).getDisplay() + " | " + player.getDisplayName() + " Left!"), null, "https://crafatar.com/avatars/" + player.getUniqueId() + "?overlay=1");
            LemonZero.mcChat.sendMessageEmbeds(builder.build(), new MessageEmbed[0]).queue();
            LemonZero.jda.getPresence().setActivity(Activity.playing("LemonZero.minehut.gg: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        }
    }
}
