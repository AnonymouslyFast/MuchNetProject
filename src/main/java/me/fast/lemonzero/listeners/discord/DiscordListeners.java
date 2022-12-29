 package me.fast.lemonzero.listeners.discord;

 import me.fast.lemonzero.LemonZero;
 import me.fast.lemonzero.utils.DiscordUtils;
 import net.dv8tion.jda.api.entities.Member;
 import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
 import net.dv8tion.jda.api.hooks.ListenerAdapter;
 import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.jetbrains.annotations.NotNull;




 public class DiscordListeners extends ListenerAdapter implements DiscordUtils.Interface {
   public void onMessageReceived(@NotNull MessageReceivedEvent event) {
     if (event.getChannel() == LemonZero.mcChat) {
       Member member = event.getMember();
       if (!member.getUser().isBot()) {
           String msg = event.getMessage().getContentDisplay();
           Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b[&7Discord&b] &f" + member.getEffectiveName() + "&8: &f" + msg));
       }
     }
   }
 }


