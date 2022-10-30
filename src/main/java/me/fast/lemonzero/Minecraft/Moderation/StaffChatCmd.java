 package me.fast.lemonzero.Minecraft.Moderation;

 import java.util.ArrayList;
 import java.util.Arrays;
 import me.fast.lemonzero.LemonZero;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.jetbrains.annotations.NotNull;




 public class StaffChatCmd
   implements CommandExecutor
 {
   public static String arrayToString(String[] array) {
     return Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "");
   }

   public static ArrayList<Player> StaffchatList = new ArrayList<>();



   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) {
       Player p = (Player)sender;
       if (p.hasPermission("staff")) {     if (args.length > 0) {
           ChatColor.broadcastToPerm(ChatColor.cc("&8&l[&6&lStaffChat&8&l] &f" + p.getName() + "&8: &f" + arrayToString(args)), "staff");
           LemonZero.staff.sendMessage("**LemonZero** - " + p.getName() + ": " + arrayToString(args)).queue();
        }
         else if (StaffchatList.contains(p)) {
           StaffchatList.remove(p);
          p.sendMessage(ChatColor.cc("&6&lStaffChat turned off!"));
         } else {
           StaffchatList.add(p);
           p.sendMessage(ChatColor.cc("&6&lStaffChat turned on!"));
        }

       }
       else {

         p.sendMessage(ChatColor.cc("&cNo permission!"));
       }
     } else {

       System.out.println("This is only for Players!!");
     }



     return true;
   }
 }


