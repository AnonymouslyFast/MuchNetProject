 package me.fast.lemonzero.Minecraft.Moderation;

 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.jetbrains.annotations.NotNull;





 public class kickCMD
   implements CommandExecutor
 {
   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) {
       Player p = (Player)sender;
      if (p.hasPermission("lemon.kick")) {
         if (args.length == 1) {
           if (args[0].equalsIgnoreCase("help"))
           { p.sendMessage(command.getUsage()); }
           else { p.sendMessage(command.getUsage()); }
         } else if (args.length >= 2) {
           if (!args[1].equalsIgnoreCase("-s")) {
             Player p2 = Bukkit.getPlayerExact(args[0]);
             if (p2 != null) {
               p2.sendMessage(ChatColor.cc("&cYou were kicked! \n  &dReason: &f" + StaffChatCmd.arrayToString(args).replace(args[0], "") + "\n  &dModerator: &f" + p.getName()));
               p.kickPlayer("");
               Bukkit.broadcastMessage(ChatColor.cc("&c&lPunish System &8&l>> &d" + p.getName() + " &fkicked &b" + p2.getName() + "&f, for &5" + StaffChatCmd.arrayToString(args).replace(args[0], "")));
             } else {
               p.sendMessage(ChatColor.cc("&f(&c!&f)  &7That player does not exist!"));
             }
           } else if (args[1].equalsIgnoreCase("-s")) {
            Player p2 = Bukkit.getPlayerExact(args[0]);
             if (p2 != null) {
              p2.sendMessage(ChatColor.cc("&cYou were kicked! \n  &dReason: &f" + StaffChatCmd.arrayToString(args).replace(args[0], "").replace(args[1], "") + "\n  &dModerator: &f" + p.getName()));
               p.kickPlayer("");
               ChatColor.broadcastToPerm(ChatColor.cc("&c&lPunish System &7(for staff) &8&l>> &d" + p.getName() + " &fkicked &b" + p2.getName() + "&f, for &5" + StaffChatCmd.arrayToString(args).replace(args[0], "").replace(args[1], "")), "staff");
             } else {
              p.sendMessage(ChatColor.cc("&f(&c!&f)  &7That player does not exist!"));
             }
          }

         }
       }
     } else if (args.length == 1) {
       if (args[0].equalsIgnoreCase("help"))
       { System.out.println(command.getUsage()); }
       else { System.out.println(command.getUsage()); }  System.out.println(command.getUsage());
     } else if (args.length >= 2) {
       if (!args[1].equalsIgnoreCase("-s")) {
         Player p2 = Bukkit.getPlayerExact(args[0]);
         if (p2 != null) {
           p2.sendMessage(ChatColor.cc("&cYou were kicked! \n  &dReason: &f" + StaffChatCmd.arrayToString(args).replace(args[0], "") + "\n  &dModerator: &fCONSOLE"));
           p2.kickPlayer("");
           Bukkit.broadcastMessage(ChatColor.cc("&c&lPunish System &8&l>> &dCONSOLE &fkicked &b" + p2.getName() + "&f, for &5" + StaffChatCmd.arrayToString(args).replace(args[0], "")));
         } else {
           System.out.println("That player does not exists!");
         }
      } else {
         Player p2 = Bukkit.getPlayerExact(args[0]);
         if (p2 != null) {
          p2.sendMessage(ChatColor.cc("&cYou were kicked! \n  &dReason: &f" + StaffChatCmd.arrayToString(args).replace(args[0], "").replace(args[1], "") + "\n  &dModerator: &fCONSOLE"));
           p2.kickPlayer("");
           ChatColor.broadcastToPerm(ChatColor.cc("&c&lPunish System &7(for staff) &8&l>> &dCONSOLE &fkicked &b" + p2.getName() + "&f, for &5" + StaffChatCmd.arrayToString(args).replace(args[0], "").replace(args[1], "")), "staff");
         }
       }
     } else {
       System.out.println(command.getUsage());
     }

    return true;
   }
 }

