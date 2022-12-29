 package me.fast.lemonzero.minecraft.moderation;

 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.jetbrains.annotations.NotNull;



 public class ClearChatCmd
   implements CommandExecutor
 {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) {
       Player p = (Player)sender;
       if (p.hasPermission("staff")) {
         for (int i = 0; i <= 50; ) {
           Bukkit.broadcastMessage(" ");
          i++;
         }
         Bukkit.broadcastMessage(ChatColor.cc("&4&lChat was cleared by: &6&l" + p.getName()));
       } else {
         p.sendMessage(ChatColor.cc("&cNo permission!"));
       }
     } else {
       for (int i = 0; i <= 50; ) {
        Bukkit.broadcastMessage(" ");
         i++;
      }
       Bukkit.broadcastMessage(ChatColor.cc("&4&lChat was cleared by: &6&lCONSOLE"));
    }

    return true;
   }
 }


