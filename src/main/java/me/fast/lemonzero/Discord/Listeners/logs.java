 package me.fast.lemonzero.Discord.Listeners;

 import me.fast.lemonzero.LemonZero;
 import net.dv8tion.jda.api.utils.TimeFormat;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerCommandPreprocessEvent;

 public class logs
   implements Listener
 {
   @EventHandler
   public void onCommand(PlayerCommandPreprocessEvent e) {
     Player p = e.getPlayer();
     LemonZero.logChan.sendMessage("**LemonZero** - " + TimeFormat.TIME_LONG.now() + " " + p.getName() + " Executed `" + e.getMessage() + "`").queue();
   }
 }


