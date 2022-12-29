 package me.fast.lemonzero.minecraft.utils;

 import java.util.ArrayList;
 import java.util.Collection;
 import org.bukkit.entity.Player;



 public class LuckPerms
 {
   public static ArrayList<String> possibleGroups = new ArrayList<>();

   public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
     for (String group : possibleGroups) {
       if (player.hasPermission("group." + group)) {
        return group;
       }
     }
     return "Default";
   }
 }


