 package me.fast.lemonzero.Discord.discordListeners;

 import me.fast.lemonzero.LemonZero;
 import net.dv8tion.jda.api.entities.Member;
 import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
 import net.dv8tion.jda.api.hooks.ListenerAdapter;
 import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.jetbrains.annotations.NotNull;




 public class discordListeners
   extends ListenerAdapter
 {
   public void onMessageReceived(@NotNull MessageReceivedEvent event) {
     if (event.getChannel() == LemonZero.mcchat) {
       Member member = event.getMember();
       if (member == null || member.getUser().isBot()) {
       } else {
           String msg = event.getMessage().getContentDisplay();
           Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b[&7Discord&b] &f" + member.getEffectiveName() + "&8: &f" + msg));
       }
     }
   }
 }


