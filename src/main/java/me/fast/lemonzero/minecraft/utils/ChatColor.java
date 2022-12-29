 package me.fast.lemonzero.minecraft.utils;
 import org.bukkit.Bukkit;
 import org.bukkit.entity.Player;

 public class ChatColor
 {
  public static String cc(String message) {
    return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
   }

   public static void broadcastToPerm(String msg, String perm) {
     for (Player player : Bukkit.getOnlinePlayers()) {
       if (player.hasPermission(perm))
        player.sendMessage(cc(msg));
    }
   }
 }


