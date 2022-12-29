 package me.fast.lemonzero.minecraft.moderation;

 import java.util.Objects;
 import me.fast.lemonzero.minecraft.moderation.CheckStuff.functions;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.jetbrains.annotations.NotNull;





 public class checkCMD
   implements CommandExecutor
 {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) { Player p = (Player)sender;
       if (p.hasPermission("lemon.check")) {
         if (args.length == 1) {
           Player player = Bukkit.getPlayerExact(args[0]);
           if (Objects.requireNonNull(player).hasPlayedBefore()) {
             p.sendMessage(ChatColor.cc("&7=== &d&l" + player.getName() + "&f's Punishment History &7=== \n \n &fWarns: &3" + functions.getPlayerWarns(p) + "\n &fMutes: &3" + functions.getPlayerMutes(p) + " \n &fBans: &3" + functions.getPlayerBans(p) + "\n"));
           } else {
             p.sendMessage("That player has not played before!");
           }
         } else {
           p.sendMessage(command.getUsage());
         }
       } else {
         p.sendMessage(ChatColor.cc("&cNo permission!"));
       }  }



     return true;
   }
 }


