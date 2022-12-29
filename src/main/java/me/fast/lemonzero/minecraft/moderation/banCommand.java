 package me.fast.lemonzero.minecraft.moderation;

 import java.util.Objects;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.BanList;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.jetbrains.annotations.NotNull;






 public class banCommand
   implements CommandExecutor
 {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) { Player p = (Player)sender;
       if (p.hasPermission("lemon.ban") &&
         args.length == 2) {
         Player offender = Bukkit.getPlayerExact(args[0]);
         if (offender != null) {
           Bukkit.getBanList(BanList.Type.NAME).addBan(Objects.requireNonNull(offender.getName()), args[1], null, p.getName());
           offender.sendMessage(ChatColor.cc("&4&lYou were Banned \n \n &c&l  Reason &8- &f" + args[1] + "\n  &c&lTime &8- &fPermanent \n  &c&lModerator &8- &f" + p.getName() + "\n  &c&lUnBan Request &8- &fhttps://discord.gg/6JrX9gmCy7"));
           offender.kickPlayer("");
           Bukkit.broadcastMessage(ChatColor.cc("&c&lPunishment System &8&l>> &d" + p.getName() + " &fBanned &d" + offender.getName() + " &ffor &5" + args[1]));
         }
       }  }




     return true;
   }
 }


