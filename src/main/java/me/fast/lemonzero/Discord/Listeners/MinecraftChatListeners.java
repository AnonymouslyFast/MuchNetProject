 package me.fast.lemonzero.Discord.Listeners;

 import java.awt.Color;
 import me.fast.lemonzero.LemonZero;
 import me.fast.lemonzero.Minecraft.Utitites.LuckPerms;
 import net.dv8tion.jda.api.EmbedBuilder;
 import net.dv8tion.jda.api.entities.Activity;
 import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;
 import org.bukkit.event.player.PlayerJoinEvent;
 import org.bukkit.event.player.PlayerQuitEvent;




 public class MinecraftChatListeners
   implements Listener
 {
   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
     Player p = e.getPlayer();
     if (p.hasPlayedBefore()) {


       EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.green).setAuthor(ChatColor.stripColor(LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups) + " " + LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups)) + " Joined!", null, "https://crafatar.com/avatars/" + p.getUniqueId() + "?overlay=1");
       assert LemonZero.mcchat != null;
       LemonZero.mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
     }
     else {

       EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.YELLOW).setAuthor(ChatColor.stripColor(LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups) + " " + LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups)) + " Joined for the First Time!", null, "https://crafatar.com/avatars/" + p.getUniqueId() + "?overlay=1");
       assert LemonZero.mcchat != null;
       LemonZero.mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
     }
     LemonZero.jda.getPresence().setActivity(Activity.playing("LemonZero.minehut.gg: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
   }



   @EventHandler
   public void onQuit(PlayerQuitEvent e) {
     Player p = e.getPlayer();


     EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.red).setAuthor(ChatColor.stripColor(LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups) + " " + LuckPerms.getPlayerGroup(p, LuckPerms.possibleGroups)) + " Left!", null, "https://crafatar.com/avatars/" + p.getUniqueId() + "?overlay=1");
     assert LemonZero.mcchat != null;
     LemonZero.mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
     LemonZero.jda.getPresence().setActivity(Activity.playing("LemonZero.minehut.gg: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
   }

   @EventHandler
   private void onChat(AsyncPlayerChatEvent e) {
     if (e.getMessage().contains("@everyone")) {
       e.setCancelled(true);
     }
     if (e.getMessage().contains("@here")) {
       e.setCancelled(true);
     }

     if (!e.isCancelled()) {

       Player p = e.getPlayer();
       if (e.getMessage().contains("!")) {
         if (p.hasPermission("op"));
       }
       else {

         Player player = e.getPlayer();
         LemonZero.mcchat.sendMessage(ChatColor.stripColor("**Default " + player.getDisplayName()) + " »** " + ChatColor.stripColor("**Default " + player.getDisplayName())).queue();
       }
     }
   }
 }


