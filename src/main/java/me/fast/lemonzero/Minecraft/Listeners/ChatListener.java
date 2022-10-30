 package me.fast.lemonzero.Minecraft.Listeners;

 import me.fast.lemonzero.LemonZero;
 import me.fast.lemonzero.Minecraft.Moderation.StaffChatCmd;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;





 public class ChatListener
   implements Listener
 {
   @EventHandler
   public void onChat(AsyncPlayerChatEvent e) {
     Player p = e.getPlayer();

     if (StaffChatCmd.StaffchatList.contains(p)) {
       e.setCancelled(true);
       ChatColor.broadcastToPerm(ChatColor.cc("&8&l[&6&lStaffChat&8&l] &f" + p.getName() + "&8: &f" + e.getMessage()), "staff");
       LemonZero.staff.sendMessage("**LemonZero** - " + p.getName() + ": " + e.getMessage()).queue();
     }
   }
 }


